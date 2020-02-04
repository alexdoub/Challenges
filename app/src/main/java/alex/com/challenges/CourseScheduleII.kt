package alex.com.challenges

/**
 * Created by Alex Doub on 2/3/2020.
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * Essentially this is the same as CourseScheduleI but with returning the order. Just store that & reuse the old algo
 */

class CourseScheduleII {
    companion object {
        fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
            // Make dependency map for quick lookups
            val dependencyMap = mutableMapOf<Int, ArrayList<Int>>()
            //Invert to create accessibility map
            val accessibilityMap = mutableMapOf<Int, ArrayList<Int>>()

            // Init maps
            (0 until numCourses).forEach {
                dependencyMap[it] = ArrayList()
                accessibilityMap[it] = ArrayList()
            }

            // Loop input and fill out maps
            prerequisites.forEach { pair ->
                val node = pair[0]
                val dependency = pair[1]
                dependencyMap[node]!!.add(dependency)
                accessibilityMap[dependency]!!.add(node)
            }

            // Make BooleanArray representing reachable states
            val reached = BooleanArray(numCourses)
            val reachedOrder = ArrayList<Int>()

            // Define recursive function to explore nodes. Add nodes as they are explored
            fun explore(node: Int) {
                if (reached[node]) return
                reached[node] = true
                reachedOrder.add(node)

                // See what filling out this can access (reverse dependency)
                accessibilityMap[node]!!.forEach {

                    // Explore it if possible
                    val dependenciesFulFilled = dependencyMap[it]!!.all { reached[it] }
                    if (dependenciesFulFilled) {
                        explore(it)
                    }
                }
            }

            // Begin by exploring tails (tails have no dependencies)
            dependencyMap.filter { it.value.isEmpty() }.map { it.key }.forEach {
                explore(it)
            }

            // Return ordering, depending on if we reached everything
            val rVal = if (reachedOrder.size == numCourses) {
                reachedOrder
            } else {
                emptyList<Int>()
            }
            return rVal.toIntArray()
        }
    }
}