package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/5/2020.
 * https://leetcode.com/problems/remove-element/
 */

object InPlaceRemoveElements {

    //2 way loop
    //BAD. Too complex & loses ordering
    fun removeElement_1(nums: IntArray, `val`: Int): Int {
        var start = 0
        var end = nums.size - 1

        // Loop start forwards until we find the val
        while (start <= end) {

            // Found val, now we must find something to swap it with
            if (nums[start] == `val`) {

                // Loop end backwards to find a valid swap
                while (end >= start) {
                    if (nums[end] != `val`) {
                        nums[start] = nums[end]
                        start++
                        end--
                        break
                    }
                    end--
                }
            } else {
                start++
            }
        }
        return start
    }

    // Single loop with single pointer
    // BEST
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var start = 0
        for (x in nums.indices) {
            if (nums[x] != `val`) {
                val tmp = nums[x]
                nums[x] = nums[start]
                nums[start] = tmp
                start++
            }
        }
        return start
    }
}