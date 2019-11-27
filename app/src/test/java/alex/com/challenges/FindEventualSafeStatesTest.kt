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
            intArrayOf(0, 1, 2, 3, 4),  //0
            intArrayOf(2, 3, 4),        //1
            intArrayOf(3, 4),           //2
            intArrayOf(4),              //3
            intArrayOf()                //4
        )
        val output = FindEventualSafeStates.eventualSafeNodes(graph)
        assertEquals(listOf(1, 2, 3, 4), output)
    }

    @Test
    fun test5_OBSTACLE3() {
        val input = arrayOf(
            intArrayOf(17, 21, 22, 27),
            intArrayOf(11, 12, 14, 19, 23),
            intArrayOf(4, 27),
            intArrayOf(16, 18, 20, 27),
            intArrayOf(5, 14, 19, 27, 28),

            intArrayOf(7, 15, 21, 25, 29),
            intArrayOf(7, 10, 18, 28),
            intArrayOf(12, 14, 21, 23, 29),
            intArrayOf(9, 12, 18, 22, 24),
            intArrayOf(19, 21, 25),

            intArrayOf(15, 18, 21, 28),
            intArrayOf(19, 23, 24, 28),
            intArrayOf(13, 19, 21),
            intArrayOf(14, 19, 25),
            intArrayOf(2, 26, 27),

            intArrayOf(),
            intArrayOf(),
            intArrayOf(3, 23, 24, 25, 26),
            intArrayOf(19, 20, 24, 27, 29),
            intArrayOf(23, 25),

            intArrayOf(11, 22, 24, 25, 26, 27, 29),
            intArrayOf(24, 25),
            intArrayOf(23, 29),
            intArrayOf(24, 25, 28, 29),
            intArrayOf(27),

            intArrayOf(26, 27, 28, 29),
            intArrayOf(),
            intArrayOf(28, 29),
            intArrayOf(29),
            intArrayOf()
        )

        val output =
            listOf(0, 3, 9, 10, 11, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29)

        assertEquals(output, FindEventualSafeStates.eventualSafeNodes(input))
    }

    // This test exposes a flaw: my sortedSet queue only works from left to right
    // Note: I could expand visited horizontally...
    @Test
    fun test6() {
        val graph = arrayOf(
            intArrayOf(),  //0
            intArrayOf(0),        //1
            intArrayOf(0, 1),           //2
            intArrayOf(0, 1, 2),              //3
            intArrayOf(0, 1, 2, 3)                //4
        )
        val output = FindEventualSafeStates.eventualSafeNodes(graph)
        assertEquals(listOf(0, 1, 2, 3, 4), output)
    }

    //@@TODO: RESOLVE THIS WITH NEW APPROACH
}