package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryTreeMaxPathSumTest {
    @Test
    fun test1() {
        //  1
        // 2, 3
        val tree: Array<Int?> = arrayOf(1, 2, 3)
        val head = BinaryTreeMaxPathSum.buildTree(tree)
        assertEquals(6, BinaryTreeMaxPathSum.maxPathSum(head))
    }

    @Test
    fun test2() {
        //    -10
        //   9,  20
        // n, n, 15, 7
        val tree: Array<Int?> = arrayOf(-10, 9, 20, null, null, 15, 7)
        val head = BinaryTreeMaxPathSum.buildTree(tree)
        assertEquals(42, BinaryTreeMaxPathSum.maxPathSum(head))
    }

    @Test
    fun test3_homemade() {
        //    -1000
        //   -11 -12
        // 100 -13 -14
        // Should equal 89
        val tree: Array<Int?> = arrayOf(-1000, -11, -12, 100, -13, -14, null)
        val head = BinaryTreeMaxPathSum.buildTree(tree)
        assertEquals(89, BinaryTreeMaxPathSum.maxPathSum(head))
    }

    @Test
    fun test4_homemade() {
        //   1
        //  2, n
        // 3, n
        //4, n
        val tree: Array<Int?> = arrayOf(1, 2, null, 3, null, 4, null)
        val head = BinaryTreeMaxPathSum.buildTree(tree)
        assertEquals(10, BinaryTreeMaxPathSum.maxPathSum(head))
    }

    @Test
    fun test5_homemade() {
        //     1
        //    2, n
        //   3, n
        //  4, n
        //-1, n
        val tree: Array<Int?> = arrayOf(1, 2, null, 3, null, 4, null, -1, null)
        val head = BinaryTreeMaxPathSum.buildTree(tree)
        assertEquals(10, BinaryTreeMaxPathSum.maxPathSum(head))
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
        val head = BinaryTreeMaxPathSum.buildTree(tree)
        assertEquals(11, BinaryTreeMaxPathSum.maxPathSum(head))
    }
}