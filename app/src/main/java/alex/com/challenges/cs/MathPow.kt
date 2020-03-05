package alex.com.challenges.cs

/**
 * Created by Alex Doub on 1/8/2020.
 * https://leetcode.com/problems/powx-n/
 */

class MathPow {
    companion object {
        fun myPow(x: Double, n: Int): Double {

            if (x == 1.0) {
                return 1.0
            }

            var X = x
            val isNeg = n < 0
            var N = Math.abs(n.toLong())
            var sum = 1.0

            while (N > 0) {
                if (N % 2 == 1L) {
                    sum *= X
                    N--
                } else {
                    X = X * X
                    N = N / 2
                }
            }

            if (isNeg) {
                sum = 1.0 / sum
            }
            return sum
        }
    }
}
//
// 1) When dealing with doubles, ALWAYS DO .0 FOR CONSTANTS
// 2) Never do a super-simple loop. Try to simplify
// 3) Be careful about absolute value because of Int_MIN