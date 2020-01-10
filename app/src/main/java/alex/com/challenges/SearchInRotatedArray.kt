package alex.com.challenges

/**
 * Created by Alex Doub on 1/9/2020.
 */

class SearchInRotatedArray {
    companion object {

        fun search(nums: IntArray, target: Int): Int {
            var low = 0
            var high = nums.size - 1

            while (low <= high) {
                val mid = (low + high) / 2

                val lowVal = nums[low]
                val highVal = nums[high]
                val midVal = nums[mid]

                println("Iterating. low:$low mid:$mid high:$high -- lv:$lowVal mv:$midVal hv:$highVal")

                if (lowVal == target) {
                    return low
                }
                if (highVal == target) {
                    return high
                }
                if (midVal == target) {
                    return mid
                }

                // CHECK FOR NORMAL RANGES. ELSE CHECK IN PIVOTED RANGE
                // In left range
                if (target > lowVal && target < midVal) {
                    println("..left")
                    high = mid - 1
                }
                // In right range
                else if (target < highVal && target > midVal) {
                    println("..right")
                    low = mid + 1
                }

                // Left range (with pivot)
                else if (lowVal > midVal) {
                    println(".. left2")
                    high = mid - 1
                }
                // Right range (with pivot)
                else if (highVal < midVal) {
                    println(".. right2")
                    low = mid + 1
                } else {
                    println("ERROR")
                    return -1
                }
            }
            return -1
        }
    }
}