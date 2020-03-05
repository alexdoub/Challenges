package alex.com.challenges.graph

/**
 * Created by Alex Doub on 2/3/2020.
 * https://leetcode.com/problems/course-schedule/
 */

class CourseScheduleI {
    companion object {
        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
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

            // Define recursive function to explore nodes
            fun explore(node: Int) {
                if (reached[node]) return
                reached[node] = true

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

            // Return whether or not all nodes have been reached
            return reached.all { it }
        }
    }
}