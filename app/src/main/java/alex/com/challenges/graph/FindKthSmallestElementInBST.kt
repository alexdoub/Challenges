package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 3/26/2020.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

object FindKthSmallestElementInBST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {

        // Return a solution if we find it
        var count = 0
        fun dfs(node: TreeNode?): Int? {
            val node = node ?: return null

            //check left
            val left = dfs(node.left)
            if (left != null) return left

            // Increment and check
            // this happens after we check left because it means there are no values smaller than this
            if (++count == k) return node.`val`

            // check right
            return dfs(node.right)
        }

        return dfs(root) ?: -1
    }
}