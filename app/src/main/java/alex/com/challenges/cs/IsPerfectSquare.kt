package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/14/2020.
 * https://leetcode.com/problems/valid-perfect-square/
 */

object IsPerfectSquare {
    fun isPerfectSquare(num: Int): Boolean {
        val mySqrt = IntSquareRoot.mySqrt(num)
        return mySqrt * mySqrt == num
    }
}