package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/27/2020.
   https://leetcode.com/problems/valid-palindrome-ii/
 */


object ValidPalindromeWithSkips {

    //NOTE: First solution tried to do this with a single greedy function but the greedy function could not easily determine which skip was better to go with
    //e.g. "cuucu". Should it skip the leftmost C or the rightmost U? Both have an initial match. Could probably be fixed with looking ahead

    // Recursive not required but scales very well
    fun validPalindrome(s: String): Boolean {
        fun validPalindromeFrom(l: Int, r: Int, skipped: Int): Boolean {
            var l = l
            var r = r
            if (skipped > 1) return false

            while (l < r) {
                if (s[l] != s[r]) {
                    return validPalindromeFrom(l + 1, r, skipped + 1) || validPalindromeFrom(l, r - 1, skipped + 1)
                }
                l++
                r--
            }
            return true
        }
        return validPalindromeFrom(0, s.length - 1, 0)
    }

    fun validPalindrome_no_recursion(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        var didSkip = false

        while (l < r) {
            if (s[l] != s[r]) {
                if (didSkip) return false

                // Decide which to skip
                // Check immediate next value AND the value after that (or if we're at the end of the array)
                if (s[l+1] == s[r] && (l+2 >= s.length || s[l+2] == s[r-1])) {
                    l++
                } else if (s[l] == s[r-1] && (r-2 < 0 || s[l+1] == s[r-2])) {
                    r--
                }
                // Edge case, we are at the middle and 1 can be dropped
                else return (l + 1 == r)

                didSkip = true
            } else {
                l++
                r--
            }
        }
        return true
    }
}