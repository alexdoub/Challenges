package alex.com.challenges


import org.junit.Test

class BoxMaze {

    companion object {
        val hardBoxMap = mutableListOf<String>().apply {
            add("###########")
            add("#G##......#")
            add("#.#.#..####")
            add("#....B....#")
            add("#.####....#")
            add("#.......S.#")
            add("###########")
        }
        val hardBoxMap2 = mutableListOf<String>().apply {
            add("G#......")
            add(".##.....")
            add(".#...#..")
            add(".....#..")
            add("...#.B..")
            add("...#...S")
        }
        val mediumBoxMap = mutableListOf<String>().apply {
            add("G......S")
            add("...B....")
            add("........")
        }

        val looparoundBoxMap = mutableListOf<String>().apply {
            add("G#")
            add("S#")
            add("B#")
            add("..")
            add("..")
            add("..")
        }
        val simpleBoxMap = mutableListOf<String>().apply {
            add("G...B...S")
        }

    }

    @Test
    fun testSimpleMap() {
        // Try to solve
        val solution = BoxMap.solve(simpleBoxMap)!!
        assert(solution.moves == 6)
        assert(solution.pushes == 4)
    }
}