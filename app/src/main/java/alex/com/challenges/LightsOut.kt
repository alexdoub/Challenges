package alex.com.challenges

class LightsOut {
    companion object {
        fun solve(data: Array<BooleanArray>): Int {
            //Make map of states. Key = game state. Value = moves to get here
            val stateMap = HashMap<String, Int>()

            //add initial state
            var moveNumber = 0
            stateMap[data.toStateString()] = moveNumber

            // EZ case
            if (data.isWinningState()) {
                return moveNumber
            }

            //Loop over all possible options
            // check hash
            // toggle one
            // add to hash

            val options = ArrayList<Array<BooleanArray>>()
            options.add(data)

            while (options.isNotEmpty()) {
                moveNumber += 1
                val option = options.removeAt(0)

                println("------")
                println("Move: ${moveNumber}")
                println("Checking: \n${option.toStateString()}")

                //loop over option, try adding all possible new states to list
                for (row in option.withIndex()) {
                    for (col in row.value.withIndex()) {
                        val toggledList = option.toggleAt(col.index, row.index)

                        if (toggledList.isWinningState()) {
                            return moveNumber
                        }

                        val key = toggledList.toStateString()
                        if (stateMap[key] == null) {
                            stateMap[key] = moveNumber
                            options.add(toggledList)
                            println("New Option: \n$key")
                        } else {
                            println("Ignoring new option: \n$key")
                        }
                        print("")
                    }
                }
            }

            return -1
        }

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
            val mutable = this.toMutableList()

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