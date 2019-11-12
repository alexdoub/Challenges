package alex.com.challenges

class LightsOut {

    class GameState(val data: Array<BooleanArray>, val moves: Int)

    companion object {

        fun solve(inputData: Array<BooleanArray>): Int {
            return solve_bfs(inputData)
        }

        fun solve_bfs(inputData: Array<BooleanArray>): Int {
            //Make map of states. Key = game state. Value = moves to get here
            val stateMap = HashMap<String, Int>()

            // EZ case
            if (inputData.isWinningState()) {
                return 0
            }

            //add initial state
            stateMap[inputData.toStateString()] = 0

            //Loop over all possible options
            // check hash
            // toggle one
            // add to hash

            val options = ArrayList<GameState>()
            options.add(GameState(inputData, 0))

            var iteration = 0
            while (options.isNotEmpty()) {
                val state = options.removeAt(0)
                val data = state.data
                val moves = state.moves + 1
                val skippedOptions = ArrayList<Array<BooleanArray>>()

//                println("------")
//                println("Checking: \n${data.toStateString()}\nMove:${moves}")

                //loop over option, try adding all possible new states to list
                for (row in data.withIndex()) {
                    for (col in row.value.withIndex()) {
                        val toggledList = data.toggleAt(col.index, row.index)

                        if (toggledList.isWinningState()) {
                            return moves
                        }

                        val key = toggledList.toStateString()
                        if (stateMap[key] == null) {
                            stateMap[key] = moves
                            options.add(GameState(toggledList, moves))
                        } else {
                            skippedOptions.add(toggledList)
                        }
                    }
                }

                iteration += 1
                println("Iteration: ${iteration}. New options count: ${options.size}. Skipped: ${skippedOptions.size}")
            }

            return -1
        }

//        fun solve_uniqueInputs(inputData: Array<BooleanArray>): Int {
//            //@@TODO
//        }

        fun Array<BooleanArray>.isWinningState(): Boolean {
            return !(this.any { it.any { it == true } })
        }

        fun Array<BooleanArray>.toStateString(): String {
            return this.joinToString(
                transform = { row ->
                    row.joinToString(
                        separator = "",
                        transform = { col -> if (col) "1" else "0" })
                },
                separator = "\n"
            )
        }

        fun Array<BooleanArray>.toggleAt(x: Int, y: Int): Array<BooleanArray> {
            //Copy data
            val mutable = mutableListOf<BooleanArray>()
            for (col in this) {
                mutable.add(col.copyOf())
            }

            //center
            mutable[y][x] = !mutable[y][x]

            //Verticals
            if (y > 0) {
                mutable[y - 1][x] = !mutable[y - 1][x]
            }
            if (y < mutable.size - 1) {
                mutable[y + 1][x] = !mutable[y + 1][x]
            }

            //Sides
            if (x > 0) {
                mutable[y][x - 1] = !mutable[y][x - 1]
            }
            if (x < mutable[0].size - 1) {
                mutable[y][x + 1] = !mutable[y][x + 1]
            }

            return mutable.toTypedArray()
        }
    }

}

//1) Brute force BFS
//-try possible solutions, memoize states
//enumerate rows

//2) Rerepresent hash table as 'inputs tried'. toggling an input twice does nothing so only need to focus on that