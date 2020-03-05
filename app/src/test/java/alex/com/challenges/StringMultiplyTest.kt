package alex.com.challenges

import alex.com.challenges.dynamic.StringMultiply
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 2/4/2020.
 */

class StringMultiplyTest {
    @Test
    fun test1_range() {
        val max = 1000
        (0..max).forEach { x->
            (0..max).forEach { y ->
                assertSame(x, y)
            }
        }
    }



    private fun assertSame(x: Int, y: Int) {
        val expected = x * y
        println("Testing ${x} and ${y}")
        assertEquals(expected.toString(), StringMultiply.multiply(x.toString(), y.toString()))
    }

    @Test
    fun test2_specific() {
        assertEquals("110", StringMultiply.multiply(11.toString(), 10.toString()))
    }

    @Test
    fun test3_mega() {
        val x = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"  //100 digits
        val y = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
        val e = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999980000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"
        assertEquals(e, StringMultiply.multiply(x, y))
    }
}