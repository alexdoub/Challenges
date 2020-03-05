package alex.com.challenges.strings

/**
 * Created by Alex Doub on 12/1/2019.
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

class MixedWordsConcatenated {
    companion object {
        private fun debugPrint(string: String) {
            if (false) println(string)
        }

        fun findSubstring(s: String, words: Array<String>): List<Int> {

            if (words.isEmpty()) {
                return emptyList()
            }

            val wordCount = words.size
            val wordLength = words[0].length
            val result = mutableListOf<Int>()
            val wordCounts: Map<String, Int> = words.groupBy { it }.mapValues { it.value.size }
            val wordSum = wordCounts.values.sum()

            var index = 0
            while (index < s.length - (wordCount * wordLength) + 1) {
                val substring = s.substring(index, index + wordLength)
                debugPrint("Index: ${index}, substring: ${substring}")

                // Found a single match, check ahead to see if its a full match
                if (wordCounts.containsKey(substring)) {
                    val wordCountsCopy = wordCounts.toMutableMap()
                    var matches = 1
                    var isMatching = true
                    wordCountsCopy[substring] = wordCountsCopy[substring]!! - 1

                    debugPrint("... did match! Finding remaining ${matches} matches")

                    while (isMatching && matches < wordSum) {
                        val nextIndex = index + (matches * wordLength)
                        val nextSubstring = s.substring(nextIndex, nextIndex + wordLength)

                        if (wordCountsCopy[nextSubstring] != null) {

                            if (wordCountsCopy[nextSubstring] == 0) {
                                debugPrint("... ... matched too many times. ${nextSubstring}")
                                isMatching = false
                            } else {
                                wordCountsCopy[nextSubstring] = wordCountsCopy[nextSubstring]!! - 1
                                matches += 1
                                debugPrint("... ... next matches. ${nextSubstring}")
                            }
                        } else {
                            debugPrint("... ... not a match. ${nextSubstring}")
                            isMatching = false
                        }
                    }

                    // Check if complete match
                    if (isMatching && wordCountsCopy.all { it.value == 0 }) {
                        debugPrint("... ... ... FULL MATCH at ${index}")
                        result.add(index)
                    }
                }
                index += 1
            }

            return result
        }
    }
}