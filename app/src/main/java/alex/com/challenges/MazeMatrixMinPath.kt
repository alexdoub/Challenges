package alex.com.challenges

class MazeMatrixMinPath {

    companion object {
        private var mapToUse: List<String> = emptyList()

        private val PLAYER_START = "S"
        private val PLAYER_GOAL = "G"
        private val WALL = "#"

        private val WRONG_STEP = Int.MAX_VALUE

        fun getMinimumMoves(map: List<String>) : Int {
            mapToUse = map

            //Find box & player position
            var player = Pair(-1, -1)
            var goal = Pair(-1, -1)
            for ((yIndex, lines) in mapToUse.withIndex()) {
                for ((xIndex, char) in lines.withIndex()) {
                    if (char.toString() == PLAYER_GOAL) {
                        goal = Pair(xIndex, yIndex)
                    }
                    if (char.toString() == PLAYER_START) {
                        player = Pair(xIndex, yIndex)
                    }
                }
            }

            // Try to solve
            return getMinimumMoves(player, goal, ArrayList())
        }

        private fun getMinimumMoves(startPosition: Pair<Int, Int>, endPosition: Pair<Int, Int>, blockedLocations: ArrayList<Pair<Int, Int>>): Int {

            val visitedLocations: ArrayList<Pair<Int, Int>> = ArrayList<Pair<Int, Int>>(blockedLocations)
            visitedLocations.add(startPosition)

            if (startPosition == endPosition) {
                return 0
            }

            val topPosition = startPosition.getTop()
            val topPathMoves =
                if (topPosition.isValid(visitedLocations)) {
                    1 + getMinimumMoves(topPosition, endPosition, visitedLocations)
                } else {
                    WRONG_STEP
                }

            val botPosition = startPosition.getBottom()
            val botPathMoves =
                if (botPosition.isValid(visitedLocations)) {
                    1 + getMinimumMoves(botPosition, endPosition, visitedLocations)
                } else {
                    WRONG_STEP
                }

            val leftPosition = startPosition.getLeft()
            val leftPathMoves =
                if (leftPosition.isValid(visitedLocations)) {
                    1 + getMinimumMoves(leftPosition, endPosition, visitedLocations)
                } else {
                    WRONG_STEP
                }

            val rightPosition = startPosition.getRight()
            val rightPathMoves =
                if (rightPosition.isValid(visitedLocations)) {
                    1 + getMinimumMoves(rightPosition, endPosition, visitedLocations)
                } else {
                    WRONG_STEP
                }

            var shortestMoves = botPathMoves
            if (topPathMoves < shortestMoves) shortestMoves = topPathMoves
            if (leftPathMoves < shortestMoves) shortestMoves = leftPathMoves
            if (rightPathMoves < shortestMoves) shortestMoves = rightPathMoves
            return shortestMoves
        }

        // FIRST is the row. Starting at top = 0
        // SECOND is the column. Starting at top = 0
        fun Pair<Int, Int>.isValid(visitedOrBox: ArrayList<Pair<Int, Int>>): Boolean {
            val row = second
            val column = first

            if (row < 0 || row > mapToUse.size - 1)
                return false
            if (column < 0 || column > mapToUse[0].length - 1)
                return false
            if (mapToUse[row][column].toString() == WALL)
                return false
            if (visitedOrBox.contains(this))
                return false
            return true
        }

        fun Pair<Int, Int>.getLeft() = Pair(first - 1, second)
        fun Pair<Int, Int>.getRight() = Pair(first + 1, second)
        fun Pair<Int, Int>.getTop() = Pair(first, second - 1)
        fun Pair<Int, Int>.getBottom() = Pair(first, second + 1)
    }
}