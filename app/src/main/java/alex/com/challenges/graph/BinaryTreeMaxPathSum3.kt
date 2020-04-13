package alex.com.challenges.graph

import alex.com.challenges.common.ListNode
import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 2/29/2020.
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

object BinaryTreeMaxPathSum3 {

    //NOTE: Tried to set a cache so we wouldnt recalculate the same paths again and again but for some reason its not working
//    //Top level - call on all nodes. This is the only place a branch can happen.
//    fun maxPathSum(root: TreeNode?): Int {
//        val map = HashMap<TreeNode, Int>()
//        return maxPathSumWithMap(root, map)
//    }
//    fun maxPathSumWithMap(root: TreeNode?, map: HashMap<TreeNode, Int>): Int {
//        if (root == null) return Int.MIN_VALUE
//
//        val fromLeft = maxPathSum(root.left)
//        val fromRight = maxPathSum(root.right)
//        val fromEitherSide = Math.max(fromLeft, fromRight)
//
//
//        val sumBranchingHere = maxPathSumWithoutBranching(root.left, 0, map) + maxPathSumWithoutBranching(root.right, 0, map) + root.`val`
//
//        return Math.max(sumBranchingHere, fromEitherSide)
//    }
//
//    // A branch has already happened, now we must stay on a single path
//    fun maxPathSumWithoutBranching(root: TreeNode?, sum: Int, map: HashMap<TreeNode, Int>): Int {
//        if (root == null) return sum
//
//        map[root]?.let {
//            return it + sum
//        }
//
//        //3 options. stop here, go left, go right
//        val left = maxPathSumWithoutBranching(root.left, sum + root.`val`, map)
//        val right = maxPathSumWithoutBranching(root.right, sum + root.`val`, map)
//        val maxFromSingleSide = Math.max(left, right)
//
//        map[root] = maxFromSingleSide - sum
//
//        return Math.max(sum, maxFromSingleSide)
//    }

//===================================================================================

    //Top level - call on all nodes. This is the only place a branch can happen.
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) return Int.MIN_VALUE

        val fromLeft = maxPathSum(root.left)
        val fromRight = maxPathSum(root.right)
        val fromEitherSide = Math.max(fromLeft, fromRight)

        val sumBranchingHere = maxPathSumWithoutBranching(root.left, 0) + maxPathSumWithoutBranching(root.right, 0) + root.`val`

        return Math.max(sumBranchingHere, fromEitherSide)
    }

    // A branch has already happened, now we must stay on a single path
    fun maxPathSumWithoutBranching(root: TreeNode?, sum: Int): Int {
        if (root == null) return sum

        //3 options. stop here, go left, go right
        val maxFromSingleSide = Math.max(
            maxPathSumWithoutBranching(root.left, sum + root.`val`),
            maxPathSumWithoutBranching(root.right, sum + root.`val`)
        )
        return Math.max(sum, maxFromSingleSide)
    }

//===================================================================================

//    fun maxPathSum(root: TreeNode?): Int {
//        if (root == null) return Integer.MIN_VALUE
//
//        val notIncludingRoot = Math.max(
//            maxPathSum(root.left),
//            maxPathSum(root.right)
//        )
//        val includingRoot = root.`val` + maxPathSumWithoutBranching(root.left, 0) + maxPathSumWithoutBranching(root.right, 0)
//        return Math.max(includingRoot, notIncludingRoot)
//    }
//
//    private fun maxPathSumWithoutBranching(root: TreeNode?, sum: Int): Int {
//        if (root == null) return sum
//
//        val maxLeft = maxPathSumWithoutBranching(root.left, sum + root.`val`)
//        val maxRight = maxPathSumWithoutBranching(root.right, sum + root.`val`)
//        val maxSumFromChildren = Math.max(maxLeft, maxRight)
//        return Math.max(sum, maxSumFromChildren)
//    }

//===================================================================================

    //for some reason this listOf().max!! approach is VASTLY SLOWER
//    fun maxPathSum(root: TreeNode?): Int {
//        if (root == null) return Integer.MIN_VALUE
//
//        return listOf(
//            maxPathSum(root.left),
//            maxPathSum(root.right),
//            root.`val` + maxPathSumWithoutBranching(root.left, 0) + maxPathSumWithoutBranching(root.right, 0)
//        ).max()!!
//    }
//
//    private fun maxPathSumWithoutBranching(root: TreeNode?, sum: Int): Int {
//        if (root == null) return sum
//
//        return listOf(
//            sum,
//            maxPathSumWithoutBranching(root.left, sum + root.`val`),    // Max from left
//            maxPathSumWithoutBranching(root.right, sum + root.`val`)    // Max from right
//        ).max()!!
//    }





}