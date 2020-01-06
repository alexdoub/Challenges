package alex.com.challenges

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/combination-sum/
 */

class CombinationSum {
    companion object {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            //DFS
            fun getPathToTarget(inputSoFar: List<Int>): Set<List<Int>>? {
                val sum = inputSoFar.sum()

                if (sum > target) {
                    return null
                }
                if (sum == target) {
                    return setOf(inputSoFar.sorted())
                }

                val newPaths = ArrayList<List<Int>>().toMutableSet()

                candidates.forEach { candidate ->
                    val path = getPathToTarget(inputSoFar + candidate)
                    if (path != null) {
                        newPaths.addAll(path)
                    }
                }
                return newPaths
            }

            val rval = ArrayList<List<Int>>().toMutableSet()
            rval.addAll(getPathToTarget(emptyList()) ?: emptyList())
            return rval.toList()
        }
    }
}