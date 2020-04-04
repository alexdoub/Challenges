package alex.com.challenges.custom

/**
 * Created by Alex Doub on 4/2/2020.
 * https://leetcode.com/problems/happy-number/
 *
    Write an algorithm to determine if a number is "happy".
    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the
    sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly
    in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 */

object IsHappyInteger {
    fun isHappy(n: Int): Boolean {
        var n = n
        val used = HashSet<Int>()
        while (n > 1) {
            //println("Iterating on $n")
            if (used.contains(n)) return false
            used.add(n)
            val digits = ArrayList<Int>()
            while (n > 0) {
                digits.add(n % 10)
                n /= 10
            }
            n = digits.map{ it * it }.sum()
        }
        return n == 1
    }
}