package alex.com.challenges

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

        var paths = 0
        if (targetSum - root.`val` == 0) paths++    // We have reached a target sum through a continuation

        paths += pathSumInclusive(root.left, targetSum - root.`val`)
        paths += pathSumInclusive(root.right, targetSum - root.`val`)
        return paths
    }
}
