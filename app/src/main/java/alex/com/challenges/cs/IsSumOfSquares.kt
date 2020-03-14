package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/14/2020.
 * https://leetcode.com/problems/sum-of-square-numbers/
 */

object IsSumOfSquares {
    //Sliding window
    fun judgeSquareSum(c: Int): Boolean {
        var low = 0
        var high = Math.sqrt(c.toDouble()).toInt()
        while (low <= high) {
            val lowSq = low * low
            val highSq = high * high
            val sum = lowSq + highSq
            when {
                sum == c -> return true
                sum < c -> low++
                else -> high--
            }
        }
        return false
    }
}