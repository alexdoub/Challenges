package alex.com.challenges

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

/**
 * Created by Alex Doub on 2/21/2020.
 */

object MyApi {
    private val delay = 100L
    private fun getResult(id: String): List<String> {
//        return  when (id) {
//            "A" -> listOf("B")
//            "B" -> listOf("C")
//            "C" -> listOf("D")
//            "D" -> listOf("X", "Y", "Z")
//            "X" -> listOf("Z")
//            "Y" -> listOf("Z")
//            "Z" -> listOf("Core")
//            else -> emptyList()
//        }

        return when (id) {
            "A" -> listOf("B", "C", "D", "Z")
            "B" -> listOf("C", "D")
            "C" -> listOf("D")
            "D" -> listOf("Z")
            else -> emptyList()
        }
    }

    suspend fun getDependencyCr(id:String): List<String> {
        delay(delay)
        return getResult(id)
    }

    fun getDependencyRx(id: String): Single<List<String>> {
        return Single.just(getResult(id))
            .delay(delay, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
    }
}

object PrintGraphDependenciesRX {

    fun printDependencyGraph() {
        val explored = ArrayList<String>()

        fun printDependencies(id: String, deps: List<String>) {
            for (d in deps) { println("  $id -> $d ............ ${Thread.currentThread().name}") }
        }

        fun explore(id: String): Completable {
            explored.add(id)
            println("             Exploring $id")
            return MyApi.getDependencyRx(id)
                .observeOn(Schedulers.single())
                .flatMapCompletable { thoseDeps ->
                    printDependencies(id, thoseDeps)
                    return@flatMapCompletable Observable.fromIterable(thoseDeps - explored)
                        .flatMapCompletable { explore(it) }
                }
        }

        val startTime = System.currentTimeMillis()
        println("{")
        explore("A").blockingAwait()
        println("}")
        println("Finished in ${System.currentTimeMillis() - startTime}ms")
    }
}

object PrintGraphDependenciesKotlin {

    private val main = Thread()
    private val explored = ArrayList<String>()

    fun topologicalSort_kotlin() {
        println("{")
        fetchDepsAsync("A")
        println("}")
    }

    private fun markPrintThenFetchSeparately(id: String, deps: List<String>) {
        explored.add(id)
        for (d in deps-explored) {
            println("  $id -> $d")
            fetchDepsAsync(d)
        }
    }

    private fun fetchDepsAsync(id: String) {
        Thread.currentThread().run {
            val theseDeps = MyApi.getDependencyRx(id).blockingGet()
            markPrintThenFetchSeparately(id, theseDeps)
        }
    }
}

// BROKEN -- compilation error wtf
object PrintGraphDependenciesCr {
    fun printDependencyGraph() {
        println("{")
        val explored = ArrayList<String>()


        fun printDependencies(id: String, deps: List<String>) {
            for (d in deps) { println("  $id -> $d") }
        }

        suspend fun explore(scope: CoroutineScope, id: String) {
            println("             Exploring $id")
            explored.add(id)

            val deps = MyApi.getDependencyCr(id)
            printDependencies(id, deps)

//            val newDeps = deps - explored
//            val newJobs = newDeps.map { newDep ->
//                scope.launch { explore(this, newDep) }
//            }
//            newJobs.joinAll()
        }

        // Kick off & block until its finished
        runBlocking {
            explore(this, "A")
        }
        println("}")
    }
}