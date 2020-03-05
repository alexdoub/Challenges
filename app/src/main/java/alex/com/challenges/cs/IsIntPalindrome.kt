package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/4/2020.
 * https://leetcode.com/problems/palindrome-number/
 */

object IsIntPalindrome {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        //count how many digits this is
        var tmpX = x
        var digits = 0
        while (tmpX > 0) {
            tmpX = tmpX / 10
            digits++
        }

        // Sliding window approach -- compare digits on each side
        var start = 0
        var end = digits - 1
        while (start < end) {
            if (!areDigitsSame(start, end, x)) return false
            start++
            end--
        }
        return true
    }

    fun areDigitsSame(x: Int, y: Int, number: Int): Boolean {
        val xDigit = (number / Math.pow(10.0, x.toDouble()).toInt()) % 10
        val yDigit = (number / Math.pow(10.0, y.toDouble()).toInt()) % 10
//        println("Checking digits.. x:$x  y:$y --- xDig:$xDigit  yDig:$yDigit")
        return xDigit == yDigit
    }
}