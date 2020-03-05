package alex.com.challenges

import alex.com.challenges.arrays.FourSum
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 1/5/2020.
 */

class FourSumTest {
    @Test
    fun test1() {
        val input = intArrayOf(1, 0, -1, 0, -2, 2)  //sorted to -2, -1, 0, 0, 1, 2
        val target = 0
        val result = FourSum.fourSum(input, target)

        assertEquals(3, result.size)

    }

    @Test
    fun test2() {
        val input = intArrayOf(0,0,0,0)
        val target = 0
        val result = FourSum.fourSum(input, target)

        assertEquals(1, result.size)

    }
}