package alex.com.challenges.matrix

/**
 * Created by Alex Doub on 3/4/2020.
 * https://leetcode.com/problems/minimum-path-sum/
 */

object MinimumPath2DSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        val solution = Array(grid.size) { IntArray(grid[0].size) }

        for (y in 0 until grid.size) {
            for (x in 0 until grid[y].size) {
                //This value is the cost of this cell PLUS the min of both the existing left/up sums
                val left: Int? = if (x == 0) null else solution[y][x - 1]
                val top: Int? = if (y == 0) null else solution[y - 1][x]

                val thisSum = (listOfNotNull(left, top).min() ?: 0) + grid[y][x]
                solution[y][x] = thisSum
            }
        }

        return solution.last().last()
    }
}