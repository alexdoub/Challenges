package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/27/2020.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

object RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        // Anchor represents the end index of the final array
        // It starts at one cause the first value is guaranteed unique thus far
        var anchor = 1
        for (x in 1 until nums.size) {
            // If this value isn't the same as our last anchored value, swap it in & increment anchor
            if (nums[x] != nums[anchor-1]) {
                val tmp = nums[x]
                nums[x] = nums[anchor-1]
                nums[anchor] = tmp
                anchor++
            }
        }

        return anchor
    }
}