package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 1/9/2020.
 */

/**
 * Notes:
Use sliding window approach. Window only gets smaller.
Sliding window works because its sorted
Usually in search we just check hi & lo, but this must also check mid

Gotcha: high = array.size - 1
Gotcha: low <= high (e.g. size 1 array)

Solution 1 did not need to check the size of left/right because of its ordering...
 * */

class SearchInRotatedArray {
    companion object {

        fun search2(nums: IntArray, target: Int): Int {
            var low = 0
            var high = nums.size - 1

            while (low <= high) {
                val mid = (low + high) / 2
                val midVal = nums[mid]
                val lowVal = nums[low]
                val highVal = nums[high]

                if (midVal == target) return mid
                if (lowVal == target) return low
                if (highVal == target) return high

                val leftUnexplored = high != mid
                val inLeftNormal = midVal > lowVal && target > lowVal && target < midVal
                val inLeftRotated = lowVal > midVal && (target > lowVal || target < midVal)

                val rightUnexplored = low != mid
                val inRightNormal = highVal > midVal && target > midVal && target < highVal
                val inRightRotated = midVal > highVal && (target < highVal || target > midVal)

                if (leftUnexplored && (inLeftNormal || inLeftRotated)) {
                    high = mid
                } else if (rightUnexplored && (inRightNormal || inRightRotated)) {
                    low = mid
                } else {
                    return -1
                }
            }

            return -1
        }

        fun search(nums: IntArray, target: Int): Int {
            var low = 0
            var high = nums.size - 1

            while (low <= high) {
                val mid = (low + high) / 2

                val lowVal = nums[low]
                val highVal = nums[high]
                val midVal = nums[mid]

                if (lowVal == target) return low
                if (highVal == target) return high
                if (midVal == target) return mid

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

