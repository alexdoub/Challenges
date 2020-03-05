package alex.com.challenges

import alex.com.challenges.matrix.LargestIsland
import org.junit.Assert.assertEquals
import org.junit.Test

class LargestIslandTest {

    /**

     0, 0, 0, 1, 1
     0, 1, 0, 0, 1
     1, 1, 1, 0, 1
     0, 1, 0, 1, 1
     1, 0, 0, 1, 1

     * */

    @Test
    fun test1() {
        val island = arrayOf(
            booleanArrayOf(false, false, false, true, true),
            booleanArrayOf(false, true, false, false, true),
            booleanArrayOf(true, true, true, false, true),
            booleanArrayOf(false, true, false, true, true),
            booleanArrayOf(true, false, false, true, true)
        )

        assertEquals(8, LargestIsland.areaOfLargestIsland(island))
    }
    /**

    1, 1, 1, 1,
    1, 0, 0, 1,
    1, 0, 0, 1,
    1, 1, 1, 1,

     * */
    @Test
    fun test2() {
        val island = arrayOf(
            booleanArrayOf(true, true, true, true),
            booleanArrayOf(true, false, false, true),
            booleanArrayOf(false, false, false, true),
            booleanArrayOf(true, true, true, true)
        )

        assertEquals(11, LargestIsland.areaOfLargestIsland(island))
    }

    /**

    1, 1, 1, 0,
    0, 0, 0, 1,
    0, 0, 0, 1,
    1, 0, 0, 1,

     * */
    @Test
    fun test3() {
        val island = arrayOf(
            booleanArrayOf(true, true, true, false),
            booleanArrayOf(false, false, false, true),
            booleanArrayOf(false, false, false, true),
            booleanArrayOf(true, false, false, true)
        )

        assertEquals(3, LargestIsland.areaOfLargestIsland(island))
    }

    /**



    0, 0,
    1, 1,

     * */
    @Test
    fun test4() {
        val island = arrayOf(
            booleanArrayOf(false, false),
            booleanArrayOf(true, true)
        )

        assertEquals(2, LargestIsland.areaOfLargestIsland(island))
    }
}