package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryTreeMaxPathTest {
    @Test
    fun test1() {
        assertEquals(6, BinaryTreeMaxPath.solve(arrayOf(1, 2, 3)))
    }

    @Test
    fun test2() {
        //    -10
        //   9,  20
        // n, n, 15, 7

        assertEquals(42, BinaryTreeMaxPath.solve(arrayOf(-10, 9, 20, null, null, 15, 7)))
    }

    @Test
    fun test3_homemade() {
        //    -1000
        //   -11 -12
        // 100 -13 -14
        // Should equal 90?
        val values = arrayOf(-1000, -11, -12, 100, -13, -14, null)
        assertEquals(90, BinaryTreeMaxPath.solve(values))
    }

    @Test
    fun test4_homemade() {
        //   1
        //  2, n
        // 3, n
        //4, n
        val values = arrayOf(1, 2, null, 3, null, 4, null)
        assertEquals(10, BinaryTreeMaxPath.solve(values))
    }
}