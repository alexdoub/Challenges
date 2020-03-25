package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/24/2020.
 * https://leetcode.com/problems/valid-sudoku/
 */

object SudokuSolver {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val checker = IntArray(10)

        //check rows
        for (x in 0..8) {
            checker.fill(0)
            for (y in 0..8) {
                val cell = board[x][y]
                if (cell != '.') checker[cell.toInt()- '0'.toInt()] += 1
            }
            for (c in checker) {
                if (c > 1) return false
            }
        }


        //check cols
        for (y in 0..8) {
            checker.fill(0)
            for (x in 0..8) {
                val cell = board[x][y]
                if (cell != '.') checker[cell.toInt()- '0'.toInt()] += 1
            }
            for (c in checker) {
                if (c > 1) return false
            }
        }

        //check boxes
        for (rx in 0..2) {
            for (ry in 0..2) {
                checker.fill(0)

                fun fillOut(x: Int, y: Int) {
                    if (board[x][y] != '.') {
                        checker[board[x][y].toInt()- '0'.toInt()] += 1
                    }
                }
                val x = rx * 3
                val y = ry * 3
                fillOut(x, y)
                fillOut(x, y+1)
                fillOut(x, y+2)
                fillOut(x+1, y)
                fillOut(x+1, y+1)
                fillOut(x+1, y+2)
                fillOut(x+2, y)
                fillOut(x+2, y+1)
                fillOut(x+2, y+2)

                for (c in checker) {
                    if (c > 1) return false
                }
            }
        }

        return true
    }
}