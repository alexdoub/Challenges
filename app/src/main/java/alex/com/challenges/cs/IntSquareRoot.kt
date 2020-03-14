package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/14/2020.
 * https://leetcode.com/problems/sqrtx/
 */

object IntSquareRoot {
    fun mySqrt(x: Int): Int {
        if (x == 1) return 1    //edge case. return's -1 is broken

        //Sliding window
        var left = 1
        var right = x / 2
        while (left <= right) { //<= so left always gets pushed 1 too high
            val mid = (left + right) / 2
            if (mid > (x / mid)) {  // dont do mid * mid! It will overflow
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left - 1
    }
}

