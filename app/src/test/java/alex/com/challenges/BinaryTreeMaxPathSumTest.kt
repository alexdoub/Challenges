package alex.com.challenges

import alex.com.challenges.common.TreeNode.Companion.buildTree
import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryTreeMaxPathSumTest {

    private val PRINT_DEBUG = false

    private fun printDebug(string: String) {
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
        assertEquals(6, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    @Test
    fun test2() {
        //    -10
        //   9,  20
        // n, n, 15, 7
        val tree: Array<Int?> = arrayOf(-10, 9, 20, null, null, 15, 7)
        val head = buildTree(tree)
        assertEquals(42, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    @Test
    fun test3_homemade() {
        //    -1000
        //   -11 -12
        // 100 -13 -14
        // Should equal 89
        val tree: Array<Int?> = arrayOf(-1000, -11, -12, 100, -13, -14, null)
        val head = buildTree(tree)
        assertEquals(100, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    @Test
    fun test3_homemade_SIMPLE() {
        //    -1000
        //   -11 n
        // 100 -13 n
        // Should equal 89
        val tree: Array<Int?> = arrayOf(-1000, -11, -12, 100, -13, null, null)
        val head = buildTree(tree)
        assertEquals(100, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    @Test
    fun test4_homemade() {
        //   1
        //  2, n
        // 3, n
        //4, n
        val tree: Array<Int?> = arrayOf(1, 2, null, 3, null, 4, null)
        val head = buildTree(tree)
        assertEquals(10, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
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
        assertEquals(10, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    @Test
    fun test6_homemade() {
        //     1
        //    2, n
        //   3, n
        //  4, n
        //-9, n
        //10, n
        val tree: Array<Int?> = arrayOf(1, 2, null, 3, null, 4, null, -1, null, 2, null)
        val head = buildTree(tree)
        assertEquals(11, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    @Test
    fun test7_homemade() {
        //     1
        val tree: Array<Int?> = arrayOf(1)
        val head = buildTree(tree)
        assertEquals(1, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    // NOTE: This requires only a single branch! Cannot branch twice
    @Test
    fun test8() {
        //     5
        //    4, 8
        //  11,n,13,4
        //7,2         1
        //NOTE: Spreads wide, skips 2, 4 and 1
        val tree: Array<Int?> = arrayOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        val head = buildTree(tree)
        assertEquals(48, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    //Left half gets 2, right half gets 1, + top
    @Test
    fun test9() {
        //        1
        //   0,         1
        //  1, 2,     0, -1
        // 0,1,-1,0, -1,0,1,0
        val tree: Array<Int?> = arrayOf(1, 0, 1, 1, 2, 0, -1, 0, 1, -1, 0, -1, 0, 1, 0)
        val head = buildTree(tree)
        assertEquals(4, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

    @Test
    fun test9_SIMPLIFIED() {
        //        10
        //   0,         3
        //  1, 2,     0, -1
        // 0,1,-1,0, -1,0,1,0
        val tree: Array<Int?> = arrayOf(10, 0, 3, 1, 2, 0, -1, 0, 1, -1, 0, -1, 0, 1, 0)
        val head = buildTree(tree)
        assertEquals(15, BinaryTreeMaxPathSum3.maxPathSumWithBranching(head))
    }

}