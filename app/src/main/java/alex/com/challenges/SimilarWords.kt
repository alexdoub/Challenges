package alex.com.challenges

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class SimilarWords {

    companion object {
        fun solve(word: String, sentence: String): Int {
            return solve(word, sentence.split(" "))
        }
        fun solve2(word: String, sentence: String): Int {
            return solve2(word, sentence.split(" "))
        }

        fun solveExact(word: String, sentence: String): Int {
            return solveExact(word, sentence.split(" "))
        }

        private fun solve(word: String, wordList: List<String>): Int {
            val matching = ArrayList<String>().toMutableSet()

            for (item in wordList) {
                var match = true
                // Check if A contains B
                for (char in word) {
                    if (match && !item.contains(char)) {
                        match = false
                    }
                }

                // Check if B contains A
                for (char in item) {
                    if (match && !word.contains(char)) {
                        match = false
                    }
                }

                if (match) {
                    matching.add(item)
                }
            }
            return matching.size
        }

        private fun solve2(word: String, wordList: List<String>): Int {
            val matching = ArrayList<String>().toMutableSet()

            val targetWord = word.associateByTo(HashMap(), { it })
            for (item in wordList) {
                val thisWord = item.associateByTo(HashMap(), { it })

                if (targetWord.keys == thisWord.keys) {
                    matching.add(item)
                }
            }
            return matching.size
        }

        // Must have same characters & same character count
        private fun solveExact(word: String, wordList: List<String>): Int {
            val matchingList = ArrayList<String>().toMutableSet()

            val targetWordMap = word.groupBy { it }
            for (item in wordList) {
                val thisWordMap = item.groupBy { it }
                if (targetWordMap == thisWordMap) {
                    matchingList.add(item)
                }
            }
            return matchingList.size
        }
    }
}