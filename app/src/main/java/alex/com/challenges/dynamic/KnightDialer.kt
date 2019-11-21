package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/19/2019.
 * https://leetcode.com/problems/knight-dialer
 */

class KnightDialer {
    companion object {
        fun knightDialer(N: Int): Int {

            val MOD = 1_000_000_007
            val moveMap = hashMapOf(
                Pair(1, intArrayOf(6, 8)),
                Pair(2, intArrayOf(7, 9)),
                Pair(3, intArrayOf(4, 8)),
                Pair(4, intArrayOf(3, 9, 0)),
                Pair(5, intArrayOf()),
                Pair(6, intArrayOf(1, 7, 0)),
                Pair(7, intArrayOf(2, 6)),
                Pair(8, intArrayOf(1, 3)),
                Pair(9, intArrayOf(4, 2)),
                Pair(0, intArrayOf(4, 6))
            )

            // Sum up collection without overflowing by modding after each add
            fun Collection<Int>.modSum(): Int {
                if (isEmpty()) return 0

                return reduce { acc, i ->
                    return@reduce (acc + i) % MOD
                }
            }

            // Base case
            var solution = IntArray(10)
            solution.fill(1)

            (1 until N).forEach { _ ->

                val newSolution = IntArray(10)
                for (col in solution.indices) {

                    // Calculate new hops for this digit
                    newSolution[col] = moveMap[col]!!.map { solution[it] }.modSum()
                }
                solution = newSolution
            }

            // Combine options
            return solution.toList().modSum()
        }
    }
}
