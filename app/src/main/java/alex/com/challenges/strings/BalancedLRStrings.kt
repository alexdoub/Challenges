package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/24/2020.
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */

object BalancedLRStrings {
    fun balancedStringSplit(s: String): Int {
        var balance = 0
        var sum = 0
        for (c in s) {
            if (c == 'L') {
                balance-=1
            } else {
                balance+=1
            }
            if (balance == 0) {
                sum += 1
            }
        }
        return sum
    }
}