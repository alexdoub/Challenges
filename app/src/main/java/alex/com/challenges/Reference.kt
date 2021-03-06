package alex.com.challenges

import alex.com.challenges.arrays.*
import alex.com.challenges.cs.*
import alex.com.challenges.dynamic.*
import alex.com.challenges.graph.*
import alex.com.challenges.linkedlist.MergeTwoLinkedLists
import alex.com.challenges.linkedlist.RemoveDuplicatesFromLinkedList
import alex.com.challenges.stack.ExclusiveTimeOfFunctions
import alex.com.challenges.stack.SimplifyUnixPath
import alex.com.challenges.strings.AddBinaryStrings
import alex.com.challenges.strings.CountDecodePaths
import alex.com.challenges.strings.MinWindowSubstring
import alex.com.challenges.strings.StringIncludesPermutation

/**
 * Created by Alex Doub on 3/15/2020.
 */

object Reference {

    fun main() {

        //CS
        CountSort
        QuickSort
        SelectionSort;  MergedSortedArrayIntoPaddedSortedArray

        //Basic
        AddBinaryStrings
        MoveZeroes; RemoveDuplicatesFromSortedArray //same approach
        InPlaceRemoveElements
        IsSumOfSquares
        IsIntPalindrome
        StringMultiply
        MaxSubArraySum  //Note, simple compared to SubawwaySumEqualsK

        //Stack
        ExclusiveTimeOfFunctions
        SimplifyUnixPath

        //Graph
        FindEventualSafeStates2
        CourseScheduleI
        CourseScheduleII
        FindKthSmallestElementInBST

        //Graph DP
        // Note: Don't ever submit a brute force solution!!!
        MinFallingPathSum

        //Tree Recursion x1
        BinaryTreeAllPaths
        BinaryTreeMinLexographicalPath
        BinaryTreePathSumI
        BinaryTreePathSumII

        // Tree Recursion x2 - Use with partial paths
        // 1st recursive function recursively calls 2nd on every node
        // 2nd recursive function recursively builds paths to leaf nodes
        BinaryTreeMaxPathSum3
        BinaryTreePathSumIII

        //Arrays
        //Note:
        // 1) Avoid using tricky data structures when loops suffice
        // 2) Sort input and skip duplicate values. When its sorted, checking for duplicates is trivial
        CountSubarraysWithSumTarget
        KMostFrequentInts
        TwoSum
        ThreeSum

        //Array DP (Simplified Matrix DP)
        WildcardMatching    //complex, build off previous rows
        UniquePaths         //solution[x][y] = solution[x-1][y] + solution[x][y-1]
        CountDecodePaths    // Hopscotch DP. similar to fibonacci
        CombinationSumIV    // 1d, simple. Permutation. outer loop target, inner loop values.
        CoinChangeII        // 1d, simple. Combination. outer loop values, inner loop target

        //Array DFS
        CombinationSum
        CombinationSumII

        //Strings
        MinWindowSubstring
        StringIncludesPermutation

        //Linked List
        MergeTwoLinkedLists
        RemoveDuplicatesFromLinkedList
    }
}