package alex.com.challenges

import java.util.*

/**
 * Created by Alex Doub on 12/7/2019.
 *
 * Modified version of MinimumPathSum where you CAN go in all directions. Simple BFS search
 * https://leetcode.com/problems/minimum-path-sum/
 */

class MinimumPath4DSum {
    companion object {

        fun minPathSum(grid: Array<IntArray>): Int {
            val solution = Array(grid.size) { IntArray(grid[0].size) }

            for (y in 0 until grid.size) {
                for (x in 0 until grid[y].size) {
                    //This value is the cost of this cell PLUS the min of both the existing left/up sums
                    val left: Int? = if (x == 0) null else solution[y][x - 1]
                    val top: Int? = if (y == 0) null else solution[y - 1][x]

                    val thisSum = (listOfNotNull(left, top).min() ?: 0) + grid[y][x]
                    solution[y][x] = thisSum
                }
            }

            return solution.last().last()
        }


        private fun debugPrint(string: String) {
            if (false) println(string)
        }

        private class State(val visited: Array<BooleanArray>, var x: Int, var y: Int, var sum: Int) : Comparable<State> {
            override fun compareTo(other: State): Int {
                return sum - other.sum
            }

            fun copy(): State {
                val visitedCopy = visited.copyOf()
                (visited.indices).forEach {
                    visitedCopy[it] = visited[it].copyOf()
                }

                return State(visitedCopy, x, y, sum)
            }
        }

        fun minPathSum_modified(grid: Array<IntArray>): Int {
            val states = PriorityQueue<State>()

            // Initial state
            val initialVisited = Array(grid.size) {
                BooleanArray(grid[0].size)
            }
            initialVisited[0][0] = true
            states.add(State(initialVisited, 0, 0, grid[0][0]))




            while (states.isNotEmpty()) {
                val state = states.poll()!!

                debugPrint("Checking state: ${state.x}, ${state.y}")

                //Check if this state won
                if (state.y == grid.size - 1 && state.x == grid[0].size - 1) {
                    debugPrint("...win state!")
                    return state.sum
                }


                //Make new states for each direction & add them in queue
                // can go right
                if (state.x != grid[0].size - 1 && !state.visited[state.y][state.x + 1]) {
                    val copy = state.copy()
                    copy.x += 1
                    copy.visited[state.y][state.x + 1] = true
                    copy.sum += grid[state.y][state.x + 1]
                    states.add(copy)
                    debugPrint("...can go right")
                }


                // can go left
                if (state.x != 0 && !state.visited[state.y][state.x - 1]) {
                    val copy = state.copy()
                    copy.x -= 1
                    copy.visited[state.y][state.x - 1] = true
                    copy.sum += grid[state.y][state.x - 1]
                    states.add(copy)
                    debugPrint("...can go left")
                }

                // can go down
                if (state.y != grid.size - 1 && !state.visited[state.y + 1][state.x]) {
                    val copy = state.copy()
                    copy.y += 1
                    copy.visited[state.y + 1][state.x] = true
                    copy.sum += grid[state.y + 1][state.x]
                    states.add(copy)
                    debugPrint("...can go down")
                }

                // can go up
                if (state.y != 0 && !state.visited[state.y - 1][state.x]) {
                    val copy = state.copy()
                    copy.y -= 1
                    copy.visited[state.y - 1][state.x] = true
                    copy.sum += grid[state.y - 1][state.x]
                    states.add(copy)
                    debugPrint("...can go up")
                }
            }


            return -1
        }
    }
}