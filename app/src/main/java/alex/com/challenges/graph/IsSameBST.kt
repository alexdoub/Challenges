package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 3/31/2020.
 * https://leetcode.com/problems/same-tree/
 */

object IsSameBST {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return if (p == null && q == null) true
        else if (p?.`val` == q?.`val`) {
            isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        } else false
    }
}