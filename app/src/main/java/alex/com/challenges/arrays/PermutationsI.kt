package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/9/2020.
 * https://leetcode.com/problems/permutations/
 *
 * Total permutations (Simple) = N!
 * Total Permutations = N! / (N - R)!
 */

class PermutationsI {
    companion object {

        fun permute_PULL(nums: IntArray): List<List<Int>> {

            fun getAllOptions(iteration: Int): List<List<Int>> {
                val options = ArrayList<List<Int>>()

                // Base case - add 1 of everything
                if (iteration == nums.size - 1) {
                    nums.forEach {
                        options.add(listOf(it))
                    }
                } else {
                    // For each possibility, try adding a single digit
                    val possibilities = getAllOptions(iteration + 1)
                    possibilities.forEach { p ->
                        nums.forEach { n ->
                            if (!p.contains(n)) {
                                val newList = p + n
                                options.add(newList)
                            }
                        }
                    }
                }
                return options

            }
            return getAllOptions(0)
        }


        fun permute_PUSH(nums: IntArray): List<List<Int>> {
            val options = ArrayList<List<Int>>()

            fun findOptions(used: List<Int>, remaining: List<Int>) {
                if (remaining.isEmpty()) {
                    options.add(used)
                } else {
                    remaining.forEach {
                        findOptions(used + it, remaining - it)
                    }
                }
            }

            findOptions(emptyList(), nums.toList())
            return options
        }

    }
}

// N^3 indexed loop, skip same indexes
// CANT DO THIS, nums could be any size

// Recursive - would require passing in state or many checks to skip whats already used
// ^^^ hah lol, that was so wrong. it ended up being simpler & faster
