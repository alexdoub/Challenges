package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 1/7/2020.
 * https://leetcode.com/problems/invert-binary-tree/
 */

class InvertBinaryTree {
    companion object {
        fun invertTree(root: TreeNode?): TreeNode? {
            fun invertChildren(node: TreeNode?) {
                if (node == null) return

                val temp = node.left
                node.left = node.right
                node.right = temp
                invertChildren(node.left)
                invertChildren(node.right)
            }
            invertChildren(root)
            return root
        }
    }
}