package alex.com.challenges

import kotlin.math.abs

class IntegerDivision {
    companion object {

        fun divide(dividend: Int, divisor: Int): Int {
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
            if (count == Int.MIN_VALUE && dividend < 0 && divisor < 0) {
                return Int.MAX_VALUE
            }

            return count
        }
    }
}