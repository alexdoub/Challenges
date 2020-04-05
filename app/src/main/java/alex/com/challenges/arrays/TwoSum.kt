package alex.com.challenges.arrays

import android.annotation.SuppressLint

//https://leetcode.com/problems/two-sum/
@SuppressLint("UseSparseArrays")
class TwoSum {
    companion object {

        fun getIndicesToMatchTarget(nums: IntArray, target: Int): IntArray {
            return twoSum_simplified(nums, target)
        }

        //Enumerate in order with early return. No need to store a list of indices
        private fun twoSum_simplified(nums: IntArray, target: Int): IntArray {
            val hashMap = HashMap<Int, Int>()

            for (x in nums.indices) {
                val num = nums[x]

                if (hashMap[target - num] != null) {
                    return intArrayOf(x, hashMap[target - num]!!)
                }

                hashMap[num] = x
            }
            // No match found
            return IntArray(0)
        }

        private fun getIndicesToMatchTarget_hash(nums: IntArray, target: Int): IntArray {
            val indexed = nums.withIndex()
            val hashMap = HashMap<Int, MutableList<Int>>()

            // Create hashmap. Index is the `val` of the number, Value is an array of indexes in the original array
            for (indexedVal in indexed) {
                if (hashMap[indexedVal.value] == null) {
                    hashMap[indexedVal.value] = ArrayList<Int>()
                }
                hashMap[indexedVal.value]!!.add(indexedVal.index)
            }

            for (value in hashMap.keys) {
                val compliment = target - value
                val indexesOfCompliment = hashMap[compliment]

                indexesOfCompliment?.let { complimentIndexes ->

                    if (complimentIndexes.size >= 2) {
                        return complimentIndexes.subList(0, 2).toIntArray()
                    } else {
                        return arrayOf(hashMap[value]!![0], complimentIndexes[0]).toIntArray()
                    }
                }
            }

            return emptyArray<Int>().toIntArray()
        }

        private fun getIndicesToMatchTarget_bruteforce(nums: IntArray, target: Int): IntArray {
            for ((index1, value1) in nums.withIndex()) {
                for ((index2, value2) in nums.withIndex()) {
                    if (index1 != index2 && value1 + value2 == target) {
                        return arrayOf(index1, index2).toIntArray()
                    }
                }
            }
            return emptyArray<Int>().toIntArray()
        }
    }
}