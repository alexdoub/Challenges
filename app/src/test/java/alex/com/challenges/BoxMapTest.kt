package alex.com.challenges


import org.junit.Test

class BoxMapTest {

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

        var mapToUse = hardBoxMap

        val START = "S"
        val GOAL = "G"
        val BOX = "B"
        val WALL = "#"

        val WRONG_STEP = Int.MAX_VALUE
    }

    @Test
    fun testMyStuff() {
        //Find box & player position
        var player = Pair(-1, -1)
        var boxStart = Pair(-1, -1)
        for ((yIndex, lines) in mapToUse.withIndex()) {
            for ((xIndex, char) in lines.withIndex()) {
                if (char.toString() == BOX) {
                    boxStart = Pair(xIndex, yIndex)
                }
                if (char.toString() == START) {
                    player = Pair(xIndex, yIndex)
                }
            }
        }

        // Try to solve
        getMinimumPushes(boxStart, player)?.let {
            println("Found solution with ${it.moves} moves ${it.pushes} box pushes")
            println("Path from player perspective: ${it.playerPath}")
        } ?: run {
            println("No solution")
        }
    }



    //////////

    class ProgressState(val box: Pair<Int, Int>, val player: Pair<Int, Int>, val moves: Int, val pushes: Int, val playerPath: String) {
        fun toWinState() = WinState(playerPath, moves, pushes)
    }
    class WinState(val playerPath: String, val moves: Int, val pushes: Int)

    //must be BFS, not DFS! Simply because of endless loops

    fun getMinimumPushes(boxStartPosition: Pair<Int, Int>, playerStartPosition: Pair<Int, Int>): WinState? {

        val potentialStates = ArrayList<ProgressState>()

        // Initial state
        val initialState = ProgressState(boxStartPosition, playerStartPosition, 0, 0, "")
        potentialStates.add(initialState)

        while (potentialStates.isNotEmpty()) {
            val state = potentialStates.removeAt(0)

            if (state.box.isBoxGoal()) {
                return state.toWinState()
            }

            getNewProgressStateIfValid(state.box.getTop(), state.box.getBottom(), state, " push up ")?.let { potentialStates.add(it) }
            getNewProgressStateIfValid(state.box.getBottom(), state.box.getTop(), state, " push down ")?.let { potentialStates.add(it) }
            getNewProgressStateIfValid(state.box.getLeft(), state.box.getRight(), state, " push left ")?.let { potentialStates.add(it) }
            getNewProgressStateIfValid(state.box.getRight(), state.box.getLeft(), state, " push right ")?.let { potentialStates.add(it) }
        }

        println("Out of possible moves")
        return null
    }

    private fun getNewProgressStateIfValid(newBoxLocation: Pair<Int, Int>, newPlayerLocation: Pair<Int, Int>, oldState: ProgressState, pushedPath: String): ProgressState? {
        if (newBoxLocation.isValidPosition()) {
            val pathToHere = newPlayerLocation.playerPathToHere(oldState.player, oldState.box)
            val pathLength = pathToHere.getPathLength()
            if (pathLength < WRONG_STEP) {
                val newPushes = oldState.pushes + 1
                val newMoves = oldState.moves + pathLength
                val newPath = oldState.playerPath + pathToHere + pushedPath

                return ProgressState(newBoxLocation, newPlayerLocation, newMoves, newPushes, newPath)
            } else {
                print("Valid box spot but player cant navigate to $newPlayerLocation from ${oldState.player} with box at ${oldState.box}")
            }
        } else {
            println("Cannot push box from ${oldState.box} to $newBoxLocation. Player at ${oldState.player}")
        }
        return null
    }

    fun Pair<Int, Int>.isValidPosition(): Boolean {
        val row = second
        val column = first

        // Basic test
        if (row < 0 || row > mapToUse.size - 1)
            return false
        if (column < 0 || column > mapToUse[0].length - 1)
            return false
        // Not wall
        if (mapToUse[row][column].toString() == WALL)
            return false

        return true
    }

    fun Pair<Int, Int>.isValidPlayerMove(alreadyBeenLocations: ArrayList<Pair<Int, Int>>): Boolean {
        if (alreadyBeenLocations.contains(this)) {
            return false
        }
        return isValidPosition()
    }

    fun Pair<Int, Int>.playerPathToHere(playerLocation: Pair<Int, Int>, boxLocation: Pair<Int, Int>): String? {

        // Avoid Impossible pushes
        if (!isValidPosition() || this.isWall()) {
            return null
        }

        // Avoid unreachable player paths
        val blockedLocations = ArrayList<Pair<Int, Int>>()
        blockedLocations.add(boxLocation)
        return getPlayerPath(playerLocation, this, blockedLocations)
    }

    fun getPlayerPath(currentPosition: Pair<Int, Int>, endPosition: Pair<Int, Int>, blockedLocations: ArrayList<Pair<Int, Int>>): String? {

        val newBlockedLocations: ArrayList<Pair<Int, Int>> = ArrayList<Pair<Int, Int>>(blockedLocations)
        newBlockedLocations.add(currentPosition)

        if (currentPosition == endPosition) {
            return ""
        }

        val topPosition = currentPosition.getTop()
        val topPath =
                if (!topPosition.isValidPlayerMove(newBlockedLocations)) {
                    null
                } else {
                    val thatPath = getPlayerPath(topPosition, endPosition, newBlockedLocations)
                    if (thatPath != null) {
                        "U" + thatPath
                    } else {
                        null
                    }
                }

        val botPosition = currentPosition.getBottom()
        val botPath =
                if (!botPosition.isValidPlayerMove(newBlockedLocations)) {
                    null
                } else {
                    val thatPath = getPlayerPath(botPosition, endPosition, newBlockedLocations)
                    if (thatPath != null) {
                        "D" + thatPath
                    } else {
                        null
                    }
                }

        val leftPosition = currentPosition.getLeft()
        val leftPath =
                if (!leftPosition.isValidPlayerMove(newBlockedLocations)) {
                    null
                } else {
                    val thatPath = getPlayerPath(leftPosition, endPosition, newBlockedLocations)
                    if (thatPath != null) {
                        "L" + thatPath
                    } else {
                        null
                    }
                }

        val rightPosition = currentPosition.getRight()
        val rightPath =
                if (!rightPosition.isValidPlayerMove(newBlockedLocations)) {
                    null
                } else {
                    val thatPath = getPlayerPath(rightPosition, endPosition, newBlockedLocations)
                    if (thatPath != null) {
                        "R" + thatPath
                    } else {
                        null
                    }
                }

        var shortestPath:String? = null

        if (botPath.getPathLength() < shortestPath.getPathLength()) {
            shortestPath = botPath
        }
        if (topPath.getPathLength() < shortestPath.getPathLength()) {
            shortestPath = topPath
        }
        if (leftPath.getPathLength() < shortestPath.getPathLength()) {
            shortestPath = leftPath
        }
        if (rightPath.getPathLength() < shortestPath.getPathLength()) {
            shortestPath = rightPath
        }
        return shortestPath
    }

    fun String?.getPathLength(): Int {
        if (this == null) {
            return WRONG_STEP
        }
        return this.length
    }

    fun Pair<Int, Int>.isBoxGoal(): Boolean {
        return mapToUse[second][first].toString() == GOAL
    }

    fun Pair<Int, Int>.isWall(): Boolean {
        return mapToUse[second][first].toString() == WALL
    }

    fun Pair<Int, Int>.getLeft() = Pair(first - 1, second)
    fun Pair<Int, Int>.getRight() = Pair(first + 1, second)
    fun Pair<Int, Int>.getTop() = Pair(first, second - 1)
    fun Pair<Int, Int>.getBottom() = Pair(first, second + 1)
}