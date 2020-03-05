package alex.com.challenges.strings


/**
 * Created by Alex Doub on 11/17/2019.
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */

class MinimumSwaps {
    companion object {

        fun minimumSwap(s1: String, s2: String): Int {
            // String lengths must be equal. You cannot change the length with swaps.
            if (s1.length != s2.length) {
                return -1
            }

            var xyCount = 0
            var yxCount = 0
            for (i in 0 until s1.length) {
                if (s1[i] == s2[i]) continue
                if (s1[i] == 'x') {
                    xyCount++
                } else {
                    yxCount++
                }
            }

            println("xy: $xyCount   yx:$yxCount")

            // Early return - Check for mismatches of xy's and yx's
            // They must BOTH be either ODD or EVEN or its impossible to balance them
            if (xyCount % 2 + yxCount % 2 == 1)
                return -1

            // Initial result: Add the sum of half of each swaps.
            // Do half because 1 swap will fix another mismatch of the same type
            var res = (xyCount / 2) + (yxCount / 2)

            // Edge case - If they were both odd, then you have to double swap to achieve a horizontal swap on the same line
            println("res before final check: $res")
            res += xyCount % 2 + yxCount % 2
            println("res after final check: $res")
            return res
        }

        fun minimumSwap_UGLY(s1: String, s2: String): Int {

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
            mutableS1.add('x')
            mutableS2.add('x')
            mutableS1.add('y')
            mutableS2.add('y')

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