package alex.com.challenges

import alex.com.challenges.matrix.MinimumPath2DSum
import alex.com.challenges.matrix.MinimumPath4DSum
import org.junit.Assert.assertEquals
import org.junit.Test

class MinimumPath4DSumTest {
    @Test
    fun test1() {
        val input = arrayOf(
            intArrayOf(1,3,1),
            intArrayOf(1,5,1),
            intArrayOf(4,2,1)
        )
        assertEquals(7, MinimumPath2DSum.minPathSum(input))
        assertEquals(7, MinimumPath4DSum.minPathSum(input))
    }

    @Test
    fun test2() {
        val input = arrayOf(
            intArrayOf(1,1,1),
            intArrayOf(1,1,2),
            intArrayOf(5,1,1)
        )
        assertEquals(5, MinimumPath2DSum.minPathSum(input))
        assertEquals(5, MinimumPath4DSum.minPathSum(input))
    }

    @Test
    fun test3() {
        val input = arrayOf(
            intArrayOf(1,1,1,9),
            intArrayOf(9,9,1,9),
            intArrayOf(9,1,1,9),
            intArrayOf(9,1,9,9),
            intArrayOf(9,1,1,1)
        )
        assertEquals(10, MinimumPath4DSum.minPathSum(input))
    }

    @Test
    fun test4() {
        val input = arrayOf(
            intArrayOf(1,1,1,1,1),
            intArrayOf(99,99,99,99,1),
            intArrayOf(1,1,1,99,1),
            intArrayOf(1,9,1,1,1),
            intArrayOf(1,99,99,99,99),
            intArrayOf(1,1,1,1,1)
        )
        assertEquals(20, MinimumPath4DSum.minPathSum(input))
    }
}