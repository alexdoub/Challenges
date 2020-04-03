package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 4/2/2020.
 * https://leetcode.com/problems/house-robber/
 */

object RobHouses {

    fun rob(nums: IntArray): Int {

        var oneback = 0
        var twoback = 0
        var threeback = 0
        for (num in nums) {

            val thisSum = num + Math.max(twoback, threeback)

            threeback = twoback
            twoback = oneback
            oneback = thisSum
        }

        return Math.max(oneback, twoback)
    }

    //DP -- slow
    fun rob_dp(nums: IntArray): Int {

        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]

        // do in 1d array
        val dp = IntArray(nums.size)

        for (dx in dp.indices) {
            val twoback = if (dx >= 2) dp[dx-2] else 0
            val threeback = if (dx >= 3) dp[dx-3] else 0
            dp[dx] = nums[dx] + Math.max(twoback, threeback)
        }

        return Math.max(dp[dp.lastIndex], dp[dp.lastIndex - 1])
    }
}