package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 12/4/2019.
 */

class CandyDistributionTest {
    @Test
    fun test1() {
        val children = intArrayOf(1,0,2)
        assertEquals(5, CandyDistribution.candy(children))
    }

    @Test
    fun test2() {
        val children = intArrayOf(1,2,2)
        assertEquals(4, CandyDistribution.candy(children))
    }

    @Test
    fun test3() {
        val children = intArrayOf(1,2,3,1,2,3)
        assertEquals(12, CandyDistribution.candy(children))
    }

    @Test
    fun test4() {
        val children = intArrayOf(90,95,89,92,93)
        assertEquals(9, CandyDistribution.candy(children))
    }

    @Test
    fun test5() {
        val children = intArrayOf(90,95,89,92,92)
        assertEquals(7, CandyDistribution.candy(children))
    }

    @Test
    fun test6() {
        val children = intArrayOf(1,2,3,3,3,3,2,1)
        assertEquals(14, CandyDistribution.candy(children))
    }
}