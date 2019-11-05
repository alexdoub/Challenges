package alex.com.challenges

import java.util.*

class BinaryTreeMaxSimplePath {
    open class TreeNode(var `val`: Int) {
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

    class TreeNodeWithId(val id: Int, value: Int):TreeNode(value)

    //REDO this with top down approach. Parent passes value down, gets returned max possible value

    companion object {

        private val PRINT_DEBUG = false

        fun maxPathSum(root: TreeNode?): Int {
            return root?.getMaxValueOfThisNode(0, true, false) ?: 0
        }

        private fun TreeNode.getMaxValueOfThisNode(
            chainValue: Int,
            includeOrphans: Boolean,
            alreadyBranched: Boolean
        ): Int {

            val onlyThis = `val` + chainValue

            // ONLY child paths (Used to exclude this node but propagate child path)
            val leftOrphanPath: Int? = left?.getMaxValueOfThisNode(0, true, alreadyBranched)
            val rightOrphanPath: Int? = right?.getMaxValueOfThisNode(0, true, alreadyBranched)

            // Child path + THIS
            val leftPathInclusive: Int? = left?.getMaxValueOfThisNode(onlyThis, false, true)
            val rightPathInclusive: Int? = right?.getMaxValueOfThisNode(onlyThis, false, true)

            val options = arrayOf(
                onlyThis,
                leftPathInclusive,
                rightPathInclusive
            ).toMutableList()

            // Both child paths + this (subtract `val` to not double account)
            // Ignore if we already branched
            var bothPathsInclusive: Int? = null
            if (!alreadyBranched) {
                val leftPathInclusiveBranched: Int? = left?.getMaxValueOfThisNode(onlyThis, false, true)
                val rightPathInclusiveBranched: Int? = right?.getMaxValueOfThisNode(onlyThis, false, true)

                bothPathsInclusive =
                    if (leftPathInclusiveBranched != null && rightPathInclusiveBranched != null) {
                        leftPathInclusiveBranched + rightPathInclusiveBranched - onlyThis
                    } else null
                options.add(bothPathsInclusive)
            }
            if (includeOrphans) {
                options.add(leftOrphanPath)
                options.add(rightOrphanPath)
            }
            val maxValue = options.mapNotNull { it }.max()!!
            if ((this as TreeNodeWithId).id == 2) {
                return maxValue
                //1's LPI is somehow 5
            }
            return maxValue
        }

        fun buildTree(inputs: Array<Int?>): TreeNodeWithId? {

            if (inputs.isEmpty() || inputs[0] == null) {
                return null
            }
            val inputQueue = inputs.toMutableList()

            // Build build first node
            var idCounter = 1
            val nodes = ArrayDeque<TreeNodeWithId>()
            val firstNode = TreeNodeWithId(idCounter, inputQueue.removeAt(0)!!)
            nodes.add(firstNode)
            idCounter += 1

            // Iterate and build child nodes
            var iteration = 1
            while (inputQueue.isNotEmpty() && nodes.isNotEmpty()) {
                val leftInput = inputQueue.removeAt(0)
                val rightInput = if (inputQueue.isNotEmpty()) inputQueue.removeAt(0) else null
                val parent = nodes.pop()

                printDebug("Iteration: $iteration. Parent: ${parent.`val`}. LeftInput: ${leftInput}. RightInput: ${rightInput}")

                leftInput?.let {
                    val newNode = TreeNodeWithId(idCounter, it)
                    parent.left = newNode
                    nodes.addLast(newNode)
                    idCounter += 1
                }
                rightInput?.let {
                    val newNode = TreeNodeWithId(idCounter, it)
                    parent.right = newNode
                    nodes.addLast(newNode)
                    idCounter += 1
                }
                iteration += 1
            }

            printDebug("==DONE BUILDING==")
            if (PRINT_DEBUG) {
                firstNode.debugPrintToConsole()
            }

            return firstNode
        }

        private fun printDebug(string: String) {
            if (PRINT_DEBUG) {
                println(string)
            }
        }
    }
}
