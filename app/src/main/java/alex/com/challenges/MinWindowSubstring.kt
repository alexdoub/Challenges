package alex.com.challenges

/**
 * Created by Alex Doub on 11/29/2019.
 * https://leetcode.com/problems/minimum-window-substring/
 */

class MinWindowSubstring {
    companion object {
        private fun debugPrint(string: String) {
            if (false) println(string)
        }
        fun minWindow(s: String, t: String): String {

            //Create a key which maps chars to char count
            val key = t.groupBy { it }

            // Create an indexes map, which stores the indexes of chars as they are found.
            // If it stores more than the corresponding 'key' amount, the oldest one is removed
            val indexes = HashMap<Char, ArrayList<Int>>()
            var shortestSubstring: String? = null
            var indexCount = 0  //Keep count of total indexes stored in indexes. (Cheaper than re-counting each time)

            s.forEachIndexed { index, c ->
                if (key[c] != null) {

                    debugPrint("Found ${c} at ${index}")

                    //Add the matching char to the indexes. Update count
                    if (indexes[c] == null) {
                        indexes[c] = ArrayList<Int>()
                    }
                    indexes[c]!!.add(index)
                    indexCount += 1
                    if (indexes[c]!!.size > key[c]!!.size) {
                        indexes[c]!!.removeAt(0)
                        indexCount -= 1
                    }
                    debugPrint("... indexCount = ${indexCount}")


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
                                if (max == -1  || max < index) {
                                    max = index
                                }
                            }
                        }

                        debugPrint("... got enough indexes. min:${min}, max:${max}")

                        // See if its better than what we got
                        if (shortestSubstring == null || shortestSubstring!!.length > (max - min)) {
                            shortestSubstring = s.substring(min, max+1)
                            debugPrint("... ... new shortest substring: ${shortestSubstring}")
                        }
                    } else {
                        debugPrint("... need more chars. ${indexCount} of ${t.length}")
                    }
                } else {
                    debugPrint("... skipped irrelevant char ${c}")
                }
            }

            return shortestSubstring ?: ""
        }
    }
}