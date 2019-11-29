package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 11/29/2019.
 */

class MinWindowSubstringTest {
    @Test
    fun test1() {
        val alphabet = "ABC"
        val input = "ADOBECODEBANC"
        assertEquals("BANC", MinWindowSubstring.minWindow(input, alphabet))
    }

    @Test
    fun test2() {
        val alphabet = "abc"
        val input = "ababababababababababbababababababababbababaaabzzzcaabb"
        assertEquals("caab", MinWindowSubstring.minWindow(input, alphabet))
    }

    @Test
    fun test3() {
        val alphabet = "abc"
        val input = "asddsadsadsadsajkhldsaksladlksadjosakdjoqiuweoiqweuoiwljk"
        assertEquals("", MinWindowSubstring.minWindow(input, alphabet))
    }

    @Test
    fun test4() {
        val alphabet = ""
        val input = "asddsadsadsadsajkhldsaksladlksadjosakdjoqiuweoiqweuoiwljk"
        assertEquals("", MinWindowSubstring.minWindow(input, alphabet))
    }

    @Test
    fun test5() {
        val alphabet = "aaabaa"
        val input = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzaaazzbzzaazzz"
        assertEquals("aaazzbzzaa", MinWindowSubstring.minWindow(input, alphabet))
    }

    @Test
    fun test6() {
        val alphabet = "aaabaa1"
        val input = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzaaazzbzzaazzz"
        assertEquals("", MinWindowSubstring.minWindow(input, alphabet))
    }
}