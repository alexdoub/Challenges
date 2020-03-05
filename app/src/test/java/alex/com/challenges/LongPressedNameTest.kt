package alex.com.challenges

import alex.com.challenges.strings.LongPressedName
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.StringBuilder

/**
 * Created by Alex Doub on 11/30/2019.
 */

class LongPressedNameTest {
    @Test
    fun test1() {
        val key = "alex"
        val input = "aallllllleex"
        assertEquals(true, LongPressedName.isLongPressedName(key, input))
    }

    @Test
    fun test2() {
        val key = "saeed"
        val input = "ssaaedd"
        assertEquals(false, LongPressedName.isLongPressedName(key, input))
    }

    @Test
    fun test3() {
        val key = "leelee"
        val input = "lleeelee"
        assertEquals(true, LongPressedName.isLongPressedName(key, input))
    }

    @Test
    fun test4() {
        val key = "laiden"
        val input = "laiden"
        assertEquals(true, LongPressedName.isLongPressedName(key, input))
    }

    @Test
    fun test5() {
        val key = ""
        val input = "a"
        assertEquals(false, LongPressedName.isLongPressedName(key, input))
    }

    @Test
    fun test6() {
        val key = "a"
        val input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
        assertEquals(false, LongPressedName.isLongPressedName(key, input))
    }

    @Test
    fun test7() {
        val key = "a"
        val input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        assertEquals(true, LongPressedName.isLongPressedName(key, input))
    }

    @Test
    fun test8_stress_pass() {
        val key = StringBuilder().let { sb: StringBuilder ->
            (0 until 1000).forEach { sb.append("A") }
        }.toString()
        assertEquals(true, LongPressedName.isLongPressedName(key, key))
    }

    @Test
    fun test9_stress_fail() {
        val key = StringBuilder().let { sb: StringBuilder ->
            (0 until 1000).forEach { sb.append("A") }
        }.toString()
        assertEquals(false, LongPressedName.isLongPressedName(key, key + "B"))
    }

    @Test
    fun test10_OBSTACLE1() {
        val key =   "pyplrz"
        val input = "ppyypllr"
        assertEquals(false, LongPressedName.isLongPressedName(key, input))
    }
}