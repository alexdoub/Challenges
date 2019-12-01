package alex.com.challenges

/**
 * Created by Alex Doub on 11/30/2019.
 * https://leetcode.com/problems/long-pressed-name/
 */

class LongPressedName {
    companion object {
        fun isLongPressedName(name: String, typed: String): Boolean {
            var lastMatch: Char? = null
            var x = 0
            typed.forEach {
                if (x < name.length && it == name[x]) {
                    x += 1
                    lastMatch = it
                } else if (it != lastMatch) {
                    return false
                }
            }
            return x == name.length
        }
    }
}