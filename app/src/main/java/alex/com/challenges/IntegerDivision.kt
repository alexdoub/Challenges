package alex.com.challenges

import kotlin.math.abs

/**
 * 11/28/19 (proper)
 * https://leetcode.com/problems/divide-two-integers/
 */

class IntegerDivision {
    companion object {

        fun printDebug(string: String) {
            if (false) println(string)
        }

        fun divide(dividend: Int, divisor: Int): Int {
            printDebug("Dividing ${dividend} by ${divisor}")

            //Edge cases: int min. (cant flip to abs value)
            if (dividend == Int.MIN_VALUE && divisor == -1) {
                return Int.MAX_VALUE
            }
            if (divisor == Int.MIN_VALUE) {
                return if (dividend == Int.MIN_VALUE) 1 else 0
            }
            val edgeCaseIntMin = dividend == Int.MIN_VALUE

            var result = 1
            var mutableDivisor = divisor
            var mutableDividend = dividend
            var isNegative = false

            // Handle negative divisor
            if (mutableDivisor < 0) {
                mutableDivisor = abs(mutableDivisor)
                isNegative = !isNegative
                printDebug("... did flip negative dividend")
            }

            // Handle negative dividend (account for int min edge case!)
            if (mutableDividend < 0) {

                //If our dividend was int min, it will roll over when we flip it
                //solution: take off 1 now, add it back to the remainder
                if (edgeCaseIntMin) {
                    mutableDividend += 1
                }

                mutableDividend = abs(mutableDividend)
                isNegative = !isNegative
                printDebug("... did flip negative dividend")
            }

            // Early return if we cannot divide this
            if (mutableDividend < mutableDivisor || mutableDividend == 0) {
                printDebug("... reached a 0")
                return 0
            }

            //Find the biggest divisor we can do (without rolling over)
            while (
                mutableDividend > (mutableDivisor shl 1)
                && mutableDivisor < 1 shl 30
            ) {
                mutableDivisor = mutableDivisor shl 1
                result = result shl 1
                printDebug("... did a bitshift")
            }
            var remainder = mutableDividend - mutableDivisor
            if (edgeCaseIntMin) {
                remainder += 1
            }

            printDebug("... did final subtraction before branch. ${mutableDividend} - ${mutableDivisor}")

            result += divide(remainder, abs(divisor))

            if (isNegative) {
                result = 0 - result
                printDebug("... did flip result cause negative")
            }

            return result
        }

        fun divide_crappy(dividend: Int, divisor: Int): Int {
            val dividendLong = dividend.toLong()
            val divisorLong = divisor.toLong()

            var absDividend = if (dividendLong < 0) abs(dividendLong) else dividendLong
            var absDivisor = if (divisorLong < 0) abs(divisorLong) else divisorLong
            var count = 0
            while (absDividend >= absDivisor) {

                //Quick divide (speed requirements lolol)
                if (absDividend > absDivisor * 100000) {
                    absDividend -= absDivisor * 100000
                    count += 100000
                } else {
                    absDividend -= absDivisor
                    count += 1
                }
            }

            //invert negative
            if (divisorLong < 0) {
                count = 0 - count
            }
            if (dividendLong < 0) {
                count = 0 - count
            }

            //edge case lolol
            //TODO: Use proper bitwise rollover. dont use longs. STATUS: DONE!
            if (count == Int.MIN_VALUE && dividend < 0 && divisor < 0) {
                return Int.MAX_VALUE
            }

            return count
        }
    }
}