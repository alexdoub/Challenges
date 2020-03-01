package alex.com.challenges.common

import java.util.*
import kotlin.collections.ArrayList

class TreeNodePath(val pathString: String, val sum: Int)

open class TreeNode(val id: Int, var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun debugPrintToConsole() {

        var nodes = ArrayList<TreeNode>()
        nodes.add(this)

        while (nodes.isNotEmpty()) {
            val newList = ArrayList<TreeNode>()
            for (node in nodes) {
                print(node.`val`.toString() + " -> (${node.left?.`val` ?: "null"}, ${node.right?.`val` ?: "null"})")
                node.left?.let {
                    newList.add(it)
                }
                node.right?.let {
                    newList.add(it)
                }
                println("")
            }
            println("----")
            nodes = newList
        }
    }

    companion object {
        fun buildTree(inputs: Array<Int?>): TreeNode? {

            if (inputs.isEmpty() || inputs[0] == null) {
                return null
            }
            val inputQueue = inputs.toMutableList()

            // Build build first node
            val nodes = ArrayDeque<TreeNode>()
            var idCounter = 0
            val firstNode = TreeNode(idCounter, inputQueue.removeAt(0)!!)
            idCounter++
            nodes.add(firstNode)

            // Iterate and build child nodes
            while (inputQueue.isNotEmpty() && nodes.isNotEmpty()) {
                val leftInput = inputQueue.removeAt(0)
                val rightInput = if (inputQueue.isNotEmpty()) inputQueue.removeAt(0) else null
                val parent = nodes.pop()

                leftInput?.let {
                    val newNode = TreeNode(idCounter, leftInput)
                    idCounter++
                    parent.left = newNode
                    nodes.addLast(newNode)
                }
                rightInput?.let {
                    val newNode = TreeNode(idCounter, rightInput)
                    idCounter++
                    parent.right = newNode
                    nodes.addLast(newNode)
                }
            }

            return firstNode
        }
    }
}