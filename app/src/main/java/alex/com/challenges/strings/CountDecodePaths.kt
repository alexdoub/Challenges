package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/18/2020.
 * https://leetcode.com/problems/decode-ways/
 */

object CountDecodePaths {

    fun numDecodings(s: String): Int {
        var count = 1 // Base case - theres 1 way to decode this
        var lastCount = 1

        if (s.isEmpty() || s[0] == '0') return 0

        for (x in 1 until s.length) {

            // Fail on impossible numbers. 00, 30, 40, 50, etc
            if (s[x] == '0' && (s[x - 1] >= '3' || s[x - 1] == '0')) return 0

            // Don't branch if next number is zero
            val nextNumberZero = x <= s.length - 2 && s[x + 1] == '0'

            //Check this & prev to decide if we can branch.
            //11-19 & 21-26 should split
            //27-99 should not split
            val canBranchHere = (s[x - 1] == '1' && s[x] >= '1' && s[x] <= '9') || (s[x - 1] == '2' && s[x] >= '1' && s[x] <= '6')

            if (!nextNumberZero && canBranchHere) {
                // On split, add the last count. Propagate count fibonacci style
                val tmp = count
                count += lastCount
                lastCount = tmp
            } else {
                // On no split, propagate last count
                lastCount = count
            }
        }

        return count
    }


    fun runTest() {
        val testCases = mapOf(
            "9999" to 1,
            "9919" to 2,
            "1999" to 2,
            "1012" to 2,
            "1" to 1,
            "11" to 2,
            "111" to 3,
            "1111" to 5,
            "11111" to 8,
            "111111" to 13,
            "1111111" to 21,
            "11111111" to 34,
            "111111111" to 55,
            "1111111111" to 89,
            "10120202" to 1,
            "10123123123121101" to 81,
            "1012312" to 6,
            "12312" to 6,
            "2312" to 4,
            "101" to 1,
            "110" to 1,
            "230" to 0
        )


        testCases.forEach {
            val calc = numDecodings(it.key)
            if (calc != it.value) {
                println("Failure: ${it.key} does not equal ${it.value}, instead it equals $calc")
            }
        }
    }
}