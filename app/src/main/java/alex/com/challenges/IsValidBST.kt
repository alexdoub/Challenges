package alex.com.challenges

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 1/31/2020.
 * https://leetcode.com/problems/validate-binary-search-tree/
 */

class IsValidBST {
    companion object {
        fun isValidBST(root: TreeNode?): Boolean {

            fun isValid(root: TreeNode?, greaterThan: Int?, lessThan: Int?): Boolean {
                if (root == null) return true

                if (lessThan != null && root.`val` >= lessThan) return false
                if (greaterThan != null && root.`val` <= greaterThan) return false

                return isValid(root.left, greaterThan, Math.min(lessThan ?: root.`val`, root.`val`))
                        && isValid(root.right, Math.max(root.`val`, greaterThan ?: root.`val`), lessThan)
            }

            return isValid(root, null, null)
        }
    }
}

