package alex.com.challenges.graph

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
            "A" -> listOf("B", "C", "D", "Z", "ZZ")
            "B" -> listOf("C", "D", "Z", "ZZ")
            "C" -> listOf("D", "Z", "ZZ")
            "D" -> listOf("Z", "ZZ")
            else -> emptyList()
        }
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
        getDependencyRx(id).subscribe { newDeps -> callback(newDeps) }
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

//BROKEN: Cant kick off a bunch of async callbacks on the same thread & know when they're done
//object PrintGraphDependenciesKotlin {
//
//    val thread = Thread()
//
//    private val explored = ArrayList<String>()
//    var jobs = 0
//
//    fun printDependencyGraph() {
//        val startTime = System.currentTimeMillis()
//        println("{")
//        thread.run {
//            fetchDepsAsync("A") {
//                if (jobs == 0) {
//                    println("}")
//                    println("Finished in ${System.currentTimeMillis() - startTime}ms")
//                    thread.stop()
//                } else {
//                    println("Still waiting on $jobs jobs")
//                }
//            }
//        }
//        println("b4 join")
//        thread.join()
//        println("past join")
//    }
//
//    private fun fetchDepsAsync(id: String, checkIfDone: () -> Unit) {
//        Thread.currentThread().run {
//            if (explored.contains(id)) return
//
//            jobs++
//            explored.add(id)
//            println("             Exploring $id ............ Explored:${explored.joinToString()}")
//
//            MyApi.getDependencyKotlin(id) { newDeps ->
//                printDependencies(id, newDeps)
//                for (d in newDeps) {
//                    fetchDepsAsync(d, checkIfDone)
//                }
//                checkIfDone()
//            }
//        }
//    }
//
//    private fun printDependencies(id: String, deps: List<String>) {
//        for (d in deps) {
//            println("  $id -> $d ............ ${Thread.currentThread().name}")
//        }
//    }
//}

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