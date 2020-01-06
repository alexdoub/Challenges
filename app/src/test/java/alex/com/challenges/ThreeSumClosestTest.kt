package alex.com.challenges

import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 1/5/2020.
 */

class ThreeSumClosestTest {
    @Test
    fun test1() {
        val input = intArrayOf(-1, 2, 1, -4)
        val result = ThreeSumClosest.threeSumClosest(input, 1)

        //-1 + 1 + 2
        assertEquals(2, result)
    }

    @Test
    fun test2() {
        val input = intArrayOf(0,1,2,3,4,5)
        val result = ThreeSumClosest.threeSumClosest(input, 100)

        //5 + 4 + 3
        assertEquals(12, result)
    }

    @Test
    fun test3() {
        val nums = intArrayOf(1,2,4,8,16,32,64,128)
        val tar = 82    //64 + 16 + 2

        assertEquals(82, ThreeSumClosest.threeSumClosest(nums, tar))
    }
}