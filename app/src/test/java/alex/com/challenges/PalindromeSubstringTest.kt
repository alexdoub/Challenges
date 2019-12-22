package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 2019-12-08.
 */

class PalindromeSubstringTest {
    @Test
    fun test1() {
        val string = "abczxyxz"
        assertEquals("zxyxz", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test2() {
        val string = "zzzzzzzzzzzz"
        assertEquals("zzzzzzzzzzzz", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test22() {
        val string = "zz"
        assertEquals("zz", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test222() {
        val string = "zzz"
        assertEquals("zzz", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test3() {
        val string = "zzzzzzzzzzzzz"
        assertEquals("zzzzzzzzzzzzz", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test4() {
        val string = "121zxczx123321zc"
        assertEquals("123321", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test5() {
        val string = "abc"
        assert(PalindromeSubstring.longestPalindrome(string).length == 1)
    }

    @Test
    fun test51() {
        val string = "abbc"
        assertEquals("bb", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test52() {
        val string = "acbbb"
        assertEquals("bbb", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test6() {
        val string = ""
        assertEquals("", PalindromeSubstring.longestPalindrome(string))
    }

    @Test
    fun test7() {
        val string = "aaaaazxcz444a444xczxcbbbb"
        assertEquals("444a444", PalindromeSubstring.longestPalindrome(string))
    }
}