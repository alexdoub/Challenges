package alex.com.challenges.matrix

/**
 * Created by Alex Doub on 2/5/2020.
 * https://leetcode.com/problems/number-of-islands/
 *
 * Imagine minesweeper. Tapping on an empty block zeroes out all nearby empty blocks.
 * Now loop over the grid doing that.
 *
 * Time Complexity: O(grid.width * grid.height)
 *                  Simple loop over grid. Also simple recursive loop for zeroing out.
 * Space Complexity: O(grid.width * grid.height)
 *                  This is because of the worst case situation in which we have to zero out the entire grid.
 *                  The recursive function will push stacks as it does DFS zeroing out the island
 */

class NumIslands {
    companion object {
        fun numIslands(grid: Array<CharArray>): Int {

            // Zeros out this cell & all adjacent 1 cells
            fun zeroOutIsland(y: Int, x: Int) {
                grid[y][x] = '0'

                if (y < grid.size - 1 && grid[y + 1][x] == '1') {
                    zeroOutIsland(y + 1, x)
                }
                if (y > 0 && grid[y - 1][x] == '1') {
                    zeroOutIsland(y - 1, x)
                }
                if (x < grid[0].size - 1 && grid[y][x + 1] == '1') {
                    zeroOutIsland(y, x + 1)
                }
                if (x > 0 && grid[y][x - 1] == '1') {
                    zeroOutIsland(y, x - 1)
                }
            }

            // Iterate grid and zero out islands as they come
            var islands = 0
            for (y in grid.indices) {
                for (x in grid[y].indices) {
                    if (grid[y][x] == '1') {
                        islands++
                        zeroOutIsland(y, x)
                    }
                }
            }

            return islands
        }
    }
}