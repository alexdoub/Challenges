package alex.com.challenges

import alex.com.challenges.common.TreeNode.Companion.buildTree
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 2/29/2020.
 */

class BinaryTreePathSumIIITest {
    @Test
    fun test_full_empty_4() {
        val tree = buildTree(arrayOf(0,0,0,0))
        val target = 0
        val expected = 8
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test_full_empty_5() {
        val tree = buildTree(arrayOf(0,0,0,0,0))
        val target = 0
        val expected = 11
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test_full_empty_6() {
        val tree = buildTree(arrayOf(0,0,0,0,0,0))
        val target = 0
        val expected = 14
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test_full_empty_20() {
        val tree = buildTree(arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
        val target = 0
        val expected = 74
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test1() {
        val tree = buildTree(arrayOf(1))
        val target = 1
        val expected = 1
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test2a() {
        val tree = buildTree(arrayOf(1, 1))
        val target = 1
        val expected = 2
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test2b() {
        val tree = buildTree(arrayOf(1, 1))
        val target = 2
        val expected = 1
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test3a() {
        val tree = buildTree(arrayOf(1, 1, 1))
        val target = 1
        val expected = 3
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test3b() {
        val tree = buildTree(arrayOf(1, 1, 1))
        val target = 2
        val expected = 2
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test4a() {
        val tree = buildTree(arrayOf(1, 1, 1, 1))
        val target = 1
        val expected = 4
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test4b() {
        val tree = buildTree(arrayOf(1, 1, 1, 1))
        val target = 2
        val expected = 3
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    @Test
    fun test4c() {
        val tree = buildTree(arrayOf(1, 1, 1, 1))
        val target = 3
        val expected = 1
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

    //Obstacle
    @Test
    fun test9_unbalanced() {
        val tree = buildTree(arrayOf(10,5,-3,3,2,null,11,3,-2,null,1))
        val target = 8
        val expected = 3
        assertEquals(expected, BinaryTreePathSumIII.pathSum(tree, target))
    }

}