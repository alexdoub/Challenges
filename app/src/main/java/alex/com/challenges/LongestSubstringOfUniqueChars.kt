package alex.com.challenges

import java.util.concurrent.ConcurrentHashMap

class LongestSubstringOfUniqueChars {
    companion object {

        fun lengthOfLongestSubstring(s: String): Int {
            //on every new char added, update max
            var maxSubstring = 0
            val charHashTable = ConcurrentHashMap<Char, Int>()
            for (x in s.indices) {
                val char = s[x]
                val oldIndex = charHashTable[char] ?: -1


                //after a repeat comes in, null out evertyhing before it
                charHashTable.keys.forEach {  key ->
                    val checkChar = charHashTable[key]!!
                    if (checkChar <= oldIndex) {
                        charHashTable.remove(key)
                    }
                }

                // Put new data
                charHashTable[char] = x

                //Find max thus far
                val minIndex = charHashTable.values.min()!!
                val maxIndex = charHashTable.values.max()!!
                val longestSubstring = maxIndex - minIndex + 1
                maxSubstring = Math.max(maxSubstring, longestSubstring)
            }
            return maxSubstring
        }
    }
}