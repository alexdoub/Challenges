package alex.com.challenges

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 3/1/2020.
 * https://leetcode.com/problems/path-sum-ii/
 */

object BinaryTreePathSumII {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        fun getPathSum(root: TreeNode?, sumLeft: Int, pathTraversed: List<Int>): List<List<Int>> {
            if (root == null) {
                return emptyList()
            }

            if (root.left == null && root.right == null && sumLeft == root.`val`) {
                return listOf(pathTraversed + root.`val`)
            }

            val newPathTraversed = pathTraversed + root.`val`
            val sumLeft = sumLeft - root.`val`
            return getPathSum(root.left, sumLeft, newPathTraversed) + getPathSum(root.right, sumLeft, newPathTraversed)
        }
        return getPathSum(root, sum, emptyList())
    }
}