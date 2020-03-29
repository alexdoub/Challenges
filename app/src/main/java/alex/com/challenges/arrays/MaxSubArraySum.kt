package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/29/2020.
 * https://leetcode.com/problems/maximum-subarray/
 */

// Similar to CountSubarraysWithSumTarget but much simpler. No need to store partial sums because we aren't counting anything, just finding max
object MaxSubArraySum {
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var sum = 0
        for (n in nums) {
            if (sum < 0) sum = 0
            sum += n

            if (sum > max) max = sum
        }

        return max
    }
}