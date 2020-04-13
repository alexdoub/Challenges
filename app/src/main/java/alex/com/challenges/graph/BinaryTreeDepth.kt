package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 4/12/2020.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

object BinaryTreeDepth {
    fun maxDepth(root: TreeNode?): Int {

        fun check(node: TreeNode?, count: Int): Int {
            if (node == null) return count

            val newCount = count+1
            val left = check(node.left, newCount)
            val right = check(node.right, newCount)
            return Math.max(left, right)
        }
        return check(root, 0)
    }
}