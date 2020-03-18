package alex.com.challenges.strings

/**
 * Created by Alex Doub on 3/18/2020.
 * https://leetcode.com/problems/longest-common-prefix/
 */

object LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val first = strs[0]

        for (i in first.indices) {
            for (x in 1 until strs.size) {
                if (first.length <= i || strs[x].length <= i || strs[x][i] != first[i]) {
                    return first.substring(0, i)
                }
            }
        }

        return first
    }
}