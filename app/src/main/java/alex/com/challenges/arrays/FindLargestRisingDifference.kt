package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/29/2020.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

object FindLargestRisingDifference {
    fun maxProfit(prices: IntArray): Int {
        var maxDifference = 0
        var min = Int.MAX_VALUE
        for (p in prices) {
            if (p < min) min = p

            val diff = p - min
            if (diff > maxDifference) maxDifference = diff
        }
        return maxDifference
    }
}