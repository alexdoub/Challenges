package alex.com.challenges.strings

/**
 * Created by Alex Doub on 11/29/2019.
 * https://leetcode.com/problems/permutation-in-string/
 */

object StringIncludesPermutation {


    // LESSONS LEARNED.
    // Use array of char counts instead of hashmap of char counts.... but why

    //168 ms	35.6 MB
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        // Fill out small int array of char counts
        val s1map = IntArray(26)
        val s2map = IntArray(26)
        for (i in 0 until s1.length) {
            s1map[s1[i] - 'a']++
            s2map[s2[i] - 'a']++
        }

        //pre count matching array indexes
        var count = 0
        for (i in 0..25) if (s1map[i] == s2map[i]) count++

        // Sliding window. Each iteration the front char is applied & the back char is removed. Counts are checked
        for (i in 0 until s2.length - s1.length) {
            val r = s2[i + s1.length] - 'a'
            val l = s2[i] - 'a'
            if (count == 26) return true
            s2map[r]++
            if (s2map[r] == s1map[r]) {
                count++
            } else if (s2map[r] == s1map[r] + 1) {
                count--
            }
            s2map[l]--
            if (s2map[l] == s1map[l]) {
                count++
            } else if (s2map[l] == s1map[l] - 1) {
                count--
            }
        }
        return count == 26
    }

    // fails because of s2*s1 loop
//    fun checkInclusion_hashmaps_supposed_to_fail(s1: String, s2: String): Boolean {
//        if (s1.length > s2.length) return false
//        val s1map: HashMap<Char, Int> = HashMap()
//        for (i in 0 until s1.length) s1map[s1[i]] = s1map.getOrDefault(s1[i], 0) + 1
//        for (i in 0..s2.length - s1.length) {
//            val s2map: HashMap<Char, Int> = HashMap()
//            for (j in 0 until s1.length) {
//                s2map[s2[i + j]] = s2map.getOrDefault(s2[i + j], 0) + 1
//            }
//            if (s1map == s2map) return true
//        }
//        return false
//    }

    // This fails because it resets too early
//    fun checkInclusion_FAIL(s1: String, s2: String): Boolean {
//        //make map of char counts
//        var key = s1.groupBy { it }.mapValues { it.value.size }
//        var solution = HashMap<Char, Int>()
//
//        fun isSolved(): Boolean {
//            return key == solution
//        }
//
//        //enumerate over and count down OR reset on mismatch
//        for (c in s2) {
//            if (solution.getOrDefault(c, 0) < key.getOrDefault(c, 0)) {
//                solution[c] = solution.getOrDefault(c, 0) + 1
//                if (isSolved()) return true
//            } else {
//                solution.clear()
//            }
//        }
//        return false
//    }



    //works but n^2
    //508 ms	42.7 MB
    fun checkInclusion_shitty_and_naive(s1: String, s2: String): Boolean {

        // Make key - maps chars to char count
        val s2CharMap = s1.groupBy { it }.mapValues { it.value.size }

        val indexesMap = HashMap<Char, ArrayList<Int>>()
        s2CharMap.keys.forEach { indexesMap[it] = ArrayList() }

        s2.forEachIndexed { index, c ->

            indexesMap[c]?.let { indexes ->

                // Add value to solution
                indexes.add(index)

                // Prune any old indexes for any char
                indexesMap.values.forEach { indexesOfChar ->
                    val iterator = indexesOfChar.iterator()
                    for (x in iterator) {
                        if (x + s1.length <= index) iterator.remove()
                        else break
                    }
                }

                // Check win state
                if (indexesMap.mapValues { it.value.size } == s2CharMap) return true
            }
        }
        return false
    }

}