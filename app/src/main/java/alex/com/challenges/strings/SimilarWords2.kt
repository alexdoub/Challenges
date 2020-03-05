package alex.com.challenges.strings

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class SimilarWords2 {

    companion object {

        // Use hashmap, compare key set
        fun solve_same_char_set(word: String, wordList: List<String>): Int {
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

        fun solve_same_char_set2(word: String, wordList: List<String>): Int {
            val targetSet = word.toHashSet()
            return wordList.toSet().filter { it.toHashSet() == targetSet }.count()
        }

        // Must have same character set & count
        // use hashmap, compare hashmaps
        fun solve_with_same_char_count(word: String, wordList: List<String>): Int {
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