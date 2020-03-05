package alex.com.challenges.strings

/**
 * Created by Alex Doub on 11/30/2019.
 * https://leetcode.com/problems/long-pressed-name/
 */

class LongPressedName {
    companion object {

        fun isLongPressedName(name: String, typed: String): Boolean {
            var matched = 0
            var lastMatch: Char? = null

            for (char in typed) {

                //Detect matches and increment the matched index
                if (matched < name.length && char == name[matched]) {
                    matched++
                    lastMatch = char
                }
                // Fail if non match & non repeat
                else if (char != lastMatch) {
                    return false
                }
            }

            return matched == name.length
        }
    }
}