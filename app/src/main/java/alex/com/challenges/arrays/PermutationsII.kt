package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/9/2020.
 * https://leetcode.com/problems/permutations-ii/
 */

class PermutationsII {
    companion object {
        fun permuteUnique(nums: IntArray): List<List<Int>> {

            val options = ArrayList<List<Int>>()

            fun addOptions(used: List<Int>, remaining: List<Int>) {
                if (remaining.isEmpty()) {
                    options.add(used)
                }
                remaining.distinct().forEach {
                    addOptions(used + it, remaining - it)
                }
            }
            addOptions(emptyList(), nums.toList())
            return options
        }
    }
}
