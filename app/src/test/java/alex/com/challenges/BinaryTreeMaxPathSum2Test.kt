package alex.com.challenges

import alex.com.challenges.common.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class BinaryTreeMaxPathSum2Test {

    private val PRINT_DEBUG = false
    private fun buildTree(inputs: Array<Int?>): TreeNode? {

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

            printDebug("Iteration: $iteration. Parent: ${parent.`val`}. LeftInput: ${leftInput}. RightInput: $rightInput")

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

    @Test
    fun test1() {
        //  1
        // 2, 3
        val tree: Array<Int?> = arrayOf(1, 2, 3)
        val head = buildTree(tree)
        assertEquals(6, BinaryTreeMaxPathSum2.maxPathSum(head))
    }

    @Test
    fun test2() {
        //    -10
        //   9,  20
        // n, n, 15, 7
        val tree: Array<Int?> = arrayOf(-10, 9, 20, null, null, 15, 7)
        val head = buildTree(tree)
        assertEquals(42, BinaryTreeMaxPathSum2.maxPathSum(head))
    }

    @Test
    fun test3_homemade() {
        //    -1000
        //   -11 -12
        // 100 -13 -14
        // Should equal 89
        val tree: Array<Int?> = arrayOf(-1000, -11, -12, 100, -13, -14, null)
        val head = buildTree(tree)
        assertEquals(89, BinaryTreeMaxPathSum2.maxPathSum(head))
    }

    @Test
    fun test4_homemade() {
        //   1
        //  2, n
        // 3, n
        //4, n
        val tree: Array<Int?> = arrayOf(1, 2, null, 3, null, 4, null)
        val head = buildTree(tree)
        assertEquals(10, BinaryTreeMaxPathSum2.maxPathSum(head))
    }

    @Test
    fun test5_homemade() {
        //     1
        //    2, n
        //   3, n
        //  4, n
        //-1, n
        val tree: Array<Int?> = arrayOf(1, 2, null, 3, null, 4, null, -1, null)
        val head = buildTree(tree)
        assertEquals(10, BinaryTreeMaxPathSum2.maxPathSum(head))
    }

    @Test
    fun test6_homemade() {
        //     1
        //    2, n
        //   3, n
        //  4, n
        //-1, n
        //2, n
        val tree: Array<Int?> = arrayOf(1, 2, null, 3, null, 4, null, -1, null, 2, null)
        val head = buildTree(tree)
        assertEquals(11, BinaryTreeMaxPathSum2.maxPathSum(head))
    }
}