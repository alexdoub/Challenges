package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/8/2020.
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

class GetRangeOfNumInArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {

        var first = -1
        var last = -1

        // Find LEFTMOST index of val
        var startIndex = 0
        var endIndex = nums.size - 1
        while (startIndex <= endIndex) {
            val mid = (startIndex + endIndex) / 2
            val midVal = nums[mid]

            when {
                midVal > target -> { endIndex = mid - 1 }
                midVal < target -> { startIndex = mid + 1 }
                else -> {
                    first = mid
                    endIndex--
                }
            }
        }
        if (first == -1) {
            return intArrayOf(-1, -1)
        }


        // Find RIGHTMOST index of val
        startIndex = 0
        endIndex = nums.size - 1
        while (startIndex <= endIndex) {
            val mid = (startIndex + endIndex) / 2
            val midVal = nums[mid]

            when {
                midVal > target -> { endIndex = mid - 1 }
                midVal < target -> { startIndex = mid + 1 }
                else -> {
                    last = mid
                    startIndex++
                }
            }
        }

        return intArrayOf(first, last)
    }
}

// NOTE: Dont need out of bounds checks for sliding window!
// 2: Don't search for value 'next to' this. It just makes it confusing
// 3: Keep best during iteration until base case is met. (Instead of doing a quick check for the next value)