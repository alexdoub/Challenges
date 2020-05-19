package alex.com.challenges.arrays

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * @author alexdoub
 */

// "The function returns true if there is a duplicate item in the array.
// An item is a duplicate if its up to K away and within T away from another element"
object ContainsDuplicatesIII {


    //@@TODO: Can you convert out the long and handle int rollover? without using mod. you could just subtract (t-1) before division (from neg value only). if it rolled over put in the min bucket

    // Group into buckets
    // Normalize buckets by converting to long and subtracting Int Min. (this is because values immediately before zero divide to zero, making the zero bucket too big)
    //372 ms	36 MB
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {

        val t = t.toLong()

        if (t < 0) return false
        if (k <= 0) return false    // cant compare nothing with nothing

        val map = HashMap<Long, Int>()
        for (x in nums.indices) {

            val thisValue = nums[x]
            val thisBucket = (thisValue.toLong() - Int.MIN_VALUE) / (t + 1)

            // Check existing buckets
            map[thisBucket]?.let {
                return true
            }
            map[thisBucket - 1]?.let { thatValue ->
                if (thatValue + t >= thisValue) {
                    return true
                }
            }
            map[thisBucket + 1]?.let { thatValue ->
                if (thisValue + t >= thatValue) {
                    return true
                }
            }

            // Put in the bucket
            map[thisBucket] = thisValue

            // Trim buckets if too many
            if (map.size > k) {
                val y = x - k
                val thatValue = nums[y]
                val thatBucket = (thatValue.toLong() - Int.MIN_VALUE) / (t + 1)
                map.remove(thatBucket)
            }
        }
        return false
    }


    //1348 ms	34.4 MB
    fun containsNearbyAlmostDuplicate_BF3(nums: IntArray, k: Int, t: Int): Boolean {
        for (x1 in nums.indices) {
            val start = Math.max(0, x1 - k)
            val end = Math.min(nums.lastIndex, x1 + k)
            for (x2 in start..end) {
                if (x1 == x2) continue

                val l1 = if (x1 < x2) x1 else x2
                val l2 = if (x1 < x2) x2 else x1

                // Check if K match (less than K away))
                if (l2 - l1 <= k) {
                    val v1 = if (nums[l1] < nums[l2]) nums[l1] else nums[l2]
                    val v2 = if (nums[l1] < nums[l2]) nums[l2] else nums[l1]

                    // Check if T match (diff is less than T)
                    if (v1 + t >= v2) return true
                }
            }
        }
        return false
    }

    // Half the work of bruteforce
    //708 ms	34.7 MB
    fun containsNearbyAlmostDuplicate_BF2(nums: IntArray, k: Int, t: Int): Boolean {
        for (x1 in nums.indices) {
            for (x2 in x1..nums.lastIndex) {
                if (x1 == x2) continue

                val l1 = if (x1 < x2) x1 else x2
                val l2 = if (x1 < x2) x2 else x1

                // Check if K match (less than K away))
                if (l2 - l1 <= k) {
                    val v1 = if (nums[l1] < nums[l2]) nums[l1] else nums[l2]
                    val v2 = if (nums[l1] < nums[l2]) nums[l2] else nums[l1]

                    // Check if T match (diff is less than T)
                    if (v1 + t >= v2) return true
                }
            }
        }
        return false
    }

    // Barebones brute force
    //1592 ms	34.6 MB
    fun containsNearbyAlmostDuplicate_BF(nums: IntArray, k: Int, t: Int): Boolean {
        for (x1 in nums.indices) {
            for (x2 in nums.indices) {
                if (x1 == x2) continue

                val l1 = if (x1 < x2) x1 else x2
                val l2 = if (x1 < x2) x2 else x1

                // Check if K match (less than K away))
                if (l2 - l1 <= k) {
                    val v1 = if (nums[l1] < nums[l2]) nums[l1] else nums[l2]
                    val v2 = if (nums[l1] < nums[l2]) nums[l2] else nums[l1]

                    // Check if T match (diff is less than T)
                    if (v1 + t >= v2) return true
                }
            }
        }
        return false
    }
}