package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/18/2019.
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */

class MinCostClimbingStairs {
    companion object {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val solution = mutableListOf<Int>()

            printDebug("START")
            printDebug("-----")
            printDebug(cost.joinToString())

            // Base - First two steps cost nothing to get to
            solution.add(0)
            solution.add(0)

            // On each step, fill out the cost to arrive to the next 2 steps
            for (step in cost.indices) {
                // Calc what we can push ahead to
                //Get cost to here, project +1 and +2 with this value (keep min)
                val costToHere = solution[step]
                val costToThere = costToHere + cost[step]

                solution.putIfLesser(step + 1, costToThere)
                solution.putIfLesser(step + 2, costToThere)

                printDebug("Step_c $step. Sol: $solution")
                printDebug("-----")
            }

            return solution[cost.size]
        }

        //Convenience function to simplify above block
        fun MutableList<Int>.putIfLesser(position: Int, value: Int) {
            if (this.size < position) {
                throw RuntimeException("cant skip ahead!")
            } else {
                val existing = this.getOrNull(position)

                if (existing == null) {
                    this.add(value)
                } else {
                    if (value < existing) {
                        this.removeAt(position)
                        this.add(value)
                    }
                }
            }
        }

        val debug = false
        fun printDebug(string: String) {
            if (debug) println(string)
        }
    }
}