package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/15/2020.
 * https://leetcode.com/problems/combination-sum-ii
 */

object CombinationSumII {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {

        val solutionSet = HashSet<List<Int>>()
        fun getSums(used: List<Int>, startIndex: Int) {
            val sum = used.sum()
            if (sum > target) return
            if (sum == target) {
                solutionSet.add(used.sorted())
            }

            // Enumerate remaining values in 1 direction (l -> r).
            // Going in 1 direction ensures the same combos don't get triggered twice
            //branches 2^(n-1) times, where N is candidate size.
            (startIndex until candidates.size).forEach { index ->
                getSums(used + candidates[index], index + 1)
            }
        }
        getSums(emptyList(), 0)
        return solutionSet.toList()
    }
}