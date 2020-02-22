package alex.com.challenges

/**
 * Created by Alex Doub on 2/21/2020.
 * https://leetcode.com/problems/01-matrix/
 *
 * Option 1: While (changed) loop
 *          High runtime, low memory
 * Option 2: BFS 'pool out'
 *          Low runtime, high memory
 * Option 3: 2-way sweep
 *          Low runtime, low memory
 */

object DistanceFromZeros {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val width = matrix.firstOrNull()?.size ?: 0
        val height = matrix.size
        val solution = Array(matrix.size) { IntArray(width) { Int.MAX_VALUE } }

        fun populate(y: Int, x: Int) {
            if (matrix[y][x] == 0) {
                // Base case
                solution[y][x] = 0
            } else {
                // Gather options
                val options = ArrayList<Int>()
                if (x > 0) {
                    options.add(solution[y][x - 1])
                }
                if (x < width - 1) {
                    options.add(solution[y][x + 1])
                }
                if (y > 0) {
                    options.add(solution[y - 1][x])
                }
                if (y < matrix.size - 1) {
                    options.add(solution[y + 1][x])
                }
                // Set min
                val min = options.filter { it >= 0 }.min() ?: Int.MAX_VALUE
                if (min < solution[y][x]) {
                    solution[y][x] = min + 1
                }
            }
        }

        val yRange = 0 until height
        val xRange = 0 until width
        for (y in yRange) {
            for (x in xRange) {
                populate(y, x)
            }
        }

        for (y in yRange.reversed()) {
            for (x in xRange.reversed()) {
                populate(y, x)
            }
        }

        return solution
    }
}