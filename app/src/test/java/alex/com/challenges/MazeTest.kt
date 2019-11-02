package alex.com.challenges

import org.junit.Test

class MazeTest {

    companion object {
        val simplePath = mutableListOf<String>().apply {
            add("G#######S")
            add(".........")
        }
        val zigZag = mutableListOf<String>().apply {
            add("G#...#...")
            add(".#.#.#.#.")
            add("...#...#S")
        }
    }

    @Test
    fun testSimplePath() {
        // Try to solve
        val moves = Maze.getMinimumMoves(simplePath)
        assert(moves == 10)
    }

    @Test
    fun testZigZag() {
        // Try to solve
        val moves = Maze.getMinimumMoves(zigZag)
        assert(moves == 18)
    }

}
