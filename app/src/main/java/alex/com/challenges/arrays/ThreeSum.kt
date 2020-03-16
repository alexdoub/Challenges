package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/3sum/
 */

class ThreeSum {
    companion object {

        // Skip duplicate values in all 3 loops (x, left, right)
        //432 ms	47.5 MB
        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()
            val solutions = ArrayList<List<Int>>()
            for (x in nums.indices) {

                //skip duplicate values
                if (x > 0 && nums[x] == nums[x - 1]) continue

                var left = x + 1
                var right = nums.size - 1
                while (left < right) {

                    val leftVal = nums[left]
                    val rightVal = nums[right]
                    val sum = nums[x] + nums[left] + nums[right]

                    when {
                        sum == 0 -> {
                            solutions.add(listOf(nums[x], nums[left], nums[right]).sorted())
                            while (left < right && nums[left] == leftVal) left++
                        }
                        sum > 0 -> {
                            while (right > left && nums[right] == rightVal) right--
                        }
                        else -> {
                            while (left < right && nums[left] == leftVal) left++
                        }
                    }
                }
            }
            return solutions
        }

        /**
         *  Approach 2: Sort. Loop input once, do sliding window check (2 sum) for compliment
         *
         *  Must use result set or else will get duplicates
         *
         *  Runtime: NLogN sort + (loop x sliding window == N^2)
         *  RunSpace: 1 per pair, but limited by uniqueness...
         *          If all input was same = 1
         *          If all input was different = list / 3
         * */
        //1012 ms	49.7 MB
        fun threeSum_set(nums: IntArray): List<List<Int>> {

            val results = mutableSetOf<List<Int>>()

            nums.sort()
            nums.forEachIndexed { xi, x ->
                var front = xi + 1
                var back = nums.size - 1

                while (front < back) {
                    val sum = x + nums[front] + nums[back]
                    when {
                        sum == 0 -> {
                            val entry = listOf(nums[front], nums[back], x).sorted()
                            results.add(entry)
                            front++
                        }
                        sum < 0 -> front++
                        else -> back--
                    }
                }
            }

            return results.toList()
        }


        /**
        Approach 1: Make table of pairs, do final enumeration searching for last pair
        n^2 pair matching, n^2/nlogn final enumeration

        Correct but not fast enough
         */
        fun threeSum_wut(nums: IntArray): List<List<Int>> {
            //do n^2 enumeration to build list of compliments
            val compliments = HashMap<Int, ArrayList<Pair<Int, Int>>>()
            nums.forEachIndexed { i1, x1 ->
                (i1 until nums.size).forEach { i2 ->
                    val x2 = nums[i2]
                    if (i2 > i1) {
                        val sum = x1 + x2
                        if (compliments[sum] == null) {
                            compliments[sum] = ArrayList<Pair<Int, Int>>()
                        }
                        compliments[sum]!!.add(Pair(i1, i2))
                        println("$x1 & $x2 sum to $sum")
                    }
                }
            }

            println("Done with phase 1")

            //do final n enumeration to check for matches
            val resultSet = emptySet<List<Int>>().toMutableSet()
            nums.forEachIndexed { i, x ->

                println(".. Enumerating nums. Compliment for $x has ${compliments[0 - x]?.size ?: "null"}")

                compliments[0 - x]?.forEach { pair ->
                    if (pair.first != i && pair.second != i) {
                        resultSet.add(listOf(x, nums[pair.first], nums[pair.second]).sorted())
                        println(".. .. did add match: ${listOf(x, nums[pair.first], nums[pair.second]).sorted().toString()}")
                    }
                }
            }

            return resultSet.toList()
        }

        private fun printDebug(string: String) {
            if (false) println(string)
        }
    }
}
