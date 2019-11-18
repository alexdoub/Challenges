package alex.com.challenges

import org.junit.Test

/**
 * Created by Alex Doub on 11/17/2019.
 */

class MinimumSwapsTest {
    @Test
    fun test1() {
        val s1 = "xx"
        val s2 = "yy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 1)
    }

    @Test
    fun test2() {
        val s1 = "yx"
        val s2 = "xy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 2)
    }

    @Test
    fun test21() {
        val s1 = "xy"
        val s2 = "yx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 2)
    }

    @Test
    fun test3() {
        val s1 = "xy"
        val s2 = "xx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == -1)
    }

    @Test
    fun test4() {
        val s1 = "xxyyxyxyxx"
        val s2 = "xyyxyxxxyx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 4)
    }

    @Test
    fun test5() {
        val s1 = "xxxx"
        val s2 = "yyyy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 2)
    }

    // fails due to odd #
    @Test
    fun test6() {
        val s1 = "xxx"
        val s2 = "yyy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == -1)
    }

    @Test
    fun test7() {
        val s1 = "xxxy"
        val s2 = "xyyy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 1)
    }
}