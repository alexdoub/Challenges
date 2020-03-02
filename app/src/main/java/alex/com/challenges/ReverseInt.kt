package alex.com.challenges

/**
 * Created by Alex Doub on 3/1/2020.
 * https://leetcode.com/problems/reverse-integer/
 */

object ReverseInt {

    // Uses overflow ceiling.... unnecessarily complicated
    fun reverse1(originalValue: Int): Int {
        var isNegative = originalValue < 0
        var originalValue = Math.abs(originalValue)
        var sum = 0

        val overflowCeiling = (Int.MAX_VALUE / 10)

        while (originalValue > 0) {
            val thisDigit = originalValue % 10

            // Edge case overflow check -- NOTE: 2nd condition not applicable unless input is LONG
            if (sum > overflowCeiling || sum == overflowCeiling && thisDigit > 7) {
                return 0
            }

            sum = (sum * 10) + thisDigit
            originalValue /= 10
        }

        if (isNegative) {
            sum = 0 - sum
        }
        return sum
    }

    // Uses simpler check for overflow
    fun reverse2(originalValue: Int): Int {
        var isNegative = originalValue < 0
        var originalValue = Math.abs(originalValue)
        var sum = 0

        while (originalValue > 0) {
            val thisDigit = originalValue % 10
            val newSum = (sum * 10) + thisDigit

            // Overflow check
            if (newSum / 10 != sum) return 0

            sum = newSum
            originalValue /= 10
        }

        if (isNegative) {
            sum = 0 - sum
        }
        return sum
    }
}