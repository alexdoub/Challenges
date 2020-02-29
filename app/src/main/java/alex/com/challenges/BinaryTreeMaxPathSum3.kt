package alex.com.challenges

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 2/29/2020.
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

object BinaryTreeMaxPathSum3 {
    fun maxPathSum(root: TreeNode?): Int {
        return maxPathSumWithBranching(root)
    }
    fun maxPathSumWithBranching(root: TreeNode?): Int {
        if (root == null) return Integer.MIN_VALUE

        val notIncludingRoot = Math.max(maxPathSumWithBranching(root.left), maxPathSumWithBranching(root.right))
        val includingRoot = root.`val` + maxPathSumWithoutBranching(root.left, 0) + maxPathSumWithoutBranching(root.right, 0)
//        println("Node: ${root.`val`} -- maxPathSumWithBranching has values $notIncludingRoot, $includingRoot")
        return Math.max(includingRoot, notIncludingRoot)
    }

    private fun maxPathSumWithoutBranching(root: TreeNode?, sum: Int): Int {
        if (root == null) return Math.max(0, sum)

        val maxLeft = maxPathSumWithoutBranching(root.left, sum + root.`val`)
        val maxRight = maxPathSumWithoutBranching(root.right, sum + root.`val`)
        val maxSumFromChildren = Math.max(maxLeft, maxRight)
//        println("Node: ${root.`val`} -- maxPathSumWithoutBranching has values $sum, $maxLeft, $maxRight")
        return Math.max(sum, maxSumFromChildren)
    }
}