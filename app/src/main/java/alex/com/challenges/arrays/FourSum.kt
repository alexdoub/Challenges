package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/4sum/
 */

class FourSum {
    companion object {

        //Loop over digits, do threesum against it
        fun fourSum(nums: IntArray, target: Int): List<List<Int>> {

            val results = ArrayList<List<Int>>().toMutableSet()

            nums.forEachIndexed { index, x ->

                val filteredNums = nums.filterIndexed { index2, _ -> index != index2 }
                val theseMatches =
                    threeSum(filteredNums.toIntArray(), target - x)
//                println("Enumerating $x    matches: ${theseMatches.joinToString()}")
                val bakedResults = theseMatches.map { it.toMutableList().apply { add(x) }.sorted() }
                results.addAll(bakedResults)
            }

            return results.toList()
        }

        private fun threeSum(nums: IntArray, target: Int): List<List<Int>> {

            val results = mutableSetOf<List<Int>>()

//            println("  ThreeSum: target: ${target}")

            nums.sort()
            nums.forEachIndexed { xi, x ->
                var front = xi + 1
                var back = nums.size - 1

                while (front < back) {
                    val sum = x + nums[front] + nums[back]
                    when {
                        sum == target -> {
                            val entry = listOf(nums[front], nums[back], x).sorted()
                            results.add(entry)
                            front++
                        }
                        sum < target -> front++
                        else -> back--
                    }
                }
            }

            return results.toList()
        }
    }
}