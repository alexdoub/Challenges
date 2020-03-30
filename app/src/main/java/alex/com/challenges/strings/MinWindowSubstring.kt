package alex.com.challenges.strings

/**
 * Created by Alex Doub on 11/29/2019.
 * https://leetcode.com/problems/minimum-window-substring/
 */

//@@TODO: REDO with simplify like StringIncludesPermutation
object MinWindowSubstring {

    // WORKS??
    fun minWindow(s: String, t: String): String {
        val tCharCount = t.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val progressCount = t.groupBy { it }.mapValues { 0 }.toMutableMap()

        if (t.length > s.length) return ""

        var count = 0
        var bestLeft = -1
        var bestRight = -1
        var l = 0
        var r = 0
        while (l < s.length && r <= s.length) {

            //if we DONT have a match & right is NOT the end
            if (r < s.length && count != tCharCount.keys.size) {
                r++
                val addChar = s[r - 1]
                if (tCharCount[addChar] != null) {
                    progressCount[addChar] = progressCount[addChar]!! + 1

                    if (progressCount[addChar]!! == tCharCount[addChar]!!) {
                        count++
                    }
                }
            } else {
                //pull in left, remove char
                l++
                val removeChar = s[l - 1]
                if (tCharCount[removeChar] != null) {
                    progressCount[removeChar] = progressCount[removeChar]!! - 1

                    if (progressCount[removeChar]!! == tCharCount[removeChar]!! - 1) {
                        count--
                    }
                }
            }

            //try recording solution
            if (count == tCharCount.keys.size) {
                val thisLength = r - l
                val oldLength = bestRight - bestLeft
                if (bestLeft == -1 || thisLength < oldLength) {
                    bestLeft = l
                    bestRight = r
                }
            }
        }

        if (bestLeft == -1) return ""
        val rval = s.substring(bestLeft, bestRight)
        return rval
    }

    fun minWindow_keep_index_list(s: String, t: String): String {

        //Create key, which maps chars to char count
        val key = t.groupBy { it }.mapValues { it.value.size }  //turns "aabaa" into hashmap "a" ->4 "b" -> 1

        // Create an indexes map, which stores the indexes of chars as they are found.
        // If it stores more than the corresponding 'key' amount, the oldest one is removed
        val indexes = HashMap<Char, ArrayList<Int>>()
        var indexCount = 0  //Keep count of total indexes stored in indexes. (Cheaper than re-counting each time)

        // Init indexes with lists for each key
        key.keys.forEach {
            indexes[it] = ArrayList()
        }

        var shortestSubstring: String? = null

        s.forEachIndexed { index, c ->

            // See if this char is in our key set
            key[c]?.let { keyCharCount ->

                //Add the matching char to the indexes. Update count
                indexes[c]!!.add(index)
                indexCount += 1
                if (indexes[c]!!.size > keyCharCount) {
                    indexes[c]!!.removeAt(0)
                    indexCount -= 1
                }

                // If we have enough indexes to match our target, start recording substrings
                if (indexCount == t.length) {

                    //Find min and max indexes
                    var min: Int = -1
                    var max: Int = -1
                    indexes.values.forEach {
                        it.forEach { index ->
                            if (min == -1 || min > index) {
                                min = index
                            }
                            if (max == -1 || max < index) {
                                max = index
                            }
                        }
                    }


                    // See if its better than what we got
                    if (shortestSubstring == null || shortestSubstring!!.length > (max - min)) {
                        shortestSubstring = s.substring(min, max + 1)
                    }
                }
            }
        }

        return shortestSubstring ?: ""

    }
}