package alex.com.challenges

import java.util.*

class BinaryTreeMaxPath {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        fun debugPrintToConsole() {

            var nodes = ArrayList<TreeNode>()
            nodes.add(this)

            while (nodes.isNotEmpty()) {
                val newList = ArrayList<TreeNode>()
                for (node in nodes) {
                    print(
                        node.`val`.toString() + " -> (${node.left?.`val`
                            ?: "null"}, ${node.right?.`val` ?: "null"})"
                    )
                    node.left?.let {
                        newList.add(it)
                    }
                    node.right?.let {
                        newList.add(it)
                    }
                }
                println("")
                println("----")
                nodes = newList
            }
        }
    }

    companion object {

        private val PRINT_DEBUG = false

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

        fun buildTree(inputs: Array<Int?>): TreeNode? {

            if (inputs.isEmpty() || inputs[0] == null) {
                return null
            }
            val inputQueue = inputs.toMutableList()

            // Build build first node
            val nodes = ArrayDeque<TreeNode>()
            val firstNode = TreeNode(inputQueue.removeAt(0)!!)
            nodes.add(firstNode)

            // Iterate and build child nodes
            var iteration = 1
            while (inputQueue.isNotEmpty() && nodes.isNotEmpty()) {
                val leftInput = inputQueue.removeAt(0)
                val rightInput = if (inputQueue.isNotEmpty()) inputQueue.removeAt(0) else null
                val parent = nodes.pop()

                printDebug("Iteration: $iteration. Parent: ${parent.`val`}. LeftInput: ${leftInput}. RightInput: ${rightInput}")

                leftInput?.let {
                    val newNode = TreeNode(it)
                    parent.left = newNode
                    nodes.addLast(newNode)
                }
                rightInput?.let {
                    val newNode = TreeNode(it)
                    parent.right = newNode
                    nodes.addLast(newNode)
                }
                iteration += 1
            }

            printDebug("==DONE BUILDING==")
            if (PRINT_DEBUG) {
                firstNode.debugPrintToConsole()
            }

            return firstNode
        }

        fun printDebug(string: String) {
            if (PRINT_DEBUG) {
                println(string)
            }
        }
    }
}
