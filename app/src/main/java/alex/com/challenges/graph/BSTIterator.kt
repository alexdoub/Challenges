package alex.com.challenges.graph

import alex.com.challenges.common.TreeNode
import java.util.*

/**
 * Created by Alex Doub on 3/28/2020.
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */

// Push full left - init
// get - pop, PFL on right
class BSTIterator(root: TreeNode?) {
    val stack = Stack<TreeNode>()

    init {
        pushLeftPath(root)
    }

    fun next(): Int {
        // The top of the stack always has the lowest element
        // After that, the next value is the left-most path from the right side
        val node = stack.pop()
        pushLeftPath(node.right)
        return node.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

    // The smallest element from this node is the left-most path
    // Create a stack all the way down
    fun pushLeftPath(node: TreeNode?) {
        var n = node
        while (n != null) {
            stack.push(n)
            n = n.left
        }
    }
}
