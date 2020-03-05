package alex.com.challenges.strings

/**
 * Created by Alex Doub on 12/31/2019.
 * https://leetcode.com/problems/roman-to-integer/
 */

class RomanToInt {
    companion object {
        fun romanToInt(s: String): Int {
            var sum = 0
            var ptr = 0
            while (ptr < s.length) {
                val char = "${s[ptr]}"
                val nextTwo: String? = if (ptr <= s.length - 2) "${char}${s[ptr + 1]}" else null

                when {
                    nextTwo == "IV" -> {
                        sum += 4
                        ptr += 2
                    }
                    nextTwo == "IX" -> {
                        sum += 9
                        ptr += 2
                    }
                    nextTwo == "XL" -> {
                        sum += 40
                        ptr += 2
                    }
                    nextTwo == "XC" -> {
                        sum += 90
                        ptr += 2
                    }
                    nextTwo == "CD" -> {
                        sum += 400
                        ptr += 2
                    }
                    nextTwo == "CM" -> {
                        sum += 900
                        ptr += 2
                    }
                    char == "I" -> {
                        sum += 1
                        ptr += 1
                    }
                    char == "V" -> {
                        sum += 5
                        ptr += 1
                    }
                    char == "X" -> {
                        sum += 10
                        ptr += 1
                    }
                    char == "L" -> {
                        sum += 50
                        ptr += 1
                    }
                    char == "C" -> {
                        sum += 100
                        ptr += 1
                    }
                    char == "D" -> {
                        sum += 500
                        ptr += 1
                    }
                    char == "M" -> {
                        sum += 1000
                        ptr += 1
                    }
                }
            }

            return sum
        }
    }
}