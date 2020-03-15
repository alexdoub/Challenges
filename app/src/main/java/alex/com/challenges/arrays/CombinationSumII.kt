package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/15/2020.
 * https://leetcode.com/problems/combination-sum-ii
 */

object CombinationSumII {
    // Better than brute force
    fun combinationSum2_simple(candidates: IntArray, target: Int): List<List<Int>> {

        val solutionSet = HashSet<List<Int>>()
        candidates.sortDescending() // reduce search space

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

    // This solution uses a LOT less branching among duplicate values
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        // Make map of INT -> OCCURRENCE COUNT
        val countsMap = HashMap<Int, Int>()
        for (c in candidates) { countsMap[c] = (countsMap[c] ?: 0) + 1 }
        // Sort entries for ez navigation in desc order
        // This allows us to only branch on the same or small number
        val sortedMapEntries = countsMap.entries.sortedByDescending { it.key }

        // Container for all found solutions
        val solutionSet = ArrayList<List<Int>>()

        fun getUniqueComboSums(used: List<Int>, index: Int, repeatCount: Int, sum: Int) {

            if (repeatCount > sortedMapEntries[index].value) return //Repeated this character too much
            if (sum > target) return
            if (sum == target) solutionSet.add(used)

            //Branch only on UNIQUE VALUES while maintaining order of sortedMapEntries (to reduce duplication)
            sortedMapEntries.forEachIndexed { i, mutableEntry ->
                if (i >= index) {
                    val entryNum = mutableEntry.key
                    val newRepeatCount = if (index == i) repeatCount + 1 else 1
                    val newSum = sum + entryNum
                    getUniqueComboSums(used + entryNum, i, newRepeatCount, newSum)
                }
            }
        }
        getUniqueComboSums(emptyList(), 0, 0, 0)
        return solutionSet
    }
}