package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.StringBuilder

/**
 * Created by Alex Doub on 11/29/2019.
 */

class StringIncludesPermutationTest {
    @Test
    fun test1() {
        val s1 = "ab"
        val s2 = "eidbaooo"
        assertEquals(true, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test2() {
        val s1 = "ab"
        val s2 = "eidboaoo"
        assertEquals(false, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test3() {
        val s1 = "aaaaa"
        val s2 = "zzzaaaaazz"
        assertEquals(true, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test4() {
        val s1 = "aaaaa"
        val s2 = "zzzaaaazaz"
        assertEquals(false, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test5() {
        val s1 = "aabcaa"
        val s2 = "zzzzzzzaaaabczzzzzzzzzzzzzz"
        assertEquals(true, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test6() {
        val s1 = "aabcaa"
        val s2 = "zzzzzzzaabcazazzzzzzzzzzzzz"
        assertEquals(false, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test7_OBSTACLE1() {
        val s1 = "adc"
        val s2 = "dcda"
        assertEquals(true, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test8_stress() {
        val a = StringBuilder()
        (0 until 10000).forEach {
            a.append("a")
        }
        val s1 = a.toString()
        val s2 = a.toString()

        assertEquals(true, StringIncludesPermutation.checkInclusion(s1, s2))
    }

    @Test
    fun test9_stress() {
        val a = StringBuilder()
        (0 until 10000).forEach {
            a.append("a")
        }
        val s1 = a.toString() + "b"
        var s2 = a.toString()

        assertEquals(false, StringIncludesPermutation.checkInclusion(s1, s2))
    }
}