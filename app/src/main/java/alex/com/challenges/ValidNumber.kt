package alex.com.challenges

import java.lang.Exception
import java.math.BigDecimal
//https://leetcode.com/problems/valid-number
class ValidNumber {
    companion object {
        fun isNumber(input: String) : Boolean {

            var adjustedInput = input.trim()

            //Simplify extremely large exponents
            val indexOfE = adjustedInput.lastIndexOf("e")
            if (indexOfE > 0 && indexOfE < adjustedInput.length - 1) {
                var exponentString = adjustedInput.substring(indexOfE + 1)

                // Check if exponent string is a real number
                try {
                    BigDecimal(exponentString)
                } catch (e: Exception) {
                    return false
                }

                // Fail if exponent is a decimal
                if (exponentString.contains(".")) {
                    return false
                }

                // Replace with smaller exponent to avoid overflow
                exponentString = "1"
                adjustedInput = adjustedInput.substring(0, indexOfE + 1) + exponentString
            }


            try {
                BigDecimal(adjustedInput)
                return true
            } catch (e: Exception) {
                return false
            }
        }
    }
}