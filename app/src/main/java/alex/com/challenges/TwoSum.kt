package alex.com.challenges

import android.annotation.SuppressLint

//https://leetcode.com/problems/two-sum/
@SuppressLint("UseSparseArrays")
class TwoSum {
    companion object {

        val USE_BRUTE_FORCE = false

        fun getIndicesToMatchTarget(nums: IntArray, target: Int): IntArray {
            if (USE_BRUTE_FORCE) {
                return getIndicesToMatchTarget_brute(nums, target)
            } else {
                return getIndicesToMatchTarget_hash(nums, target)
            }
        }

        private fun getIndicesToMatchTarget_brute(nums: IntArray, target: Int): IntArray {
            for ((index1, value1) in nums.withIndex()) {
                for ((index2, value2) in nums.withIndex()) {
                    if (index1 != index2 && value1 + value2 == target) {
                        return arrayOf(index1, index2).toIntArray()
                    }
                }
            }
            return emptyArray<Int>().toIntArray()
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
    }
}