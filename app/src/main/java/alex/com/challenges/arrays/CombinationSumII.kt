package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/15/2020.
 * https://leetcode.com/problems/combination-sum-ii
 */

object CombinationSumII {

    //204 ms 37.7 MB
    // repeat: 220 ms	37.1 MB
    //Moving break 1 line higher: 196 ms	37 MB
    fun combinationSum2_borrowed(candidates: IntArray, target: Int): List<List<Int>>? {
        candidates.sort()
        val solution = ArrayList<List<Int>>()

        fun findComboSums(used: MutableList<Int>, candidates: IntArray, index: Int, remaining: Int) {
            if (remaining == 0) {
                solution.add(used.toList())
                return
            }
            if (remaining < 0) return
            if (index >= candidates.size) return

            for (i in index until candidates.size) {
                if (candidates[i] > remaining) break
                if (i != index && candidates[i] == candidates[i - 1]) continue
                used.add(candidates[i])
                findComboSums(used, candidates, i + 1, remaining - candidates[i])
                used.removeAt(used.size - 1)
            }
        }

        findComboSums(ArrayList(), candidates, 0, target)
        return solution
    }

    //224 ms	37.6 MB
    // Lessons learned: sort() incrementally so we can early terminate branches with less checks
    fun combinationSum2_updated(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val solutionSet = ArrayList<List<Int>>()
        fun getSums(used: ArrayList<Int>, index: Int, sum: Int) {
            if (sum == target) {
                solutionSet.add(used.toList())
                return
            }

            // Enumerate remaining values in 1 direction (l -> r).
            // Going in 1 direction ensures the same combos don't get triggered twice
            //branches 2^(n-1) times, where N is candidate size.
            for (i in index until candidates.size) {
                val newSum = sum + candidates[i]
                if (newSum > target) break
                if (i != index && candidates[i] == candidates[i - 1]) continue

                used.add(candidates[i])
                getSums(used, i + 1, newSum)
                used.removeAt(used.size - 1)
            }
        }
        getSums(ArrayList(), 0, 0)
        return solutionSet.toList()
    }

    // This solution uses a LOT less branching among duplicate values
    // It also turns out this data structure was 100% unnecessary
    //244 ms 42.1 MB
    // After changes, 240 ms 40.8 MB
    fun combinationSum2_with_datastructure(candidates: IntArray, target: Int): List<List<Int>> {
        // Make map of INT -> OCCURRENCE COUNT
        val countsMap = HashMap<Int, Int>()
        for (c in candidates) {
            countsMap[c] = (countsMap[c] ?: 0) + 1
        }
        // Sort entries for ez navigation in desc order
        // This allows us to only branch on the same or small number
        val sortedUniqueEntries = countsMap.entries.sortedByDescending { it.key }

        // Container for all found solutions
        val solutionSet = ArrayList<List<Int>>()

        fun getUniqueComboSums(used: ArrayList<Int>, index: Int, repeatCount: Int, sum: Int) {

            if (repeatCount > sortedUniqueEntries[index].value) return //Repeated this character too much
            if (sum == target) {
                solutionSet.add(used.toList())
            } else {
                //Branch only on UNIQUE VALUES while maintaining order of sortedMapEntries (to reduce duplication)
                sortedUniqueEntries.forEachIndexed { i, mutableEntry ->
                    if (i >= index) {
                        val entryNum = mutableEntry.key
                        val entryMax = mutableEntry.value
                        val newRepeatCount = if (index == i) repeatCount + 1 else 1
                        val newSum = sum + entryNum

                        //prune here. Saves stack & array operation
                        if (newSum <= target && newRepeatCount <= entryMax) {
                            used.add(entryNum)
                            getUniqueComboSums(used, i, newRepeatCount, newSum)
                            used.remove(entryNum)
                        }
                    }
                }
            }
        }
        getUniqueComboSums(ArrayList(), 0, 0, 0)
        return solutionSet
    }

    //ORIGINAL -- tons of unecessary branching but fixed with hashset
    fun combinationSum2_original(candidates: IntArray, target: Int): List<List<Int>> {

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