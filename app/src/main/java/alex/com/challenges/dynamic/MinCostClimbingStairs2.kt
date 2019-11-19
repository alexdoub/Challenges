package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/18/2019.
 * https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
 *
 * Simpler and faster solution using primitives and no debug/convenience stuff
 */

class MinCostClimbingStairs2 {
    companion object {
        fun minCostClimbingStairs(cost: IntArray): Int {

            //Calculate cost to get there
            //build solution graph, return solution for the end (of cost input
            val solutionGraph = IntArray(cost.size + 2) //+2 cuz we calculate 2 ahead

            // Base case, two are free
            solutionGraph[0] = 0
            solutionGraph[1] = 0

            for (step in cost.indices) {

                val costToProject = solutionGraph[step] + cost[step]

                // Calc first step. Replace if lesser
                if (solutionGraph[step+1] > costToProject) {
                    solutionGraph[step+1] = costToProject
                }

                solutionGraph[step+2] = costToProject
            }

            return solutionGraph[cost.size]
        }
    }
}