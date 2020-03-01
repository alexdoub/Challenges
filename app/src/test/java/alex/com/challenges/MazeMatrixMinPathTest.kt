package alex.com.challenges

import org.junit.Test

class MazeMatrixMinPathTest {

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
        val moves = MazeMatrixMinPath.getMinimumMoves(simplePath)
        assert(moves == 10)
    }

    @Test
    fun testZigZag() {
        // Try to solve
        val moves = MazeMatrixMinPath.getMinimumMoves(zigZag)
        assert(moves == 18)
    }

}
