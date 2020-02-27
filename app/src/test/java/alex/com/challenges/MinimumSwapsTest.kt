package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 11/17/2019.
 */

class MinimumSwapsTest {
    @Test
    fun test1a() {
        val s1 = "xx"
        val s2 = "yy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 1)
    }

    @Test
    fun test1b() {
        val s1 = "yx"
        val s2 = "xy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 2)
    }

    @Test
    fun test1c() {
        val s1 = "xy"
        val s2 = "yx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 2)
    }

    @Test
    fun test1dFAIL() {
        val s1 = "xxy"
        val s2 = "yyx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == -1)
    }

    @Test
    fun test1fail() {
        val s1 = "xy"
        val s2 = "xx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == -1)
    }

    @Test
    fun test500() {
        val s1 = "xxyyxyxyxx"
        val s2 = "xyyxyxxxyx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 4)
    }

    @Test
    fun test5a() {
        val s1 = "xxxx"
        val s2 = "yyyy"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assert(result == 2)
    }

    @Test
    fun test5b() {
        val s1 = "xxyxxy"
        val s2 = "yyxyyx"
        //sorts to
//        val s1 = "yx yxxy"
//        val s2 = "yx xyyx"
        //1

//        val s1 = "yxy xxx"
//        val s2 = "yxy yyx"
        //2

//        val s1 = "yxy yxx"
//        val s2 = "yxy yxx"
        //3

        val result = MinimumSwaps.minimumSwap(s1, s2)
        assertEquals(3, result)
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

    @Test
    fun test8() {
        val s1 = "xxxyyy"
        val s2 = "yyyxxx"
        val result = MinimumSwaps.minimumSwap(s1, s2)
        assertEquals(4, result)

        //1 (greedy swap first)
        //y xxyyy
        //y xyxxx

        //2 (swap end to balance out)
        //yx xyy x
        //yx yxx y

        //3 (greedy swap again)
        //yxy yy x
        //yxy xx x

        //4 - done
        //yxy xy x
        //yxy xy x
    }
}