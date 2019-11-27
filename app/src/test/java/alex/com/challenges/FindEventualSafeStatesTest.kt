package alex.com.challenges

import alex.com.challenges.dynamic.FindEventualSafeStates
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 11/26/2019.
 */

class FindEventualSafeStatesTest {
    @Test
    fun test1() {
        val graph = arrayOf(
            intArrayOf(1, 2),   //0
            intArrayOf(2, 3),
            intArrayOf(5),      //2

            intArrayOf(0),
            intArrayOf(5),      //4
            intArrayOf(),

            intArrayOf()
        )
        val output = FindEventualSafeStates.eventualSafeNodes(graph)
        assert(output == listOf(2, 4, 5, 6))
    }

    @Test
    fun test2() {
        val graph = arrayOf(
            intArrayOf(),
            intArrayOf(2),
            intArrayOf(3),
            intArrayOf(2),
            intArrayOf()
        )
        val output = FindEventualSafeStates.eventualSafeNodes(graph)
        assertEquals(listOf(0, 4), output)
    }

    @Test
    fun test3_OBSTACLE1() {
        //[[],[0,2,3,4],[3],[4],[]]
        val graph = arrayOf(
            intArrayOf(),
            intArrayOf(0, 2, 3, 4),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf()
        )
        val output = FindEventualSafeStates.eventualSafeNodes(graph)
        assertEquals(listOf(0, 1, 2, 3, 4), output)
    }

    @Test
    fun test4_OBSTACLE2() {
        //[[0,1,2,3,4],[2,3,4],[3,4],[4],[]]
        val graph = arrayOf(
            intArrayOf(0, 1, 2, 3, 4),
            intArrayOf(2, 3, 4),
            intArrayOf(3, 4),
            intArrayOf(4),
            intArrayOf()
        )
        val output = FindEventualSafeStates.eventualSafeNodes(graph)
        assertEquals(listOf(1, 2, 3, 4), output)
    }
}