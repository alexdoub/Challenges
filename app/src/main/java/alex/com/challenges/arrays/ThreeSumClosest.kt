package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/5/2020.
 * https://leetcode.com/problems/3sum-closest/
 */

class ThreeSumClosest {
    companion object {

        fun threeSumClosest(nums: IntArray, target: Int): Int {

            nums.sort()
            var sum: Int? = null

            for (x in 0 until nums.size - 2) {
                var front = x+1
                var back = nums.indices.last

                while (front < back) {

                    val thisSum = nums[x] + nums[front] + nums[back]
                    val thisDiff = Math.abs(thisSum - target)
                    if (sum == null || thisDiff < Math.abs(sum - target)) {
                        sum = thisSum
                    }

                    if (thisSum == target) {
                        return thisSum
                    } else if (thisSum < target) {
                        front++
                    } else {
                        back--
                    }
                }
            }

            return sum!!
        }

        fun threeSumClosest_simple(nums: IntArray, target: Int): Int {

            //Simple N^3 loop
            var bestSum: Int? = null
            for (x in 0 until nums.size) {
                for (y in x until nums.size) {
                    for (z in y until nums.size) {
                        //check to make sure unique
                        if (x == y || x == z || y == z) {
                            continue
                        }

                        val thisSum = nums[x] + nums[y] + nums[z]
                        val thisDiff = Math.abs(thisSum - target)
                        if (bestSum == null || thisDiff < Math.abs(bestSum - target)) {
                            bestSum = thisSum
                        }
                    }
                }
            }

            return bestSum!!
        }
    }
}