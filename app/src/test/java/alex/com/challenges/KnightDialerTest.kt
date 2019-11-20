package alex.com.challenges

import alex.com.challenges.dynamic.KnightDialer
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 11/19/2019.
 */

class KnightDialerTest  {
    @Test
    fun test1() {
        assertEquals(10, KnightDialer.knightDialer(1))
    }

    @Test
    fun test2() {
        assertEquals(20, KnightDialer.knightDialer(2))
    }

    @Test
    fun test3() {
        assertEquals(46, KnightDialer.knightDialer(3))
    }

    @Test
    fun test5() {
        assertEquals(851996060, KnightDialer.knightDialer(2500))
    }

    @Test
    fun test8() {
        assertEquals(406880451, KnightDialer.knightDialer(5000))
    }
}