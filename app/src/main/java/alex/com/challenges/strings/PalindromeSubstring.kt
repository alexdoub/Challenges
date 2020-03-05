package alex.com.challenges.strings

/**
 * Created by Alex Doub on 2019-12-08.
 * https://leetcode.com/problems/longest-palindromic-substring/
 */

class PalindromeSubstring {
    companion object {
        fun longestPalindrome(string: String): String {

            var longestPalindrome = ""
            (string.indices).forEach { index ->
                val pal = longestPalindomeFrom(string, index)
                if (pal.length > longestPalindrome.length) {
                    longestPalindrome = pal
                }
            }

            return longestPalindrome
        }

        fun longestPalindomeFrom(string: String, index: Int): String {

            // Expand out and check if its a palindrome
            var x1 = index
            var x2 = index
            var biggest: String = string[index].toString()
            var keepGoing = true
            while (keepGoing && x1 >= 0 && x2 < string.length) {
                keepGoing = false

                // Try this (odd)
                if (isPalindome(string, x1, x2)) {
                    biggest = string.substring(x1, x2 + 1)
                    keepGoing = true
                }
                // Try expanded right + 1 (even)
                x2 += 1
                if (x2 < string.length && isPalindome(
                        string,
                        x1,
                        x2
                    )
                ) {
                    biggest = string.substring(x1, x2 + 1)
                    keepGoing = true
                }

                // Expand left
                x1 -= 1
            }
            return biggest
        }

        fun isPalindome(string: String, start: Int, end: Int): Boolean {

            if ((end - start + 1) % 2 == 0) {
                //Even
                var x1 = start
                var x2 = end
                while (x1 < x2) {
                    if (string[x1] != string[x2]) {
                        return false
                    }
                    x1 += 1
                    x2 -= 1
                }
                return true
            } else {
                //Odd
                val center = (end + start) / 2
                val iterate = (end - start) / 2
                return (0..iterate).all { string[center + it] == string[center - it] }
            }
        }
    }
}
