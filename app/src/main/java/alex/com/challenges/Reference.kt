package alex.com.challenges

import alex.com.challenges.arrays.*
import alex.com.challenges.cs.*
import alex.com.challenges.dynamic.MinFallingPathSum
import alex.com.challenges.dynamic.StringMultiply
import alex.com.challenges.dynamic.SubarraySumEqualsK
import alex.com.challenges.dynamic.WildcardMatching
import alex.com.challenges.graph.*
import alex.com.challenges.linkedlist.MergeTwoLinkedLists
import alex.com.challenges.stack.ExclusiveTimeOfFunctions
import alex.com.challenges.strings.AddBinaryStrings
import alex.com.challenges.strings.MinWindowSubstring

/**
 * Created by Alex Doub on 3/15/2020.
 */

object Reference {

    fun main() {

        MergeIntoPaddedArrayAndSort


        //CS
        CountSort
        QuickSort
        SelectionSort

        //Basic
        AddBinaryStrings
        MoveZeroes
        InPlaceRemoveElements
        IsSumOfSquares
        IsIntPalindrome
        StringMultiply

        //Stack
        ExclusiveTimeOfFunctions

        //Graph
        FindEventualSafeStates2
        CourseScheduleI
        CourseScheduleII

        //Graph DP
        // Note: Don't ever submit a brute force solution!!!
        MinFallingPathSum

        //Tree Recursion x1
        BinaryTreeAllPaths
        BinaryTreeMinLexographicalPath
        BinaryTreePathSumI
        BinaryTreePathSumII

        //Tree Recursion x2
        BinaryTreeMaxPathSum3
        BinaryTreePathSumIII

        //Arrays
        //Note:
        // 1) Avoid using tricky data structures when loops suffice
        // 2) Sort input and skip duplicate values. When its sorted, checking for duplicates is trivial
        SubarraySumEqualsK
        KMostFrequentInts
        TwoSum
        ThreeSum

        //Array DP
        WildcardMatching

        //Array DFS
        CombinationSum
        CombinationSumII

        //Strings
        MinWindowSubstring

        //Linked List
        MergeTwoLinkedLists
    }
}