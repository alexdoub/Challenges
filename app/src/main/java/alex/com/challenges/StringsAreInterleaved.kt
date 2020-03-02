package alex.com.challenges

/**
 * Created by Alex Doub on 3/1/2020.
 * https://leetcode.com/problems/interleaving-string/
 */

object StringsAreInterleaved {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {

        //Account for length mismatches
        if (s1.length + s2.length != s3.length) return false

        fun checkIfValid(i1: Int, i2: Int): Boolean {

            // Early fail -- pushed too far
            if (i1 > s1.length) return false
            if (i2 > s2.length) return false

            // Check if at solution
            val leftComplete = i1 == s1.length
            val rightComplete = i2 == s2.length
            if (leftComplete && rightComplete) return true

            val i3 = i1 + i2

            // Check left
            if (!leftComplete && s3[i3] == s1[i1]) {
                // Try to advance left
                if (checkIfValid(i1 + 1, i2)) return true
            }

            // Check right
            if (!rightComplete && s3[i3] == s2[i2]) {
                // Try to advance right
                if (checkIfValid(i1, i2 + 1)) return true
            }

            return false
        }

        return checkIfValid(0, 0)
    }
}