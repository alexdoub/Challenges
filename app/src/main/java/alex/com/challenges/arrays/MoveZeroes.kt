package alex.com.challenges.arrays

/**
Created by Alex Doub on 3/14/2020.

Possibility 1 - make parallel array & replace. O(n) speed, O(n) space
Possibility 2 - Bubble sort the 0s out O(n^2) speed, O(1) memory
Best - O(N) speed & O(1) memory

https://leetcode.com/problems/move-zeroes/

 */

object MoveZeroes {
    //sub-optimal. O(n) space
    fun moveZeroes_1(nums: IntArray): Unit {
        val array = ArrayList<Int>(nums.size)
        for (num in nums) {
            if (num != 0) {
                array.add(num)
            }
        }

        //pt 2
        for (x in nums.indices) {
            if (array.isNotEmpty()) {
                nums[x] = array.removeAt(0)
            } else {
                nums[x] = 0
            }
        }
    }

    //Best solution
    fun moveZeroes(nums: IntArray): Unit {
        var index = 0

        for (x in nums.indices) {
            if (nums[x] != 0) {
                val tmp = nums[x]
                nums[x] = nums[index]
                nums[index] = tmp
                index++
            }
        }
    }
}