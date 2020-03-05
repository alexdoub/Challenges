package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/5/2020.
 * https://leetcode.com/problems/remove-element/
 */

object InPlaceRemoveElements {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var start = 0
        var end = nums.size - 1
        //fw start until you find val,
        //inner loop until you find non val & swap
        while (start <= end) {

            //found a swappable
            if (nums[start] == `val`) {
                //loop backwards to find a valid swap
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
}