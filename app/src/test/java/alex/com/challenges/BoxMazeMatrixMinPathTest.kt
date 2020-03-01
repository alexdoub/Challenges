package alex.com.challenges


import org.junit.Test

class BoxMazeMatrixMinPathTest {

    companion object {
        private val hardBoxMap = mutableListOf<String>().apply {
            add("###########")
            add("#G##......#")
            add("#.#.#..####")
            add("#....B....#")
            add("#.####....#")
            add("#.......S.#")
            add("###########")
        }
        private val hardBoxMap2 = mutableListOf<String>().apply {
            add("G#......")
            add(".##.....")
            add(".#...#..")
            add(".....#..")
            add("...#.B..")
            add("...#...S")
        }
        private val mediumBoxMap = mutableListOf<String>().apply {
            add("G......S")
            add("...B....")
            add("........")
        }

        private val looparoundBoxMap = mutableListOf<String>().apply {
            add("G#")
            add("S#")
            add("B#")
            add("..")
            add("..")
            add("..")
        }
        private val simpleBoxMap = mutableListOf<String>().apply {
            add("G...B...S")
        }

    }

    @Test
    fun testSimpleMap() {
        // Try to solve
        val solution = MazeMatrixMinPathPushingBox.solve(simpleBoxMap)!!
        assert(solution.moves == 6)
        assert(solution.pushes == 4)
    }

    @Test
    fun testLooparoundBoxMap() {
        // Try to solve
        val solution = MazeMatrixMinPathPushingBox.solve(looparoundBoxMap)!!
        assert(solution.moves == 9)
        assert(solution.pushes == 6)
    }
}