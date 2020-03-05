package alex.com.challenges.strings

/**
 * Created by Alex Doub on 11/30/2019.
 * https://leetcode.com/problems/repeated-substring-pattern/
 */

class RepeatedSubstringPattern {
    companion object {
        private fun debugPrint(string: String) {
            if (false) println(string)
        }
        fun repeatedSubstringPattern(s: String): Boolean {

            if (s.length <= 1) {
                return false
            }

            // Find divisors
            val divisors = mutableListOf<Int>()
            if (s.length % 2 == 0) {
                divisors.add(2)
            }
            (2..(s.length / 2)).forEach {
                if (s.length % it == 0) {
                    debugPrint("@ ${it} IS a divisor")
                    divisors.add(it)
                } else {
                    debugPrint("@ ${it} is not a divisor")
                }
            }
            divisors.add(s.length)

            //Check substrings (length relative to divisor)
            return divisors.any { lcd ->
                debugPrint("Checking LCD: ${lcd}")
                val substringLength = s.length / lcd
                val baseSubstring = s.substring(0, substringLength)
                var startIndex = substringLength
                var matching = true
                while (startIndex < s.length && matching) {
                    val nextSubstring = s.substring(startIndex, startIndex + substringLength)
                    if (baseSubstring != nextSubstring) {
                        debugPrint("...Found mismatch. pattern: ${baseSubstring} vs ${nextSubstring} at index ${startIndex}")
                        matching = false
                    }
                    startIndex += substringLength
                }
                return@any matching
            }
        }
    }
}