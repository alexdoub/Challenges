package alex.com.challenges

/**
 * Created by Alex Doub on 11/17/2019.
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */

class MinimumSwaps {
    companion object {
        fun minimumSwap(s1: String, s2: String): Int {

            //CAN SWAP ANY POSITION ON 2nd STRING

            // Fail case 1: Unequal lenghts
            if (s1.length != s2.length) {
                return -1
            }

            // Fail case 2: odd number of X
            val combined = s1 + s2
            if (combined.groupBy { it }.any { it.value.size %2 == 1 }) {
                    return -1
            }


            //Plan: Loop until nothing swapped
            //X+1 swapping, skip this iteration if it will further unbalance

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

                println("s1: ${mutableS1.toString()}")
                println("s2: ${mutableS2.toString()}")

                // If top != bot
                if (topChar != botChar) {
                    for (nextIndex in index+1 until mutableS2.size) {

                        // Swap if
                        val nextBotChar = mutableS2[nextIndex]
                        if (botChar == nextBotChar) {
                            mutableS2[nextIndex] = topChar
                            mutableS1[index] = nextBotChar
                            swaps += 1
                            println("Swapping s1 ${index} for s2 ${nextIndex}")
                            println("-----")
                            break
                        }
                    }
                }
            }

            return swaps
        }
    }
}