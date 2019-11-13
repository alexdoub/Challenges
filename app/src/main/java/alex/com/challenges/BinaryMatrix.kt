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
                if (colsum.size == matrix.size
                    && topColSum == upper
                    && botColSum == lower) {
                    return matrix
                }

                // Failure - Iterated too far overflow
                if (matrix.size >= colsum.size) {
                    return null
                }

                // Iterate one more time
                val copiedMatrix = matrix.nestedMutableCopy()   //@@TODO: Reduce copying
                val thisColSum = colsum[copiedMatrix.size]
                when (thisColSum) {
                    0 -> {
                        copiedMatrix.add(listOf(0, 0))
                        return computeMatrixInProgress(copiedMatrix)
                    }
                    2 -> {
                        copiedMatrix.add(listOf(1, 1))
                        return computeMatrixInProgress(copiedMatrix)
                    }
                    1 -> {
                        val copiedCopy = copiedMatrix.nestedMutableCopy()

                        //Try left path
                        copiedCopy.add(listOf(1, 0))
                        computeMatrixInProgress(copiedCopy)?.let {
                            return it
                        } ?: run {
                            //It must be with the other path
                            copiedMatrix.add(listOf(0, 1))
                            return computeMatrixInProgress(copiedMatrix)
                        }
                    }
                    else -> {
                        throw RuntimeException("Invalid parameters")
                    }
                }
            }

            // Kick off with empty list
            val initialMatrix = mutableListOf<List<Int>>()
            computeMatrixInProgress(initialMatrix)?.let {
                return it
            } ?: run {
                return emptyList()
            }
        }

        private fun List<List<Int>>.nestedMutableCopy(): MutableList<List<Int>> {
            val newList = mutableListOf<List<Int>>()
            forEach {
                newList.add(it.toMutableList())
            }
            return newList
        }


        // List of List of Ints
        // Outer list holds both rows
        // Inner list holds a single column

        fun List<List<Int>>.getColSum(col: Int): Int {

            if (this.isEmpty()) {
                return 0
            }

            var total = 0
            this.forEach {
                total += it[col]
            }

            return total
        }

        fun List<List<Int>>.addValues(top: Int, bottom:Int) {
            //@@TODO: My list structure is wrong. It should get list[0] and list[1] and add to those. Dont add a new list of 2 values directly to the top element
        }
    }
}