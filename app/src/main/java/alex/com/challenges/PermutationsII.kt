package alex.com.challenges

/**
 * Created by Alex Doub on 1/9/2020.
 * https://leetcode.com/problems/permutations-ii/
 */

class PermutationsII {
    companion object {
        fun permuteUnique(nums: IntArray): List<List<Int>> {

            val options = ArrayList<List<Int>>()

            fun addOptions(used: List<Int>, remaining: List<Int>) {
                if (remaining.isEmpty()) {
                    options.add(used)
                }
                remaining.distinct().forEach {
                    addOptions(used + it, remaining - it)
                }
            }
            addOptions(emptyList(), nums.toList())
            return options
        }
    }
}

/**
 * Scratch data
 * */

//import alex.com.challenges.PermutationsII
//
//val data = intArrayOf(0, 1,2, 2, 2)
//
//val output = PermutationsII.permuteUnique(data)
//
//println("Input size: ${data.size}. Output size:${output.size}")
//println(output.joinToString(separator = "\n "))
//
////1 = 1
////2 = 2         2 x 1
////3 = 6         3 x 2 x 1
////4 = 24        4 x 3 x 2 x 1
////5 = 120