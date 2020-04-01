package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 4/1/2020.
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * NOTE: THIS IS PERMUTATIONS. ORDER MATTERS
 */

object CombinationSumIV {

    // Borrowed
    // Count up target, try propagating nums
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1)
        dp[0] = 1

        //Loop over DP
        for (i in 1..target) {
            for (num in nums) {
                if (i >= num) {
                    dp[i] += dp[i - num]
                }
            }
        }

        return dp[target]
    }


    //Failed strat: Loop over nums, inner loop over target (propagate ahead). Too many crazy cases in simple iteration
}