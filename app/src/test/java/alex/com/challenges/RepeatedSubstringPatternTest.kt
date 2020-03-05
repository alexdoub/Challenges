package alex.com.challenges

import alex.com.challenges.strings.RepeatedSubstringPattern
import org.junit.Test

/**
 * Created by Alex Doub on 11/30/2019.
 */

class RepeatedSubstringPatternTest {
    @Test
    fun test1() {
        val string = "aaabbbaaabbb"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string))
    }

    @Test
    fun test2() {
        val string = "aaabbbaaabbbc"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string) == false)
    }

    @Test
    fun test3() {
        val string = "ababab"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string))
    }

    @Test
    fun test4() {
        val string = "a"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string) == false)
    }

    @Test
    fun test5() {
        val string = "abc"
        val finalString = string.repeat(7)
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(finalString))
    }

    @Test
    fun test6() {
        val string = "abc"
        val finalString = string.repeat(7) + "z"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(finalString) == false)
    }

    @Test
    fun test7() {
        val string = ""
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string) == false)
    }

    @Test
    fun test8() {
        val string = "aa"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string) == true)
    }

    @Test
    fun test9() {
        val string = "aaa"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string) == true)
    }

    @Test
    fun test10() {
        val string = "ab"
        assert(RepeatedSubstringPattern.repeatedSubstringPattern(string) == false)
    }
}