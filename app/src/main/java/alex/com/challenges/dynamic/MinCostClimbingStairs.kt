package alex.com.challenges.dynamic

import java.lang.Integer.min

/**
 * Created by Alex Doub on 11/18/2019.
 */

class MinCostClimbingStairs {
    companion object {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val solution = mutableListOf<Int>()

            println("START")
            println("-----")
            println(cost.joinToString())

            // On each step, fill out the cost to arrive to the next 2 steps
            for (step in cost.indices) {
                // First iteration, must fill 3 total
                // First solution = first cost
                // Second solution = min first/second
                // third solution = second
                if (step == 0) {
                    solution.add(cost[step])
                    solution.add(min(cost[step], cost[step+1]))
                    solution.add(min(cost[step], cost[step+1]))
                    solution.add(cost[step+1])
                    println("Step_a $step. Sol: $solution")
                    println("-----")
                    continue
                }

                // Calc what we can push ahead to
                //Get cost to here, project +1 and +2 with this value (keep min)
                val costToHere = solution[step]
                val costToThere = costToHere + cost[step]

                solution.putIfLesser(step+1, costToThere)
                solution.putIfLesser(step+2, costToThere)

                println("Step_c $step. Sol: $solution")
                println("-----")
            }

            return solution[cost.size]
        }

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
    }
}