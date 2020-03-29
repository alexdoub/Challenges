package alex.com.challenges.arrays

import alex.com.challenges.cs.SelectionSort.selectionSort

/**
 * Created by Alex Doub on 3/3/2020.
 * https://leetcode.com/problems/merge-sorted-array/
 */

object MergedSortedArrayIntoPaddedSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i1 = m-1
        var i2 = n-1
        for (x in (m + n - 1) downTo 0) {
            if (i2 < 0 || (i1 >= 0 && nums1[i1] > nums2[i2])) {
                val tmp = nums1[x]
                nums1[x] = nums1[i1]
                nums1[i1] = tmp
                i1--
            } else {
                nums1[x] = nums2[i2]
                i2--
            }
        }
    }

    //Nums1 MAY have extra padding at the end, representing uninitialized space. That is excluded from the merge & sort
    fun merge_BAD(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        // copy values into remaining space
        for (x in m..m+n-1) {
            nums1[x] = nums2[x-m]
        }

        //sort it -- selectionSort
        nums1.selectionSort()
    }
}