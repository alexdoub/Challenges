package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 3/26/2020.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

object FindKthSmallestElementInBST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {

        class Holder(var count: Int = 0)

        // DFS search with a holder for count. So every stage can increment
        // Return a solution if we find it
        fun dfs(holder: Holder, node: TreeNode?): Int? {
            val node = node ?: return null

            //check left
            val left = dfs(holder, node.left)
            if (left != null) return left

            // Increment and check
            // this happens after we check left because it means there are no values smaller than this
            holder.count += 1
            if (holder.count == k) return node.`val`

            // check right
            return dfs(holder, node.right)
        }

        return dfs(Holder(), root) ?: -1
    }
}