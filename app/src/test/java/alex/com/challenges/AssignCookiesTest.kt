package alex.com.challenges

import alex.com.challenges.arrays.AssignCookies
import org.junit.Assert.assertEquals
import org.junit.Test

class AssignCookiesTest {
    @Test
    fun test1() {
        val children = intArrayOf(1, 2, 3)
        val cookies = intArrayOf(1, 1)
        assertEquals(1, AssignCookies.findContentChildren(children, cookies))
    }

    @Test
    fun test2() {
        val children = intArrayOf(1, 2)
        val cookies = intArrayOf(1, 2, 3)
        assertEquals(2, AssignCookies.findContentChildren(children, cookies))
    }

    @Test
    fun test3() {
        val children = intArrayOf(1, 1, 1, 5, 10, 10, 10)
        val cookies = intArrayOf(10, 5, 1, 1, 1, 1, 1, 1, 1, 1)
        assertEquals(5, AssignCookies.findContentChildren(children, cookies))
    }

    @Test
    fun test4() {
        val children = intArrayOf(1, 1, 1, 5, 10, 10, 10)
        val cookies = intArrayOf(10, 5, 1)
        assertEquals(3, AssignCookies.findContentChildren(children, cookies))
    }

    @Test
    fun test5() {
        val children = intArrayOf(1, 1, 1, 5, 10, 10, 10)
        val cookies = intArrayOf()
        assertEquals(0, AssignCookies.findContentChildren(children, cookies))
    }

    @Test
    fun test6() {
        val children = intArrayOf()
        val cookies = intArrayOf(1, 1, 1, 5, 10, 10, 10)
        assertEquals(0, AssignCookies.findContentChildren(children, cookies))
    }
}