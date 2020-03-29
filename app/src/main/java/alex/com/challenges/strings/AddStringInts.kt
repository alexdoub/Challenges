package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/28/2020.
 * https://leetcode.com/problems/add-strings/
 */

object AddStringInts {

    // concise approach addings ints directly to SB instead of doing all math in chars
    fun addStrings(num1: String, num2: String): String {
        val builder = StringBuilder()
        var i1 = num1.length - 1
        var i2 = num2.length - 1
        var carry = 0
        while (i1 >= 0 || i2 >= 0 || carry == 1) {
            val x1 = if (i1 >= 0) { num1[i1] - '0' } else 0
            val x2 = if (i2 >= 0) { num2[i2] - '0' } else 0
            val cSum = (x1 + x2 + carry)
            carry = cSum / 10
            builder.append(cSum % 10)
            i1--
            i2--
        }
        return builder.reverse().toString()
    }

    fun addStrings_withChars(num1: String, num2: String): String {
        var i1 = num1.length -1
        var i2 = num2.length -1

        val builder = StringBuilder()

        var carry = false
        while (i1 >= 0 || i2 >= 0 || carry) {
            var cSum = '0'
            if (carry) cSum += 1
            carry = false

            if (i1 >= 0) {
                val c = num1[i1]
                cSum+= c.toInt() - '0'.toInt()
                i1--
            }
            if (i2 >= 0) {
                val c = num2[i2]
                cSum+= c.toInt() - '0'.toInt()
                i2--
            }

            if (cSum > '9') {
                cSum -= 10
                carry = true
            }

            builder.append(cSum)
        }
        return builder.reverse().toString()
    }

    fun addStrings_correctIMO(num1: String, num2: String): String {
        var i1 = num1.length -1
        var i2 = num2.length -1

        val finalBuilder = StringBuilder()
        val tmpBuilder = StringBuilder()
        var carry = false
        while (i1 >= 0 || i2 >= 0 || carry) {
            var cSum = '0'
            if (carry) cSum += 1
            carry = false

            if (i1 >= 0) {
                val c = num1[i1]
                cSum+= c.toInt() - '0'.toInt()
                i1--
            }
            if (i2 >= 0) {
                val c = num2[i2]
                cSum+= c.toInt() - '0'.toInt()
                i2--
            }

            if (cSum > '9') {
                cSum -= 10
                carry = true
            }

            tmpBuilder.append(cSum)

            //1) commit & flush tmp builder if non zero
            // this is required to handle the case of "0000010000" having frontal zeroes
            //2) commit if empty to handle "" + ""
            if (cSum != '0' || finalBuilder.isEmpty()) {
                finalBuilder.append(tmpBuilder)
                tmpBuilder.setLength(0)
            }
        }
        return finalBuilder.reverse().toString()
    }
}