package alex.com.challenges

/**
 * Created by Alex Doub on 12/1/2019.
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

class MixedWordsConcatenated {
    companion object {
        private fun debugPrint(string: String) {
            if (true) println(string)
        }

        fun findSubstring(s: String, words: Array<String>): List<Int> {

            if (words.isEmpty()) {
                return emptyList()
            }

            val wordLength = words[0].length
            val result = mutableListOf<Int>()
            val wordCounts = words.groupBy { it }.mapValues { it.value.size }

            val matchedIndexes = HashMap<String, ArrayList<Int>>()

            //Init matches
            for (word in words) {
                matchedIndexes[word] = ArrayList<Int>()
            }

            var index = 0
            while (index < s.length - wordLength + 1) {
                val substring = s.substring(index, index + wordLength)
                debugPrint("Index: ${index}, substring: ${substring}")
                if (matchedIndexes.containsKey(substring)) {
                    // Match, set index
                    debugPrint("...Match at ${index}")
                    matchedIndexes[substring]!!.add(index)

                    if (matchedIndexes[substring]!!.size > wordCounts[substring]!!) {
                        matchedIndexes[substring]!!.removeAt(0)
                        debugPrint("... ... too many matches, rolled off one")
                    }

                    index += wordLength

                    //Prune out-of-range matches
                    // If any matched index is 4*wordLength behind us, prune it
                    matchedIndexes.keys.forEach { key ->
                        matchedIndexes[key]!!.removeIf {
                            val remove = it < index - (words.size * wordLength)
                            if (remove) {
                                debugPrint("... pruning old match of ${key} with index ${it}")
                            }
                            remove
                        }
                    }
                } else {
                    // Non match, zero out matched indexes
                    debugPrint("...Non match at ${index}")
                    for (word in words) {
                        matchedIndexes[word]!!.clear()
                    }

                    index += 1
                }

                //Check if full match & clear
                var fullMatchMinIndex: Int? = null
                val fullMatch = matchedIndexes.all {
                    val matchesSize = it.value.size == wordCounts[it.key]

                    if (matchesSize) {
                        val thisMin = it.value.min()!!
                        if (thisMin < fullMatchMinIndex ?: Int.MAX_VALUE) {
                            fullMatchMinIndex = thisMin
                        }
                    } else {
                        debugPrint("... still missing matches")
                    }


                    return@all matchesSize
                }

                if (fullMatch) {
                    result.add(fullMatchMinIndex!!)
                    debugPrint("...!!!!!!Found full match at ${fullMatchMinIndex}")
                }
            }

            return result
        }
    }
}