package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode


//https://leetcode.com/problems/binary-tree-maximum-path-sum/

@Deprecated("USE #3")
object BinaryTreeMaxPathSum2 {

    fun maxPathSum(root: TreeNode?): Int {
        return root?.getMaxValueOfThisNode(false) ?: 0
    }

    private fun TreeNode.getMaxValueOfThisNode(cameFromSomewhere: Boolean): Int? {

        // Base case, reached a leaf. Only has `val` if it came from somewhere
        if (left == null && right == null) {
            return if (cameFromSomewhere) {
                `val`
            } else {
                null
            }
        }

        // Must include pruning off this node
        val prunedPath = if (cameFromSomewhere) `val` else null

        // ONLY child paths (Used to exclude this node but propagate child path)
        val leftPath: Int? = left?.getMaxValueOfThisNode(false)
        val rightPath: Int? = right?.getMaxValueOfThisNode(false)

        // Child path + THIS
        val leftPathInclusive: Int? = left?.getMaxValueOfThisNode(true)?.let { it + `val` }
        val rightPathInclusive: Int? = right?.getMaxValueOfThisNode(true)?.let { it + `val` }

        // Both child paths + this (subtract `val` to not double account)
        val bothPathInclusive: Int? =
            if (leftPathInclusive != null && rightPathInclusive != null) {
                leftPathInclusive + rightPathInclusive - `val`
            } else null

        val options = arrayOf(
            prunedPath,
            leftPath,
            leftPathInclusive,
            rightPath,
            rightPathInclusive,
            bothPathInclusive
        )
        return options.mapNotNull { it }.max()
    }
}
