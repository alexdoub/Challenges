package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 2/29/2020.
 * https://leetcode.com/problems/path-sum-iii/
 */

object BinaryTreePathSumIII {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) return 0

        var paths = 0
        paths += pathSum(root.left, targetSum)
        paths += pathSum(root.right, targetSum)
        paths += pathSumInclusive(root, targetSum)
        return paths
    }

    fun pathSumInclusive(root: TreeNode?, targetSum: Int): Int {
        if (root == null) return 0

        var paths = if (targetSum - root.`val` == 0) 1 else 0
        paths += pathSumInclusive(root.left, targetSum - root.`val`)
        paths += pathSumInclusive(root.right, targetSum - root.`val`)
        return paths
    }
}
