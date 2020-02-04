package alex.com.challenges

/**
 * Created by Alex Doub on 2/3/2020.
 * https://leetcode.com/problems/course-schedule/
 */

class CourseSchedule {
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

                // see what this opens
                accessibilityMap[node]!!.forEach {

                    //explore it if all dependencies have been fulfilled
                    if (dependencyMap[it]!!.all { reached[it] }) {
                        explore(it)
                    }
                }
            }

            // Begin by exploring tails (tails have no dependencies)
            dependencyMap.filter { it.value.isEmpty() }.map { it.key }.forEach {
                explore(it)
            }

            return reached.all { it }
        }
    }
}