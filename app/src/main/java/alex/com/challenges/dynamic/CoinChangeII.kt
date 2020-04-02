package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 4/1/2020.
 * https://leetcode.com/problems/coin-change-2/
 *
 * // NOTE: Similar to knapsack problem
 */

object CoinChangeII {

    // Borrowed
    // Outer loop coins, inner loop dp indexes.
    // Extend values from previous values
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (coin in coins) {
            for (dx in dp.indices) {
                if (dx - coin >= 0) dp[dx] += dp[dx - coin]
            }
        }
        return dp[amount]
    }


    // Combination, order doesnt matter
    // Only return int, DP is optimal
    /**
     * Fails on: 500 [3,5,7,8,9,10,11]
     *
     * This needs memoization to work
     * */
    fun change_naive_recursive(amount: Int, coins: IntArray): Int {
        var sum = 0
        coins.sort()
        fun getSums(index: Int, rem: Int) {
            if (rem == 0) {
                sum++
                return
            }

            for (ci in index..coins.lastIndex) {
                val c = coins[ci]
                if (c > rem) break

                getSums(ci, rem - c)
            }

        }
        getSums(0, amount)
        return sum
    }
}