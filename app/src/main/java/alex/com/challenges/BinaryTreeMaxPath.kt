package alex.com.challenges

import java.util.*

class BinaryTreeMaxPath {
    private class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        //@@TODO: What do differently
        // Keep paths and values separate
        // Recursively calculate instead of top-down catch-all

        fun getMaxPathValueOfThisNode(): Int {
            return this.getMaxValueOfThisNode() ?: 0
        }

        fun getRecursiveMaxPathValueOfThisNode(): Int {
            //recusively call getValue and return max
            val options = ArrayList<TreeNode>()
            options.add(this)

            var maxPathValue = 0

            while (options.isNotEmpty()) {
                val node = options.removeAt(0)
                node.left?.let { options.add(it) }
                node.right?.let { options.add(it) }

                val nodeValue = node.getMaxValueOfThisNode()
                if (nodeValue != null && nodeValue > maxPathValue) {
                    maxPathValue = nodeValue
                }
            }
            return maxPathValue
        }

//        //CASES
//        //-Orphan node
//        //-has children
//        //-has extended children
//
//        // Nodes only have value if they have a parent
//        // Return the value of this node, with or without the parent
//        fun getMaxValueOfThisNode(): Int? {
//
//
//            //left only
//            val leftOnlyValue = left?.getMaxValueOfThisNode()?.let { it }
//
//            //left + this
//            val leftInclusiveValue = left?.value
//            //left + this + parent
//
//
//            // If theres no children, return none
//            if (left == null && right == null) return null
//
//            // If it has children, get their value
//
//
//            // B) The childs best path + this
//            val leftValueIncludingThis: Int? = left?.value?.let { it + value } ?: null
//            val rightValueIncludingThis: Int? = right?.value?.let { it + value } ?: null
//
//            // C) B for both childs
//            val bothValuesIncludingThis: Int? =
//                if (leftValueIncludingThis != null && rightValueIncludingThis != null) {
//                    leftValueIncludingThis + rightValueIncludingThis - value
//                } else null
//
//
//            val options = arrayOf(
//                leftValueIncludingThis,
//                rightValueIncludingThis,
//                bothValuesIncludingThis
//            )
//            val thisNodesMaxPath = options.mapNotNull { it }.max()
//            return thisNodesMaxPath
//        }

//
        fun getMaxValueOfThisNode(): Int? {

            if (left == null && right == null) {
                return value
            }

            // ONLY children path (Used to exclude this node but propagate child path)
            val leftPath: Int? = left?.getMaxValueOfThisNode()
            val rightPath: Int? = right?.getMaxValueOfThisNode()

            // (Child path (or 0) + child value) + this  (Used to include this node & propagate child path)
            // If child has null path then
            val leftPathInclusive: Int? = leftPath?.let { it + value }
            val rightPathInclusive: Int? = rightPath?.let { it + value }

            // Loop back (subtract value to not double account)
            val bothPathInclusive: Int? = if (leftPathInclusive != null && rightPathInclusive != null) leftPathInclusive + rightPathInclusive - value else null

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

        private fun maxPathSum(root: TreeNode): Int {
            return root.getMaxPathValueOfThisNode()
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
