package alex.com.challenges

import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 1/5/2020.
 */

class ThreeSumTest {
    @Test
    fun test1() {
        val input = intArrayOf(-1, 0, 1, 2, -1, -4) // sorted to -4, -1, -1, 0, 1, 2
        val result = ThreeSum.threeSum(input)

        assertEquals(2, result.size)
        assertTrue(result.any{it.containsAll(listOf(-1, 0, 1))})
        assertTrue(result.any{it.containsAll(listOf(-1, -1, 2))})
    }

    @Test
    fun test2() {
        val input = intArrayOf(10, -10, 0, 5, -5, 0, 33, -2, 99, 98, 2, -2000, -4000)
        val result = ThreeSum.threeSum(input)
        assertEquals(3, result.size)    //10s, 5s, 0-3-2
    }

    @Test
    fun test3() {
        val input = intArrayOf(0,0,-1,-1,1,1,0)
        val result = ThreeSum.threeSum(input)
        assertEquals(2, result.size)
    }
}