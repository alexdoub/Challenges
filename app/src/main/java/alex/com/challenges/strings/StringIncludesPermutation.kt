package alex.com.challenges.strings

/**
 * Created by Alex Doub on 11/29/2019.
 * https://leetcode.com/problems/permutation-in-string/
 */

class StringIncludesPermutation {
    companion object {
        private fun printDebug(string: String) {
            if (false) println(string)
        }

        fun checkInclusion(s1: String, s2: String): Boolean {

            // Make key - maps chars to char count
            val key = s1.groupBy { it }.mapValues { it.value.size }

            val solution = HashMap<Char, ArrayList<Int>>()
            key.keys.forEach { solution[it] = ArrayList() }

            s2.forEachIndexed { index, c ->

                solution[c]?.let { indexes ->

                    printDebug("found match ${c} at ${index}")

                    // Add value to solution
                    indexes.add(index)

                    // Prune any old indexes
                    solution.values.forEach { it.removeIf { it + s1.length <= index } }

                    // Check win state
                    if (solution.all { it.value.size == key[it.key] }) {
                        printDebug("Win!")
                        return true
                    }
                } ?: run {
                    printDebug("skipping ${c} at ${index}")
                }

            }

            return false
        }

    }
}