package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 4/1/2020.
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * NOTE: THIS IS PERMUTATIONS. ORDER MATTERS
 */

object CombinationSumIV {

    // Borrowed
    // Outer loop dp index, inner loop numbers
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1)
        dp[0] = 1

        //Loop over DP
        for (dx in 1..target) {
            // Loop over nums, try to extend without going under 0
            for (num in nums) {
                if (dx >= num) dp[dx] += dp[dx - num]
            }
        }

        return dp[target]
    }

    //Failed DP strat: Loop over nums, inner loop over target (propagate ahead). Too many crazy cases in simple iteration


    // Fails on [2,1,3] 35
    // Branches a fuckton. Cant use sort trick because this is PERMUTATIONS where order matters. In fact, don't even need used array...
    fun combinationSum4_recursive(nums: IntArray, target: Int): Int {

        var sum = 0
        fun getSums(rem: Int) {

            if (rem == 0) sum++
            if (rem <= 0) return

            for (num in nums) {
                getSums(rem - num)
            }
        }
        getSums(target)

        return sum
    }
}