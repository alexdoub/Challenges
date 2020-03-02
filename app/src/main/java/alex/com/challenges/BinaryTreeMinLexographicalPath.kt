package alex.com.challenges

import alex.com.challenges.common.TreeNode

/**
 * Created by Alex Doub on 3/1/2020.
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 */

object BinaryTreeMinLexographicalPath {
    fun smallestFromLeaf(root: TreeNode?): String {
        if (root == null) return ""

        fun getValidPaths(root: TreeNode, path: List<Int>): List<List<Int>> {
            val newPathTraversed = listOf(root.`val`) + path    //Note: Reversed. Leaf in front

            // Base case - leaf
            if (root.left == null && root.right == null) {
                return listOf(newPathTraversed)
            }

            // Accumulate sub paths
            val paths = ArrayList<List<Int>>()
            root.left?.let { left ->
                paths.addAll(getValidPaths(left, newPathTraversed))
            }
            root.right?.let { right ->
                paths.addAll(getValidPaths(right, newPathTraversed))
            }
            return paths
        }

        val allPaths = getValidPaths(root, emptyList())
        val bestPath = getBestPath(allPaths)
        return getStringFromPath(bestPath)
    }

    private fun getBestPath(paths: List<List<Int>>): List<Int> {
        val options = paths.toMutableList()

        var index = 0
        while (options.size > 1) {
            // Get the best single value for this index. Ascending, null first
            val bestValue = options.map {
                if (it.size == index) null else it[index]
            }.sortedWith(Comparator { o1, o2 ->
                (o1 ?: -1) - (o2 ?: -1)
            }).first()

            //Filter options list
            //remove if not null at that index && its value is not our best value
            options.removeIf {
                index < it.size && it[index] != bestValue
            }

            // Edge case, all options are identical and we rolled past checking
            if (options.all { index >= it.size }) {
                return options.first()
            }

            index++
        }
        return options.first()
    }

    private fun getStringFromPath(path: List<Int>): String {
        return path.joinToString(
            separator = "",
            transform = {
                ('a'.toInt() + it).toChar() + ""
            })
    }
}