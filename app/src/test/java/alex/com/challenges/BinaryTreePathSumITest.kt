package alex.com.challenges

import alex.com.challenges.common.TreeNode.Companion.buildTree
import alex.com.challenges.graph.BinaryTreePathSumI
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 2/29/2020.
 */

class BinaryTreePathSumITest {
    @Test
    fun test_empty() {
        val tree = buildTree(arrayOf())
        assertEquals(false, BinaryTreePathSumI.hasPathSum(tree, 0))
    }

    @Test
    fun test_single() {
        val tree = buildTree(arrayOf(5))
        assertEquals(true, BinaryTreePathSumI.hasPathSum(tree, 5))
    }

    @Test
    fun unbalanced_2_layers_1() {
        val tree = buildTree(arrayOf(1,2))
        val target = 1
        assertEquals(false, BinaryTreePathSumI.hasPathSum(tree, target))
    }

    @Test
    fun unbalanced_2_layers_2() {
        val tree = buildTree(arrayOf(1,2))
        val target = 3
        assertEquals(true, BinaryTreePathSumI.hasPathSum(tree, target))
    }

    @Test
    fun balanced_3_layers() {
        val tree = buildTree(arrayOf(1,2,3,4,5,6,7))
        val target = 11
        assertEquals(true, BinaryTreePathSumI.hasPathSum(tree, target))
    }

    @Test
    fun unbalanced_4_layers() {
        val tree = buildTree(arrayOf(5,4,8,11,null,13,4,7,2,null,null,null,1))
        val target = 22
        assertEquals(true, BinaryTreePathSumI.hasPathSum(tree, target))
    }
}