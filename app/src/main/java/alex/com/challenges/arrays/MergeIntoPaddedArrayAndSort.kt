package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/3/2020.
 * https://leetcode.com/problems/merge-sorted-array/
 */

class MergeIntoPaddedArrayAndSort {
    //Nums1 MAY have extra padding at the end, representing uninitialized space. That is excluded from the merge & sort
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        // copy values into remaining space
        for (x in m..m+n-1) {
            nums1[x] = nums2[x-m]
        }

        //sort it -- selectionSort
        for (x in 0..m+n-1) {

            // find max
            var maxIndex = x
            for (y in x..m+n-1) {
                val thisVal = nums1[y]
                if (thisVal < nums1[maxIndex]) {
                    maxIndex = y
                }
            }

            // swap this with max
            if (maxIndex != x) {
                val thisVal = nums1[x]
                nums1[x] = nums1[maxIndex]
                nums1[maxIndex] = thisVal
            }
        }
    }
}