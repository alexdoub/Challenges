package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/25/2019.
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */

class DiceRollsWithTargetSum {
    companion object {

        // Blind Redo
        fun numRollsToTarget(d: Int, f: Int, target: Int): Int {

            if (d < 1 || f < 1 || target < 1) return 0

            val MOD = 1_000_000_007

            var dp = IntArray(target + 1)

            //Initial roll
            for (x in 1..f) {
                if (x <= target) dp[x] = 1
            }

            // successive rolls
            //make new rows so work-in-progress doesnt fuck up math
            for (times in 2 .. d) {
                val newDp = IntArray(target + 1)

                //loop over rows, on every cell add all rolls
                // added must come from previous rows
                for (x in 0..target) {
                    for (roll in 1..f) {
                        if (x + roll <= target) newDp[x+roll] = (newDp[x+roll] + dp[x]) % MOD
                    }
                }

                dp = newDp
            }
            return dp[target]
        }


//        fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
//            val mod = 1_000_000_007
//
//            //1st iteration - base case -- fill
//            var solution = IntArray(target + 1)
//            solution.fill(1, 1, Math.min(target, f) + 1)
//
//            //Loop iteration -- Replace DP array with updated array including this dice
//            (2..d).forEach { _ ->
//                val newSolution = IntArray(target + 1)
//                (1..solution.size).forEach { index ->
//                    (1..f).forEach { newRoll ->
//                        if (index + newRoll <= target) {
//                            val newTotal = (solution[index] + newSolution[index + newRoll]) % mod
//                            newSolution[index + newRoll] = newTotal
//                        }
//                    }
//                }
//                solution = newSolution
//            }
//
//            return solution.last()
//        }

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