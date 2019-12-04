package alex.com.challenges


/**
 * Created by Alex Doub on 12/4/2019.
 * https://leetcode.com/problems/candy/
 */

class CandyDistribution {
    companion object {
        private fun printDebug(string: String) {
            if (false) println(string)
        }

        // Doesn't use sorting, so O(n) time, O(n) space
        fun candy(childrenValues: IntArray): Int {
            val solution = IntArray(childrenValues.size)

            //Iterate from left
            (childrenValues.indices).forEach { index ->
                val value = if (index != 0 && childrenValues[index-1] < childrenValues[index]) {
                    solution[index-1] + 1
                } else 1

                solution[index] = value
            }

            //Iterate from right
            (childrenValues.indices.reversed()).forEach { index ->
                val value = if (index != childrenValues.indices.last
                    && childrenValues[index+1] < childrenValues[index]
                ) {
                    kotlin.math.max(solution[index+1] + 1, solution[index])
                } else solution[index]

                solution[index] = value
            }

            return solution.sum()
        }

        //Time = Sort children by priorities (n log n), enum for fill-out (3 * n)
        //Space = 2 * childrenValues. Priority list & Solution
        fun candy_sort_and_prioritize(childrenValues: IntArray): Int {

            var candyDistributed = 0
            val solution = IntArray(childrenValues.size)

            //Get priority queue (low -> high) with indexes
            val priorities = childrenValues.withIndex().sortedBy { it.value }

            //Enumerate up queue, check neighbors
            priorities.forEach {
                var left: Int? = null
                if (it.index != 0 && childrenValues[it.index] > childrenValues[it.index - 1]) {
                    left = solution[it.index - 1]
                }

                var right: Int? = null
                if (it.index < solution.size - 1 && childrenValues[it.index] > childrenValues[it.index + 1]) {
                    right = solution[it.index + 1]
                }

                val value = kotlin.math.max(left ?: 0, right ?: 0) + 1
                solution[it.index] = value
                candyDistributed += value

                printDebug("${it.index} gets ${value}")
            }

            return candyDistributed
        }
    }
}