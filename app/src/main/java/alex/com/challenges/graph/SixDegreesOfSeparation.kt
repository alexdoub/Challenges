package alex.com.challenges.graph

import java.util.Collections.emptyList

/**
 * Created by Alex Doub on 3/16/2020.
 */

object SixDegreesOfSeparation {
    data class People(
        val name: String,
        var friends: List<People> = emptyList()
    )

    data class Path(
        var degrees: Int,
        var next: List<People>
    )

    // 1 way BFS
    // Ideally this is 2 way
    fun findDegree(a: People, b: People): Int {

        val searchList = ArrayList<Path>()
        searchList.add(Path(0, a.friends))

        val seen = ArrayList<String>()

        while (searchList.isNotEmpty()) {
            val thisPath = searchList.removeAt(0)

            // base case - are we at the target?
            if (thisPath.next.any { it.name == b.name }) {
                return thisPath.degrees
            }

            //seen.addAll(thisPath.next.map{ it.name })


            val nextPaths = thisPath.next
                .filter { !seen.contains(it.name) }
                .map {
                    seen.add(it.name)
                    Path(thisPath.degrees + 1, it.friends)
                }

            searchList.addAll(nextPaths)
        }


        return -1
    }

}