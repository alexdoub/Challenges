package alex.com.challenges

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Alex Doub on 2/21/2020.
 */

object MyApi {
    fun getDependency(id: String): Single<List<String>> {

        val result = when (id) {
            "A" -> listOf("B", "C")
            "B" -> listOf("C")
            "C" -> listOf("D")
            else -> emptyList()
        }
        return Single.just(result)
            .delay(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.computation())
    }
}

object PrintGraphDependencies {

    fun topologicalSort() {
        val explored = ArrayList<String>()

        fun explore(id: String): Completable {
            return MyApi.getDependency(id)
                .doOnSuccess { println(" ..... fetched list of deps from $id on ${Thread.currentThread().name} ") }
                .observeOn(Schedulers.single())
                .flattenAsObservable { it }
                .filter { !explored.contains(it) }
                .flatMapCompletable {
                    println("$id -> $it  -- loaded on thread:${Thread.currentThread().name}")
                    return@flatMapCompletable explore(it)
                }
        }

        println("{")
        explore("A").blockingAwait()
        println("}")
    }
}