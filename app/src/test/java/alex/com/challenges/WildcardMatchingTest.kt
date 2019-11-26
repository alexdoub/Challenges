package alex.com.challenges

import alex.com.challenges.dynamic.WildcardMatching
import org.junit.Test

/**
 * Created by Alex Doub on 11/25/2019.
 */

class WildcardMatchingTest {
    @Test
    fun test1() {
        assert(WildcardMatching.isMatch("aa", "a") == false)
    }

    @Test
    fun test2() {
        assert(WildcardMatching.isMatch("aa", "*") == true)
    }

    @Test
    fun test22() {
        assert(WildcardMatching.isMatch("aa", "*****") == true)
    }

    @Test
    fun test3() {
        assert(WildcardMatching.isMatch("cb", "?a") == false)
    }

    @Test
    fun test4() {
        assert(WildcardMatching.isMatch("cb", "?b") == true)
    }

    @Test
    fun test5() {
        assert(WildcardMatching.isMatch("adceb", "*a*b") == true)
    }

    @Test
    fun test6() {
        assert(WildcardMatching.isMatch("acdcb", "a*c?b") == false)
    }

    @Test
    fun test7() {
        assert(WildcardMatching.isMatch("abcdefg", "*") == true)
    }

    @Test
    fun test8() {
        assert(WildcardMatching.isMatch("asasas", "a*********s") == true)
    }

    @Test
    fun test9() {
        assert(WildcardMatching.isMatch("asasas", "a*********a") == false)
    }

    @Test
    fun test10() {
        assert(WildcardMatching.isMatch("", "*"))
    }

    @Test
    fun test11() {
        assert(WildcardMatching.isMatch("", ""))
    }

    @Test
    fun test12() {
        assert(WildcardMatching.isMatch("abc", "abc*"))
    }

    @Test
    fun test13() {
        assert(WildcardMatching.isMatch("abc", "abc******"))
    }

    @Test
    fun test14_OBSTACLE_time_limit() {
        assert(
            WildcardMatching.isMatch(
                "aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab",
                "*ab***ba**b*b*aaab*b"
            )
        )
        // Fixed by coalescing wildcards
    }


    @Test
    fun test15_OBSTACLE_time_limit() {
        assert(
            WildcardMatching.isMatch(
                "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"
            )
        )
        // Fixed by moving to DP
    }

    @Test
    fun test16() {
        assert(
            WildcardMatching.isMatch(
                "aab",
                "c*a*b"
            ) == false
        )
    }
}