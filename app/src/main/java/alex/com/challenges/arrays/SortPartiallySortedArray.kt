package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 2/22/2020.
 * https://leetcode.com/discuss/interview-question/378774/
 *
 * Given an array of positive integers (possibly with duplicates) such that the numbers have been sorted only by 28 most significant bits. Sort the array completely
 */

object SortPartiallySortedArray {

    fun bucketSort16Bits(array: IntArray): IntArray {

        val tempSpace = ArrayList<Int>()
        var bucketIndex = 0
        var ptr = 0

        fun unrollBucketStartingFromPtr() {
            tempSpace.sort()    // constant time -- doesn't scale past 16 elements
            while (tempSpace.isNotEmpty()) {
                val x = tempSpace.removeAt(0)
                array[ptr] = x
                ptr++
            }
        }

        // Enumerate array & fill or unroll buckets according to value
        for (pair in array.withIndex()) {
            if (pair.value.getMostSigBits() != bucketIndex) {
                // new bucket found - sort & unroll existing bucket, start new bucket
                unrollBucketStartingFromPtr()
                bucketIndex = pair.value.getMostSigBits()
            }

            tempSpace.add(pair.value)
        }

        //last unroll
        unrollBucketStartingFromPtr()

        return array
    }

    private fun Int.getMostSigBits(): Int {
        return this and 0xFFF0
    }
}