package alex.com.challenges.strings

/**
 * Created by Alex Doub on 4/9/2020.
 * https://leetcode.com/problems/permutation-in-string/
 */

object StringIncludesPermutation2 {

    // Fixed sliding window -- only deal with matching chars (unlike array approach)
    // Fill out target hashmap -- maps chars to counts
    // Prefill tmpMap, this keeps our main loop simple
    // Main loop - add 1, remove 1, (update matching ++/-- on each change!), check if matching count is right
    fun checkInclusion(target: String, input: String): Boolean {

        if (target.length > input.length) return false

        val targetMap = HashMap<Char, Int>()
        val tmpMap = HashMap<Char, Int>()
        var matching = 0

        // Fill out target map
        for (c in target) {
            targetMap[c] = (targetMap[c] ?: 0) + 1
        }

        // Prefill out tmp map with first batch of characters (loop continues from thereon)
        for (x in 0 until target.length) {
            val thisChar = input[x]
            if (targetMap[thisChar] == null) continue

            tmpMap[thisChar] = (tmpMap[thisChar] ?: 0) + 1
        }
        // Prefill check -- are we already at the solution?
        for (c in targetMap.keys) {
            if (targetMap[c] == tmpMap[c]) matching++
        }
        if (matching == targetMap.keys.size) return true

        // Main loop - fixed window substring
        // Add char, update matching. Remove char, update matching. Finally check matching
        for (x in target.length until input.length) {

            val newChar = input[x]
            if (targetMap[newChar] != null) {
                tmpMap[newChar] = (tmpMap[newChar] ?: 0) + 1

                if (tmpMap[newChar]!! == targetMap[newChar]!!) {
                    matching++
                } else if (tmpMap[newChar]!! == targetMap[newChar]!! + 1) {
                    matching--
                }
            }

            val removedChar = input[x-target.length]
            if (targetMap[removedChar] != null) {

                tmpMap[removedChar] = (tmpMap[removedChar] ?: 0) - 1
                if (tmpMap[removedChar]!! == targetMap[removedChar]!!) {
                    matching++
                }
                else if (tmpMap[removedChar]!! == targetMap[removedChar]!! - 1) {
                    matching--
                }
            }

            if (matching == targetMap.keys.size) return true
        }

        return false
    }
}