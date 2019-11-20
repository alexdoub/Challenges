package alex.com.challenges

import alex.com.challenges.dynamic.MinFallingPathSum
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 11/19/2019.
 */

class MinFallingPathSumTest {
    @Test
    fun test1() {
        val values = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(12, MinFallingPathSum.minFallingPathSum(values))
    }

    @Test
    fun test2() {
        val values = arrayOf<IntArray>()
        assertEquals(0, MinFallingPathSum.minFallingPathSum(values))
    }

    @Test
    fun test3() {
        val values = arrayOf(
            intArrayOf(3, 4, 5),
            intArrayOf(4, 50, 50),
            intArrayOf(0, 0, -100)
        )
        assertEquals(-47, MinFallingPathSum.minFallingPathSum(values))
    }

    @Test
    fun test4() {
        val values = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(4, 5, 50, 29),
            intArrayOf(7, 8, 9, -100)
        )
        assertEquals(-68, MinFallingPathSum.minFallingPathSum(values))
    }
}