package alex.com.challenges

//https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
class BinaryMatrix {
    companion object {

        class ProgressState(
            var matrix: List<MutableList<Int>>,
            var topProgress: Int,
            var botProgress: Int
        )

        var iteration = 0

        // Treat problem like DFS search, build solution
        // Problem: StackOverflow on massive inputs
        private fun reconstructMatrix_attempt1(
            upper: Int,
            lower: Int,
            colsum: IntArray
        ): List<List<Int>> {

            // Define recursive function for iteration
            fun computeMatrixInProgress(state: ProgressState): List<List<Int>>? {
                iteration += 1
                println("Iteration:${iteration} Computing state #${state.matrix[0].size}")

                // Failure - Top overflow
                if (state.topProgress > upper) {
                    return null
                }
                // Failure - Bottom overflow
                if (state.botProgress > lower) {
                    return null
                }

                // Success - must come before iteration overflow check
                if (colsum.size == state.matrix[0].size
                    && state.topProgress == upper
                    && state.botProgress == lower
                ) {
                    return state.matrix
                }

                // Failure - Iterated too far overflow
                if (state.matrix[0].size >= colsum.size) {
                    return null
                }

                // Iterate one more time
                val thisColSum = colsum[state.matrix[0].size]
                when (thisColSum) {
                    0 -> {
                        state.addValues(0, 0)
                        return computeMatrixInProgress(state)
                    }
                    2 -> {
                        state.addValues(1, 1)
                        return computeMatrixInProgress(state)
                    }
                    1 -> {
                        //Branch here
                        //Try path thats closer to the goal
                        val topDiff = upper - state.topProgress
                        val botDiff = lower - state.botProgress
                        val startWithTop = topDiff > botDiff

                        fun copyAndCompute(top: Int, bot: Int): List<List<Int>>? {
                            val copyState = state.copy()
                            copyState.addValues(top, bot)
                            return@copyAndCompute computeMatrixInProgress(copyState)
                        }

                        return if (startWithTop) {
                            copyAndCompute(1, 0) ?: copyAndCompute(0, 1)
                        } else {
                            copyAndCompute(0, 1) ?: copyAndCompute(1, 0)
                        }
                    }
                    else -> {
                        throw RuntimeException("Invalid parameters")
                    }
                }
            }

            // Input check to make sure this is even possible. Sum of cols = top limit + bottom limit
            val sumOfCols = colsum.sum()
            if (sumOfCols - upper - lower != 0) {
                return emptyList()
            }

            // Kick off with empty list
            val initialMatrix = listOf(mutableListOf<Int>(), mutableListOf<Int>())
            val initialState = ProgressState(initialMatrix, 0, 0)
            computeMatrixInProgress(initialState)?.let {
                return it
            } ?: run {
                return emptyList()
            }
        }

        fun ProgressState.copy(): ProgressState {
            val matrixCopy = listOf(matrix[0].toMutableList(), matrix[1].toMutableList())
            return ProgressState(matrixCopy, topProgress, botProgress)
        }

        fun ProgressState.addValues(top: Int, bottom: Int) {
            matrix[0].add(top)
            matrix[1].add(bottom)
            topProgress += top
            botProgress += bottom
        }
    }
}

//Optimizations
//1) Reduce copying
//2) Reduce sum checks & fail early

//What is the worst case?
// huge branches then a bot 1 has to propagate way down the list

// 1, 1, 1, 1, 0, 0, 0, 0
//Bot stress is the worst right?