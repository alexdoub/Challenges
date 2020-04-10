package alex.com.challenges.strings

/**
 * Created by Alex Doub on 4/9/2020.
* https://leetcode.com/problems/minimum-window-substring/

  FLOW: increment, adjust map, check matching

  Minor Optimizations: Only call substring once at the end. Instead store the indexes until the end

  Pitfalls:
    Off by 1 index
    Doing operations in wrong order (this will fuck you up with unfixable edge cases and lead you down a rabbit hole of 'change this 1 thing, change that 1 thing'
    Comparing maps to maps (if you have extra chars it should still be a match!)

 * */
object MinWindowSubstring2 {
    fun minWindow(input: String, target: String): String {
        // Count up characters in a map
        val targetMap = HashMap<Char, Int>()
        for (c in target) {
            targetMap[c] = (targetMap[c] ?: 0) + 1
        }

        val tmpMap = HashMap<Char, Int>()
        var bestString = ""

        var l = 0
        var r = 0
        var matching = 0
        while (l < input.length) {

            //bring in left
            if (matching == targetMap.keys.size || r >= input.length) {
                l++
                val lChar = input[l-1]
                if (targetMap[lChar] != null) {
                    tmpMap[lChar] = (tmpMap[lChar] ?: 0) - 1

                    if (tmpMap[lChar] == targetMap[lChar]!! - 1) {
                        matching --
                    }
                }
            }
            // push right
            else {
                r++
                val rChar = input[r-1]
                if (targetMap[rChar] != null) {
                    tmpMap[rChar] = (tmpMap[rChar] ?: 0 ) + 1

                    if (tmpMap[rChar] == targetMap[rChar]) {
                        matching ++
                    }
                }
            }

            // check
            if (matching == targetMap.keys.size && (bestString.isEmpty() || bestString.length > r  - l)) {
                bestString = input.substring(l, r)
            }
        }
        return bestString
    }
}