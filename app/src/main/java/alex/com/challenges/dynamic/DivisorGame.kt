package alex.com.challenges.dynamic


/**
 * Created by Alex Doub on 11/22/2019.
 * https://leetcode.com/problems/divisor-game/
 */

class DivisorGame {
    companion object {
        private val DYNAMIC = false
        fun divisorGame(N: Int): Boolean {
            if (DYNAMIC) {
                return divisorGame_dynamic(N)
            } else {
                return divisorGame_recursive(N)
            }
        }

        fun divisorGame_dynamic(N: Int): Boolean {
            val winningStates = BooleanArray(N + 1)

            (0..N).forEach { n ->
                val thisIsWinning = when (n) {
                    0 -> false
                    1 -> false
                    //This number (n) is winning if it has an optimal move
                    else -> (1 until n)
                        .filter { n % it == 0 } // Only check proper divisors
                        .any { divisor ->
                            !winningStates[n - divisor]
                        }
                }
                winningStates[n] = thisIsWinning

            }
            return winningStates[N]
        }

        val memoized = mutableMapOf<Int, Boolean>()
        fun divisorGame_recursive(N: Int): Boolean {

            memoized[1] = false

            fun recurse(myTurn: Boolean, n: Int): Boolean {

                memoized[n]?.let { return it }

                val subIterationHasAWinner = (1..n/2)
                    .filter { n % it == 0 }
                    .map {
                        recurse(!myTurn, n - it)
                    }
                    .any{!it}

                memoized[n] = subIterationHasAWinner
                return subIterationHasAWinner
            }

            return recurse(true, N)
        }

    }
}

/**
 * Bottom up (Dynamic) -> Count up to N, reference stored values to see if it leads to winning state
 *
 * 1 -> loss
 * 2 -> win
 * 3 -> prime
 * 4 -> leads to 2, thus ![2]
 *
 * O(n * .5N)
 * Enumerates up to N
 * for each, Enumerate up to half of that to find divisors
 *
 * Top down (Search) -> Enumerate divisors, check if result is winning state (repeatedly break down)
 *
 *
 *
 *
 * N=100
 * 2(1), 4(1, 2), 5(1), 10(1,2,5), 20(1,2,5,10), 25, 50(1,2,5,10,25)
 *
 * Enumerate up to half that to find divisors
 * Enumerate up to half of divisors to find their divisor
 *
 * Every number is solved, divisors of every number are computed
 *
 * Worst case: search-checks if they do 1 each time, N*(1/2)N
 *
 * */