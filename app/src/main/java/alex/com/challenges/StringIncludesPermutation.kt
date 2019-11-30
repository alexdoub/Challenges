package alex.com.challenges

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
                    solution.values.forEach{ it.removeIf { it + s1.length <= index } }

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

        //Broken: Fails on partial match followed by real match
        fun checkInclusion_BROKEN(s1: String, s2: String): Boolean {
            val key = s1.groupBy { it }.mapValues { it.value.size }
            val matchedChars = HashMap<Char, Int>()
            var matchedCharsDirty = true

            fun resetMatches() {
                key.keys.forEach { matchedChars[it] = 0 }
                matchedCharsDirty = false
                printDebug("...did reset")
            }
            resetMatches()

            s2.forEach { char ->

                printDebug("Checking char ${char}")

                // If this char is a reminaing char...
                if (key.contains(char) && matchedChars[char]!! < key[char]!!) {
                    matchedChars[char] = matchedChars[char]!! + 1
                    matchedCharsDirty = true
                    printDebug("... is match. This char is ${matchedChars[char]} of ${key[char]}")

                    // Win check
                    if (key == matchedChars) {
                        printDebug("... DID WIN")
                        return true
                    } else {
                        printDebug("... not a win")
                    }
                } else if (matchedCharsDirty) {
                    //Our substring broke, reset remaining
                    resetMatches()
                }
            }

            return false
        }
    }
}