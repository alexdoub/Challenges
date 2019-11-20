package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/19/2019.
 * https://leetcode.com/problems/minimum-falling-path-sum
 */

class MinFallingPathSum {
    companion object {
        fun minFallingPathSum(A: Array<IntArray>): Int {

            val solution = mutableListOf<IntArray>()

            for (row in A.indices) {
                if (row == 0) {
                    solution.add(A[0])
                    continue
                }

                val newRow = IntArray(A[0].size)
                (newRow.indices).forEach { index ->
                    val left = if (index == 0) null else solution[row - 1][index - 1]
                    val mid = solution[row - 1][index]
                    val right = if (index == newRow.size - 1) null else solution[row - 1][index + 1]
                    val min = listOf(left, mid, right).mapNotNull { it }.min()!!
                    newRow[index] = min + A[row][index]
                }
                solution.add(newRow)
            }

            return solution.lastOrNull()?.min() ?: 0
        }
    }
}