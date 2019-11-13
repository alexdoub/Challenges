package alex.com.challenges

class BinaryMatrix {
    companion object {
        fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): List<List<Int>> {

            // Define recursive function for iteration
            fun computeMatrixInProgress(matrix: List<MutableList<Int>>): List<List<Int>>? {

                // Failure - Top overflow
                val topColSum = matrix[0].sum()
                if (topColSum > upper) {
                    return null
                }
                // Failure - Bottom overflow
                val botColSum = matrix[1].sum()
                if (botColSum > lower) {
                    return null
                }

                // Success
                if (colsum.size == matrix[0].size
                    && topColSum == upper
                    && botColSum == lower
                ) {
                    return matrix
                }

                // Failure - Iterated too far overflow
                if (matrix[0].size >= colsum.size) {
                    return null
                }

                // Iterate one more time
                val thisColSum = colsum[matrix[0].size]
                when (thisColSum) {
                    0 -> {
                        val updatedCopy = matrix.addValues(0, 0)
                        return computeMatrixInProgress(updatedCopy)
                    }
                    2 -> {
                        val updatedCopy = matrix.addValues(1, 1)
                        return computeMatrixInProgress(updatedCopy)
                    }
                    1 -> {
                        //Branch here
                        //Try left path with copy
                        val copy = matrix.copy()
                        copy.addValues(1, 0)
                        computeMatrixInProgress(copy)?.let {
                            return it
                        } ?: run {
                            //It must be with the other path
                            matrix.addValues(0, 1)
                            return computeMatrixInProgress(matrix)
                        }
                    }
                    else -> {
                        throw RuntimeException("Invalid parameters")
                    }
                }
            }

            // Kick off with empty list
            val initialMatrix = listOf(mutableListOf<Int>(), mutableListOf<Int>())
            computeMatrixInProgress(initialMatrix)?.let {
                return it
            } ?: run {
                return emptyList()
            }
        }

        fun List<MutableList<Int>>.copy(): List<MutableList<Int>> {
            return listOf(this[0].toMutableList(), this[1].toMutableList())
        }

        fun List<MutableList<Int>>.addValues(top: Int, bottom: Int): List<MutableList<Int>> {
            this[0].add(top)
            this[1].add(bottom)
            return this
        }
    }
}