package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/combination-sum/
 */

//Notes: If paths only branch 'right' and not left, you dont need to worry about uniqueness anymore. It removes a LOT of computational overhead
class CombinationSum {
    companion object {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            //DFS
            fun getPathToTarget(inputSoFar: List<Int>, index: Int): List<List<Int>>? {

                //Check if end of the line
                val sum = inputSoFar.sum()
                if (sum > target) {
                    return null
                }
                if (sum == target) {
                    return listOf(inputSoFar.sorted())
                }

                //Try to find new paths
                val newPaths = ArrayList<List<Int>>()
                candidates.forEachIndexed { i, candidate ->
                    if (i >= index) {
                        getPathToTarget(inputSoFar + candidate, i)?.let { newPaths.addAll(it) }
                    }
                }
                return newPaths
            }

            //Starting point -- calculate all paths and join to list
            return ArrayList<List<Int>>().apply { addAll(getPathToTarget(emptyList(), 0) ?: emptyList()) }
        }
    }
}
