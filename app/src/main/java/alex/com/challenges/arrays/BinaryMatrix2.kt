package alex.com.challenges.arrays

object BinaryMatrix2 {

    //Simple greedy solution - passes
    fun reconstructMatrix(
        upper: Int,
        lower: Int,
        colsum: IntArray
    ): List<List<Int>> {

        // Input validation to make sure this is even possible. Sum of cols = top limit + bottom limit
        val sumOfCols = colsum.sum()
        if (sumOfCols - upper - lower != 0) {
            return emptyList()
        }

        // Enumerate and create
        var upperRemaining = upper
        var lowerRemaining = lower
        val reconstructed = listOf(mutableListOf<Int>(), mutableListOf<Int>())
        for (value in colsum) {
            when (value) {
                0 -> {
                    reconstructed[0].add(0)
                    reconstructed[1].add(0)
                }
                1 -> {
                    if (upperRemaining > lowerRemaining) {
                        reconstructed[0].add(1)
                        reconstructed[1].add(0)
                        upperRemaining -= 1
                    } else {
                        reconstructed[0].add(0)
                        reconstructed[1].add(1)
                        lowerRemaining -= 1
                    }
                }
                2 -> {
                    reconstructed[0].add(1)
                    reconstructed[1].add(1)
                    upperRemaining -= 1
                    lowerRemaining -= 1
                }
            }

            if (upperRemaining < 0 || lowerRemaining < 0) {
                return emptyList()
            }
        }

        return reconstructed
    }
}