package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 3/14/2020.
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */

object CountSubarraysWithSumTarget {

    // Similar to cumulative approach but we use a hashmap to store 'incrementing sums that stopped at this value'
    // Since all values are based off our FULL SUM then they are guaranteed correct
    //O(N) time & space
    fun subarraySum(nums: IntArray, k: Int): Int {
        var matchCount = 0
        var rollingSum = 0
        val cumulativeSumsMap: HashMap<Int, Int> = HashMap()

        //Base case -- indicate starting point. "We have 1 sum that equals 0"
        //If sum-k ever equals 0 then we have a cumulative sum!
        // If our rolling sum ever goes back to 0 then it will increment
        cumulativeSumsMap[0] = 1

        for (num in nums) {
            rollingSum += num

            // See if we had a previous cumulative sum (stopping point)
            // e.g. array= [7,7] k=7.
            // First loop will be 7-7=0, which is the base case
            // Second loop will be 14-7=7, which points to the sum we set on the first iteration
            cumulativeSumsMap[rollingSum - k]?.let { sumCount ->
                matchCount += sumCount
            }

            // Mark our running sum increment
            // aka "We had a sum reach here"
            cumulativeSumsMap[rollingSum] = cumulativeSumsMap.getOrDefault(rollingSum, 0) + 1
        }
        return matchCount
    }

    //Cumulative sums
    //O(N^2) time, O(N) space
    //Loop over once and make an array of "sums from start to here"
    //Double loop over cumulative sums array. If end - start == sum, its a match
    fun subarraySum_cumulative(nums: IntArray, k: Int): Int {
        var count = 0
        val sums = IntArray(nums.size + 1)

        // First iteration. Build cumulative sums -- O(n)
        sums[0] = 0
        for (i in 1..nums.size) {
            sums[i] = sums[i - 1] + nums[i - 1]
        }

        // Find partial sums -- O(n^2 / 2)
        for (start in nums.indices) {
            for (end in start + 1..nums.size) {
                if (sums[end] - sums[start] == k) count++
            }
        }
        return count
    }

    //SUPER SIMPLE
    //O(N^2) time, O(1) space
    fun subarraySum_simple(nums: IntArray, k: Int): Int {
        var count = 0
        for (start in nums.indices) {
            var sumOfThisRange = 0
            for (end in start until nums.size) {
                sumOfThisRange += nums[end]
                if (sumOfThisRange == k) {
                    count++
                }
            }
        }
        return count
    }

    //////////////

    //O(n^2) -- TOO SLOW --- memory was 100% unnecessary
    // This would have been a good approach if there was no requirement for continuous subarrays

    /** Loop over values and maintain in-progress sums. On every value increment previous partial sums & retally sumsMap
     * */
    fun subarraySum_doobies_OG_solution(nums: IntArray, k: Int): Int {
        val sumsMap = HashMap<Int, Int>() //worst case size O(n)
        val partialSums = ArrayList<Int>(nums.size) //constant size O(n)

        //O(N)
        for (num in nums) {
            // Append to partial sums -- O(N)
            for (x in partialSums.indices) {
                partialSums[x] += num
            }
            // Add this value
            partialSums.add(num)

            //Tally sums map -- O(n)
            for (x in partialSums.indices) {
                val partialSum = partialSums[x]
                sumsMap[partialSum] = sumsMap.getOrDefault(partialSum, 0) + 1
            }
        }

        return sumsMap[k] ?: 0
    }

}


/**
Notes:

Since this problem only accounts for continuous sub-arrays, the DP approach doesnt make sense & adds too much overhead.
Since its continuous, you can maintain a cumulative sum & subtract previous cumulative sums at some index to know the value
of the subarray between it.

Approaches:
1) DP array (my solution). Worse than simple double loop
2) Cumulative sums then simple double loop (worse on space)
3) Simple double loop - BEST MEM
4) Rolling sum with cumulative sum map. BEST SPEED
 */