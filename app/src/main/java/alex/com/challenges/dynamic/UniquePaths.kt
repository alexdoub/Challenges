package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 3/26/2020.
 * https://leetcode.com/problems/unique-paths/
 */

object UniquePaths {

    //2D matrix
    fun uniquePaths_2d(m: Int, n: Int): Int {
        val solution = Array(m){ IntArray(n) }

        for (x in 0 until m) {
            for (y in 0 until n) {
                if (x == 0 || y == 0) {
                    // Base case, the edges have a value of 1
                    solution[x][y] = 1
                } else {
                    // This value is the LEFT and ABOVE value added together.
                    solution[x][y] = solution[x-1][y] + solution[x][y-1]
                }
            }
        }
        return solution[m-1][n-1]
    }

    //1d matrix discarding old rows
    fun uniquePaths(m: Int, n: Int): Int {
        var solution = IntArray(n)

        for (x in 0 until m) {
            val newRow = IntArray(n)
            for (y in 0 until n) {
                if (x == 0 || y == 0) {
                    // Base case, the edges have a value of 1
                    newRow[y] = 1
                } else {
                    // This value is the LEFT and ABOVE value added together.
                    newRow[y] = newRow[y-1] + solution[y]
                }
            }
            solution = newRow
        }
        return solution[n-1]
    }
}