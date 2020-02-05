package alex.com.challenges

/**
 * Created by Alex Doub on 2/4/2020.
 * https://leetcode.com/problems/multiply-strings/
 *
 * Use intArray to store partial sums. Do N*M loop filling out intArray
 * Lastly, normalize intArray & build final string
 *
 * Takeaways:
 *   -In multiplying a number, the result has a max digit count of: x.len + y.len - 1
 *   -Reverse input to keep it aligned. Do not reverse again on final enumeration
 *
 * Time Complexity: O(num1.size * num2.size)
 * Space Complexity: O(num1.size + num2.size)
 */

class StringMultiply  {
    companion object {
        fun multiply(num1: String, num2: String): String {

            // Early return
            if (num1 == "0" || num2 == "0") {
                return "0"
            }

            val builder = StringBuilder()
            val sums = IntArray(num1.length + num2.length - 1)  // Max digits for 2 multiplied numbers

            // Double loop over inputs, fill out sums IntArray
            for (n1 in num1.reversed().withIndex()) {
                for (n2 in num2.reversed().withIndex()) {

                    // Multiply two single digits and put those in sum array accounting for offset
                    val n1i = n1.value.toInt() - '0'.toInt()
                    val n2i = n2.value.toInt() - '0'.toInt()
                    val sum = n1i * n2i
                    sums[n1.index + n2.index] += sum
                }
            }

            // Normalize and build string
            for (n3 in sums.withIndex()) {

                val carry = n3.value / 10
                builder.insert(0, n3.value % 10)

                // Propagate carry down array
                if (n3.index < sums.size - 1) {
                    sums[n3.index + 1] += carry
                }
                // At end of array, append final carry
                else if (carry > 0) {
                    builder.insert(0, carry)
                }
            }

            return builder.toString()
        }
    }
}
