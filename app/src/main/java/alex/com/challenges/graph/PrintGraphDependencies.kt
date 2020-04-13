package alex.com.challenges.graph

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

/**
 * Created by Alex Doub on 2/21/2020.
 *
 * Note: Parallel and concurrent are NOT the same thing.
 * Parallel = multithread running at exact same time
 * Concurrent = multithread but switching off
 */

object MyApi {
    private val delay = 100L
    private fun getResult(id: String): List<String> {
        return  when (id) {
            "A" -> listOf("B")
            "B" -> listOf("C")
            "C" -> listOf("D")
            "D" -> listOf("X", "Y", "Z")
            "X" -> listOf("Z")
            "Y" -> listOf("Z")
            "Z" -> listOf("Core")
            else -> emptyList()
        }

//        return when (id) {
//            "A" -> listOf("B", "C", "D", "Z", "ZZ")
//            "B" -> listOf("C", "D", "Z", "ZZ")
//            "C" -> listOf("D", "Z", "ZZ")
//            "D" -> listOf("Z", "ZZ")
//            else -> emptyList()
//        }
    }

    suspend fun getDependencyCr(id: String): List<String> {
        var result: List<String>? = null
        withContext(Dispatchers.IO) {
            delay(delay)    // simulate network library fetching data on separate thread
            result = getResult(id)
        }
        return result!!
    }

    fun getDependencyRx(id: String): Single<List<String>> {
        return Single.just(getResult(id))
            .delay(delay, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
    }

    fun getDependencyKotlin(id: String, callback: (List<String>) -> Unit) {
        GlobalScope.launch {
            delay(delay)
            callback(getResult(id))
        }
    }
}

object PrintGraphDependenciesRX {

    private fun printDependencies(id: String, deps: List<String>) {
        for (d in deps) {
            println("  $id -> $d ............ ${Thread.currentThread().name}")
        }
    }

    fun printDependencyGraph() {
        val explored = ArrayList<String>()

        fun explore(id: String): Completable {
            explored.add(id)
            println("             Exploring $id ............ ${Thread.currentThread().name}")
            return MyApi.getDependencyRx(id)
                .observeOn(Schedulers.single())
                .flatMapCompletable { thoseDeps ->
                    printDependencies(id, thoseDeps)
                    // This job is done with all the sub-jobs are done
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

// WORKS but you have to manually block the scratch file until the callbacks complete
object PrintGraphDependenciesKotlin {

    private val explored = ArrayList<String>()
    private var jobs = 0

    fun printDependencyGraph() {
        val startTime = System.currentTimeMillis()
        println("{")
        fetchDepsAsync("A") {
            if (jobs == 0) {
                jobs = -1000
                println("}")
                println("Finished in ${System.currentTimeMillis() - startTime}ms")
            }
        }

    }

    private fun fetchDepsAsync(id: String, checkIfDone: () -> Unit) {
        if (explored.contains(id)) return

        jobs++
        explored.add(id)
        println("             Exploring $id ............ Explored:${explored.joinToString()}")

        MyApi.getDependencyKotlin(id) { newDeps ->
            jobs--
            printDependencies(id, newDeps)
            for (d in newDeps) {
                fetchDepsAsync(d, checkIfDone)
            }
            checkIfDone()
        }
    }

    private fun printDependencies(id: String, deps: List<String>) {
        for (d in deps) {
            println("  $id -> $d ............ ${Thread.currentThread().name}")
        }
    }
}

object PrintGraphDependenciesCr {

    fun printDependencyGraph() {
        //Kick off & block until its finished
        runBlocking {
            val startTime = System.currentTimeMillis()
            println("{")
            explore(this, ArrayList(), "A")
            println("}")
            println("Finished! in ${System.currentTimeMillis() - startTime}ms")
        }
    }

    private suspend fun explore(scope: CoroutineScope, explored: ArrayList<String>, id: String) {
        println("             Exploring $id ............ ${Thread.currentThread().name}")
        explored.add(id)

        val deps = MyApi.getDependencyCr(id)
        printDependencies(id, deps)

        val newDeps = deps - explored
        val newJobs: Collection<Job> = newDeps.map { newDep ->
            scope.launch {
                explore(this, explored, newDep)
            }
        }
        newJobs.joinAll()
    }

    private fun printDependencies(id: String, deps: List<String>) {
        for (d in deps) {
            println("  $id -> $d ............ ${Thread.currentThread().name}")
        }
    }
}