package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/25/2019.
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */

class DiceRollsWithTargetSum {
    companion object {

        fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
            val mod = 1_000_000_007

            //1st iteration - base case -- fill
            var solution = IntArray(target + 1)
            solution.fill(1, 1, Math.min(target, f) + 1)

            //Loop iteration -- Replace DP array with updated array including this dice
            (2..d).forEach { _ ->
                val newSolution = IntArray(target + 1)
                (1..solution.size).forEach { index ->
                    (1..f).forEach { newRoll ->
                        if (index + newRoll <= target) {
                            val newTotal = (solution[index] + newSolution[index + newRoll]) % mod
                            newSolution[index + newRoll] = newTotal
                        }
                    }
                }
                solution = newSolution
            }

            return solution.last()
        }

        fun numRollsToTarget_2Dmatrix(d: Int, f: Int, target: Int): Int {

            val mod = 1_000_000_007
            val solutionGraph =
                Array<IntArray>(d) { IntArray(target + 1) } //Represents "unique ways to arrive at this number" for this dice count

            // Base case
            (1..f).forEach {
                if (it < solutionGraph[0].size) {
                    solutionGraph[0][it] = 1
                }
            }

            // For each dice, fill out a sum row
            (1 until solutionGraph.size).forEach { dice ->

                //For every face on the die, propagate new sums for this dice
                (1..f).forEach { face ->

                    // Enumerate calculated rows, update solution graph for this dice face
                    solutionGraph[dice - 1].forEachIndexed { index, value ->
                        if (index + face < solutionGraph[dice].size) {
                            solutionGraph[dice][index + face] += value
                            solutionGraph[dice][index + face] = solutionGraph[dice][index + face] % mod
                        }
                    }
                }
            }

            return solutionGraph[d - 1][target]
        }
    }
}

//Build 2D array
//Rows = Solutions with this dice
//Columns = with this dice, heres how many options can add up to this