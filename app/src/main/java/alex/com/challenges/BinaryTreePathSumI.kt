package alex.com.challenges

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 2/29/2020.
 * https://leetcode.com/problems/path-sum/
 */

object BinaryTreePathSumI {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }

        if (root.left == null && root.right == null && sum == root.`val`) {
            return true
        }

        return hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)
    }
}