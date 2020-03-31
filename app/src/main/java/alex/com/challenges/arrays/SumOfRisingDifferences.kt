package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/30/2020.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

object SumOfRisingDifferences {
    fun maxProfit(prices: IntArray): Int {
        var last = Int.MAX_VALUE
        var sum = 0
        for (p in prices) {
            if (p > last) sum += p - last
            last = p
        }

        return sum
    }
}