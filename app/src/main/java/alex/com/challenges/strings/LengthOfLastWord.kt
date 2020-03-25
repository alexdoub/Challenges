package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/24/2020.
 * https://leetcode.com/problems/length-of-last-word/
 */


object LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        //loop over and count length
        // on space, mark flag
        // on new nonspace when flag set, reset to 0
        var lastLength = 0
        var didSeeSpace = false
        for (x in s.indices) {
            if (s[x] == ' ') {
                didSeeSpace = true
            } else {
                if (didSeeSpace) {
                    didSeeSpace = false
                    lastLength = 0
                }
                lastLength+=1
            }
        }

        return lastLength
    }
}