package alex.com.challenges

import java.util.*

class BinaryTreeMaxPath {
    private class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        // This node is worthless if theres no children (paths)
        // If child exists, there is a path from here to there
        fun getValueOfThisNode(): Int? {

            if (left == null && right == null) {
                return 0
            }

            // The max value of this node is the maximum possibility of
            // A) the childs best path
            val leftValue: Int? = left?.getValueOfThisNode()
            val rightValue: Int? = right?.getValueOfThisNode()

            // B) The childs best path + this
            val leftValueIncludingThis: Int? =
                if (left != null) {
                    leftValue!! + value
                } else {
                    null
                }
            val rightValueIncludingThis: Int? =
                if (right != null) {
                    rightValue!! + value
                } else {
                    null
                }

            // C) B for both childs
            val bothValuesIncludingThis: Int? =
                if (leftValueIncludingThis != null && rightValueIncludingThis != null) {
                    leftValueIncludingThis + rightValueIncludingThis - value
                } else null


            val options = arrayOf(
                leftValue,
                leftValueIncludingThis,
                rightValue,
                rightValueIncludingThis,
                bothValuesIncludingThis
            )
            val thisNodesMaxPath = options.mapNotNull { it }.max()
            return thisNodesMaxPath
        }


        fun getMaxPathValueOfThisNode(): Int? {
            
            //PROBLEM: Path is being added twice. When doing the inclusive path
            // SOLUTION : Do not add both child & this values. PICK ONE

            // ONLY children path (Used to exclude this node but propagate child path)
            val leftPath: Int? = left?.getMaxPathValueOfThisNode()
            val rightPath: Int? = right?.getMaxPathValueOfThisNode()

            // (Child path (or 0) + child value) + this  (Used to include this node & propagate child path)
            // If child has null path then
            val leftPathInclusive: Int? = if (left == null) null else (leftPath ?: 0) + left!!.value
            val rightPathInclusive: Int? = if (right == null) null else (rightPath?: 0) + right!!.value

            // Loop back (subtract value to not double account)
            val bothPathInclusive: Int? = if (leftPathInclusive != null && rightPathInclusive != null) leftPathInclusive + rightPathInclusive else null


            val options = arrayOf(
                leftPath,
                leftPathInclusive,
                rightPath,
                rightPathInclusive,
                bothPathInclusive
            )
            val thisNodesMaxPath =  options.mapNotNull { it }.max()
            return thisNodesMaxPath
        }

    }

    companion object {
        fun solve(inputs: Array<Int?>): Int {

            if (inputs.isEmpty() || inputs[0] == null) {
                return 0
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

//                println("Iteration: $iteration. Parent: ${parent.value}. LeftInput: ${leftInput}. RightInput: ${rightInput}")

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

//            println("==DONE BUILDING==")
//            debugPrint(firstNode)

            return maxPathSum(firstNode)
        }

        private fun maxPathSum(root: TreeNode?): Int {
            return root?.getValueOfThisNode() ?: 0
        }

        private fun debugPrint(root: TreeNode?) {

            if (root == null) {
                println("No root!")
            }

            //get initial, put in queue
            //-----
            //print queue, build next queue
            var nodes = ArrayList<TreeNode>()
            nodes.add(root!!)

            while (nodes.isNotEmpty()) {
                val newList = ArrayList<TreeNode>()
                for (node in nodes) {
                    print(
                        node.value.toString() + " -> (${node.left?.value
                            ?: "null"}, ${node.right?.value ?: "null"})"
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
}

/// Infinite chain
