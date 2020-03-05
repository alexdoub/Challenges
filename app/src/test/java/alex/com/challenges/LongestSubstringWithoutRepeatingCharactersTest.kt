package alex.com.challenges

import alex.com.challenges.strings.LongestSubstringWithoutRepeatingCharacters
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    fun test1() {
        assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun test2() {
        assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun test3() {
        assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun test4() {
        assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcba"))
    }
}