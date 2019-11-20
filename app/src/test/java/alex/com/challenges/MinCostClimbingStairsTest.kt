package alex.com.challenges

import alex.com.challenges.dynamic.MinCostClimbingStairs2
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 11/18/2019.
 */

class MinCostClimbingStairsTest  {
    @Test
    fun test1() {
        val costs = intArrayOf(10, 15, 20)
        assertEquals(15, MinCostClimbingStairs2.minCostClimbingStairs(costs))
    }

    @Test
    fun test2() {
        val costs = intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)
        assertEquals(6, MinCostClimbingStairs2.minCostClimbingStairs(costs))
    }

    @Test
    fun test3() {
        val costs = intArrayOf(1, 100, 1)
        assertEquals(2, MinCostClimbingStairs2.minCostClimbingStairs(costs))
    }

    @Test
    fun test4() {
        val costs = intArrayOf(1, 100, 1, 100)
        assertEquals(2, MinCostClimbingStairs2.minCostClimbingStairs(costs))
    }

    @Test
    fun test41() {
        val costs = intArrayOf(1, 100, 1, 100, 1)
        assertEquals(3, MinCostClimbingStairs2.minCostClimbingStairs(costs))
    }

    @Test
    fun test5() {
        val costs = intArrayOf(100, 1, 100, 1, 100)
        assertEquals(2, MinCostClimbingStairs2.minCostClimbingStairs(costs))
    }

}