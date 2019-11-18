package alex.com.challenges

/**
 * Created by Alex Doub on 11/17/2019.
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */

class MinimumSwaps {
    companion object {
        fun minimumSwap(s1: String, s2: String): Int {

            // Fail case 1: Unequal lengths
            if (s1.length != s2.length) {
                return -1
            }

            // Fail case 2: odd number of X
            val combined = s1 + s2
            if (combined.groupBy { it }.any { it.value.size % 2 == 1 }) {
                return -1
            }

            val mutableS1 = s1.toMutableList()
            val mutableS2 = s2.toMutableList()

            //Add 2 cols of balanced padding (x & y) to allow for simulating swap-in-place
            mutableS1.add("x"[0])
            mutableS2.add("x"[0])
            mutableS1.add("y"[0])
            mutableS2.add("y"[0])

            var swaps = 0


            for (index in mutableS1.indices) {
                val topChar = mutableS1[index]
                val botChar = mutableS2[index]

                if (debug) {
                    val debugS1 = mutableS1.toMutableList()
                    val debugS2 = mutableS2.toMutableList()
                    (0 until index).forEach {
                        debugS1.removeAt(0)
                        debugS2.removeAt(0)
                    }
                    printDebug("s1: ${debugS1.toString()}")
                    printDebug("s2: ${debugS2.toString()}")
                }

                // If top != bot
                if (topChar != botChar) {

                    fun findGoodSwap(): Boolean {
                        for (nextIndex in index + 1 until mutableS2.size) {

                            // Swap if
                            val nextTopChar = mutableS1[nextIndex]
                            val nextBotChar = mutableS2[nextIndex]
                            if (
                                //Matches in current position
                                botChar == nextBotChar
                                //Doesnt break an already matching pair
                                && nextTopChar != nextBotChar
                            ) {
                                mutableS2[nextIndex] = topChar
                                mutableS1[index] = nextBotChar
                                printDebug("Good Swap: s1 ${index} for s2 ${nextIndex}")
                                printDebug("-----")
                                return true
                            }
                        }
                        return false
                    }

                    fun findBadSwap(): Boolean {
                        for (nextIndex in index + 1 until mutableS2.size) {

                            // Swap if: Matches at current position now
                            val nextBotChar = mutableS2[nextIndex]
                            if (botChar == nextBotChar) {
                                mutableS2[nextIndex] = topChar
                                mutableS1[index] = nextBotChar
                                printDebug("Bad swap: s1 ${index} for s2 ${nextIndex}")
                                printDebug("-----")
                                return true
                            }
                        }
                        return false
                    }

                    if (findGoodSwap()) {
                        swaps += 1
                    } else if (findBadSwap()) {
                        swaps += 1
                    } else {
                        //Should never happen
                        printDebug("No swaps to take!!")
                    }
                } else {
                    printDebug("Skipping $index, already matches")
                    printDebug("-----")
                }
            }

            return swaps
        }

        val debug = false
        fun printDebug(string: String) {
            if (debug) {
                println(string)
            }
        }
    }
}