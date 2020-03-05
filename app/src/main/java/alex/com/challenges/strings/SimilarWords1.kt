package alex.com.challenges.strings

import kotlin.collections.ArrayList

@Deprecated("shitty solution, do not copy")
class SimilarWords1 {

    companion object {

        // Quick and dirty naive solution
        fun solve(word: String, sentence: String): Int {
            return solve_simple(word, sentence.split(" "))
        }

        private fun solve_simple(word: String, wordList: List<String>): Int {
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
    }
}