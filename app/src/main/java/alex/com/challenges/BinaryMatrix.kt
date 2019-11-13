package alex.com.challenges

import java.lang.RuntimeException

class BinaryMatrix {
    companion object {
        fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): List<List<Int>> {

            // Define recursive function for iteration
            fun computeMatrixInProgress(matrix: List<List<Int>>): List<List<Int>>? {

                // Failure - Top overflow
                val topColSum = matrix.getColSum(0)
                if (topColSum > upper) {
                    return null
                }
                // Failure - Bottom overflow
                val botColSum = matrix.getColSum(1)
                if (botColSum > lower) {
                    return null
                }

                // Success
                if (colsum.size == matrix[0].size
                    && topColSum == upper
                    && botColSum == lower) {
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
                        val updatedCopy = matrix.copyAndAddValues(0, 0)
                        return computeMatrixInProgress(updatedCopy)
                    }
                    2 -> {
                        val updatedCopy = matrix.copyAndAddValues(1, 1)
                        return computeMatrixInProgress(updatedCopy)
                    }
                    1 -> {
                        //Try left path
                        val updatedCopy = matrix.copyAndAddValues(1, 0)
                        computeMatrixInProgress(updatedCopy)?.let {
                            return it
                        } ?: run {
                            //It must be with the other path
                            val updatedCopy2 = matrix.copyAndAddValues(0, 1)
                            return computeMatrixInProgress(updatedCopy2)
                        }
                    }
                    else -> {
                        throw RuntimeException("Invalid parameters")
                    }
                }
            }

            // Kick off with empty list
            val initialMatrix = listOf(listOf<Int>(), listOf<Int>())
            computeMatrixInProgress(initialMatrix)?.let {
                return it
            } ?: run {
                return emptyList()
            }
        }

        fun List<List<Int>>.getColSum(col: Int): Int {

            if (this.isEmpty()) {
                return 0
            }

            var total = 0
            this[col].forEach {
                total += it
            }

            return total
        }

        //@@TODO: Reduce copying!
        fun List<List<Int>>.copyAndAddValues(top: Int, bottom:Int): List<List<Int>> {
            val topList = this.getOrNull(0)?.toMutableList() ?: mutableListOf()
            topList.add(top)
            val botList = this.getOrNull(1)?.toMutableList() ?: mutableListOf()
            botList.add(bottom)
            return listOf(topList, botList)
        }
    }
}