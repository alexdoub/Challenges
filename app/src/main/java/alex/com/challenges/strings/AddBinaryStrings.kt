package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/14/2020.
 * https://leetcode.com/problems/add-binary/
 */

object AddBinaryStrings {
    fun addBinary(a: String, b: String): String {

        val sb = StringBuilder()
        var carry = false
        var index = 0
        val maxLength = Math.max(a.length, b.length)
        while (carry || index < maxLength) {
            val aIndex = a.length - index - 1
            val bIndex = b.length - index - 1

            // Parse & make sum
            var sum = 0
            if (aIndex >= 0 && a[aIndex] == '1') {
                sum++
            }
            if (bIndex >= 0 && b[bIndex] == '1') {
                sum++
            }
            if (carry) {
                sum++
                carry = false
            }

            // Set values & carry
            if (sum % 2 == 0) {
                sb.append('0')
            } else {
                sb.append('1')
            }
            if (sum > 1) {
                carry = true
            }
            index++
        }

        // final loop, strip 0s
        while (sb[sb.length-1] == '0') {
            sb.deleteCharAt(sb.length-1)
        }

        // Reverse to put in order
        return sb.reverse().toString()
    }
}