package alex.com.challenges

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 3/1/2020.
 * https://leetcode.com/problems/binary-tree-paths/
 */

object BinaryTreeAllPaths {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        fun getPaths(root: TreeNode?, pathTraversed: String): List<String> {
            if (root == null) return emptyList()

            if (root.left == null && root.right == null) {
                return listOf(pathTraversed + root.`val`)
            }

            val newPathTraversed = pathTraversed + "${root.`val`}->"
            return getPaths(root.left, newPathTraversed) + getPaths(root.right, newPathTraversed)
        }
        return getPaths(root, "")
    }
}