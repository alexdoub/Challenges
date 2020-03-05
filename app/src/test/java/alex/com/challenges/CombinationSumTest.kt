package alex.com.challenges

import alex.com.challenges.arrays.CombinationSum
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by Alex Doub on 1/5/2020.
 */

class CombinationSumTest {
    @Test
    fun test1() {
        val inputs = intArrayOf(2, 3, 6, 7)
        val target = 7
        val res = CombinationSum.combinationSum(inputs, target)

        assertEquals(2, res.size)

        assertTrue(res.any {
            it.containsAll(listOf(7))
        })
        assertTrue(res.any {
            it.containsAll(listOf(2,2,3))
        })
    }

    @Test
    fun test2() {
        val inputs = intArrayOf(2, 3, 5)
        val target = 8
        val res = CombinationSum.combinationSum(inputs, target)

        assertEquals(3, res.size)

        assertTrue(res.any {
            it.containsAll(listOf(2,2,2,2))
        })
        assertTrue(res.any {
            it.containsAll(listOf(2,3,3))
        })
        assertTrue(res.any {
            it.containsAll(listOf(3,5))
        })
    }
}