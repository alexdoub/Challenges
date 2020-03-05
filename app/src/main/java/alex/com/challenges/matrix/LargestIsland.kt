package alex.com.challenges.matrix

/**
 * Created by Alex Doub on 2019-12-07.
 *
 * Find largest island on a grid.
 * Only immediately adjacent lands count, not diagonal.
 * */


class LargestIsland {
    companion object {
        private fun debugPrint(string: String) {
            if (true) println(string)
        }

        fun areaOfLargestIsland(grid: Array<BooleanArray>): Int {

            val solution: Array<IntArray> = Array(grid.size) {
                IntArray(grid[0].size).apply { fill(-1) }
            }


            //Enumerate grid
            var max: Int = -1
            (grid.indices).forEach { row ->
                (grid[row].indices).forEach { col ->
                    debugPrint("Checking $row, $col")

                    // If unsolved...
                    if (solution[row][col] == -1) {

                        // If theres land there...
                        if (grid[row][col]) {

                            //recursively solve
                            val visited = Array(grid.size) {
                                BooleanArray(grid[0].size)
                            }
                            val value =
                                findSumOfCell(col, row, grid, visited)
                            debugPrint("... Solved! This land has $value spaces")

                            if (value > max) {
                                max = value
                                debugPrint("... ... is new max!")
                            }

                            propagateValue(
                                value,
                                row,
                                col,
                                grid,
                                solution
                            )
                        } else {
                            debugPrint(" ... no land here")
                        }
                    } else {
                        debugPrint("... already solved")
                    }
                }
            }

            return max
        }

        private fun findSumOfCell(x: Int, y: Int, grid: Array<BooleanArray>, visited: Array<BooleanArray>): Int {
            visited[y][x] = true
            var sum = 1

            //Check left
            if (x != 0 && !visited[y][x - 1] && grid[y][x - 1]) {
                sum += findSumOfCell(x - 1, y, grid, visited)
            }
            //Right
            if (x != visited[0].size - 1 && !visited[y][x + 1] && grid[y][x + 1]) {
                sum += findSumOfCell(x + 1, y, grid, visited)
            }
            //Top
            if (y != 0 && !visited[y - 1][x] && grid[y - 1][x]) {
                sum += findSumOfCell(x, y - 1, grid, visited)
            }
            //Bot
            if (y != visited.size - 1 && !visited[y + 1][x] && grid[y + 1][x]) {
                sum += findSumOfCell(x, y + 1, grid, visited)
            }

            return sum
        }

        private fun propagateValue(value: Int, x: Int, y: Int, grid: Array<BooleanArray>, solution: Array<IntArray>) {
            solution[y][x] = value

            //Check left
            if (x != 0 && solution[y][x - 1] == -1 && grid[y][x-1]) {
                propagateValue(value, x - 1, y, grid, solution)
            }
            //Right
            if (x != solution[0].size - 1 && solution[y][x + 1] == -1 && grid[y][x+1]) {
                propagateValue(value, x + 1, y, grid, solution)
            }
            //Top
            if (y != 0 && solution[y - 1][x] == -1 && grid[y-1][x]) {
                propagateValue(value, x, y - 1, grid, solution)
            }
            //Bot
            if (y != solution.size - 1 && solution[y + 1][x] == -1 && grid[y+1][x]) {
                propagateValue(value, x, y + 1, grid, solution)
            }
        }
    }
}