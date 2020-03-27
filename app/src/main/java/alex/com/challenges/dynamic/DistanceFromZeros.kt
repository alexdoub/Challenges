package alex.com.challenges.dynamic

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

        fun getValue(y: Int, x: Int): Int? {
            if (x < 0 || y < 0 || x > width -1 || y > height - 1) return null
            return solution[y][x]
        }

        fun populate(y: Int, x: Int) {

            if (matrix[y][x] == 0) {
                solution[y][x] = 0
            } else {
                // Gather options, ignore nulls
                val options = listOfNotNull(
                    getValue(y, x-1),
                    getValue(y, x+1),
                    getValue(y-1, x),
                    getValue(y+1, x)
                )
                // Get min of option & set it
                val min = options.filter { it >= 0 }.min()!!
                if (min < solution[y][x]) {
                    solution[y][x] = min + 1
                }
            }
        }

        val yRange = 0 until height
        val xRange = 0 until width

        // TL -> BR sweep
        for (y in yRange) {
            for (x in xRange) {
                populate(y, x)
            }
        }

        // BR -> TL sweep
        for (y in yRange.reversed()) {
            for (x in xRange.reversed()) {
                populate(y, x)
            }
        }

        return solution
    }
}