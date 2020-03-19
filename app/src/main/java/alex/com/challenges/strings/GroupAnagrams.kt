package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/18/2020.
 * https://leetcode.com/problems/group-anagrams
 */

object GroupAnagrams {
    //Runtime & Mem: O(NL) where N is count, L is max char length
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy{ it.sorted() }.values.toList()
    }

    fun groupAnagrams_manually(strs: Array<String>): List<List<String>> {
        // Solved without kotlin magic
        val hashMap = HashMap<String, ArrayList<String>>()
        for (str in strs) {
            val key = str.sorted()
            if (hashMap[key] == null) {
                hashMap[key] = ArrayList<String>()
            }
            hashMap[key]!!.add(str)
        }

        return hashMap.values.toList()
    }

    //runtime O(L)
    //mem: O(L)
    fun String.sorted(): String {
        var intArray = IntArray(0)  //Auto extending array could be optimized to a flat constant
        for (c in this) {
            val charCode = c.toInt()
            if (charCode > intArray.size-1) {
                intArray = intArray.copyOf(charCode+1)
            }
            intArray[charCode] += 1
        }

        val sb = StringBuilder()
        for (x in intArray.indices) {
            while (intArray[x] > 0) {
                sb.append(x.toChar())
                intArray[x] -= 1
            }
        }
        return sb.toString()
    }
}