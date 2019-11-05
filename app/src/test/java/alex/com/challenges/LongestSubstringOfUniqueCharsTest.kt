package alex.com.challenges

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class LongestSubstringOfUniqueCharsTest {

    @Test
    fun test1() {
        assertEquals(3, LongestSubstringOfUniqueChars.lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun test2() {
        assertEquals(1, LongestSubstringOfUniqueChars.lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun test3() {
        assertEquals(3, LongestSubstringOfUniqueChars.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun test4() {
        assertEquals(3, LongestSubstringOfUniqueChars.lengthOfLongestSubstring("abcba"))
    }
}