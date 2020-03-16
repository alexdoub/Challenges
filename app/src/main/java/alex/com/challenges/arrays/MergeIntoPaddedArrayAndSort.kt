package alex.com.challenges.arrays

import alex.com.challenges.cs.SelectionSort.selectionSort

/**
 * Created by Alex Doub on 3/3/2020.
 * https://leetcode.com/problems/merge-sorted-array/
 */

object MergeIntoPaddedArrayAndSort {
    //Nums1 MAY have extra padding at the end, representing uninitialized space. That is excluded from the merge & sort
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        // copy values into remaining space
        for (x in m..m+n-1) {
            nums1[x] = nums2[x-m]
        }

        //sort it -- selectionSort
        nums1.selectionSort()
    }
}