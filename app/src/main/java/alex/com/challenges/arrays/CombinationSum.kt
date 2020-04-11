package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/combination-sum/
 */

//Notes: If paths only branch 'right' and not left, you dont need to worry about uniqueness anymore. It removes a LOT of computational overhead
class CombinationSum {
    companion object {

        // Optimized -- clear out paths early. only copy lists when needed
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

            candidates.sort() // sort so we can early terminate

            val sums = ArrayList<List<Int>>()
            fun buildSums(index: Int, rem: Int, used: ArrayList<Int>) {
                if (rem == 0) sums.add(used.toList())

                for (x in index until candidates.size) {
                    val candidate = candidates[x]

                    if (rem - candidate < 0) break

                    used.add(candidate)
                    buildSums(x, rem - candidate , used)
                    used.removeAt(used.lastIndex)
                }
            }
            buildSums(0, target, ArrayList<Int>())
            return sums
        }


        fun combinationSum_simple(candidates: IntArray, target: Int): List<List<Int>> {

            val sums = ArrayList<List<Int>>()
            fun buildSums(index: Int, rem: Int, used: List<Int>) {
                if (rem == 0) sums.add(used)
                if (rem <= 0) return

                for (x in index until candidates.size) {
                    buildSums(x, rem - candidates[x], used + candidates[x])
                }
            }
            buildSums(0, target, emptyList())
            return sums
        }


        // Blind redo -- same approach but simpler
//        fun combinationSum_old2(candidates: IntArray, target: Int): List<List<Int>> {
//
//            candidates.sortDescending() // reduce search space
//            fun getSums(used: List<Int>, searchIndex: Int): List<List<Int>> {
//                val sum = used.sum()
//                if (sum > target) return emptyList()
//                if (sum == target) return listOf(used)
//
//                return (searchIndex until candidates.size).map { index ->
//                    getSums(used + candidates[index], index)
//                }.flatten()
//            }
//
//            return getSums(emptyList(), 0)
//        }


//        fun combinationSum_OLD(candidates: IntArray, target: Int): List<List<Int>> {
//            //DFS
//            fun getPathToTarget(inputSoFar: List<Int>, index: Int): List<List<Int>>? {
//
//                //Check if end of the line
//                val sum = inputSoFar.sum()
//                if (sum > target) {
//                    return null
//                }
//                if (sum == target) {
//                    return listOf(inputSoFar.sorted())
//                }
//
//                //Try to find new paths
//                val newPaths = ArrayList<List<Int>>()
//                candidates.forEachIndexed { i, candidate ->
//                    if (i >= index) {
//                        getPathToTarget(inputSoFar + candidate, i)?.let { newPaths.addAll(it) }
//                    }
//                }
//                return newPaths
//            }
//
//            //Starting point -- calculate all paths and join to list
//            return ArrayList<List<Int>>().apply { addAll(getPathToTarget(emptyList(), 0) ?: emptyList()) }
//        }
    }
}
