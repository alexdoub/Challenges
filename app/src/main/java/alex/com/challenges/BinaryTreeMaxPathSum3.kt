package alex.com.challenges

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 2/29/2020.
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

object BinaryTreeMaxPathSum3 {
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) return Integer.MIN_VALUE

        val throughRoot = root.`val` + dfs(root.left, 0) + dfs(root.right, 0)
        val notThroughRoot = Math.max(maxPathSum(root.left), maxPathSum(root.right))
        return Math.max(throughRoot, notThroughRoot)
    }

    private fun dfs(root: TreeNode?, sum: Int): Int {
        if (root == null) return Math.max(0, sum);
        val maxSumFromChildren = Math.max(dfs(root.left, sum + root.`val`), dfs(root.right, sum + root.`val`))
        return Math.max(sum, maxSumFromChildren);
    }
}