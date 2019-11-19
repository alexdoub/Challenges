package alex.com.challenges

import org.junit.Test

/**
 * Created by Alex Doub on 11/18/2019.
 */

class ValidParenthesisTest {
    @Test
    fun test1() {
        assert(ValidParenthesis.isValid("()"))
    }

    @Test
    fun test2() {
        assert(ValidParenthesis.isValid("()[]{}"))
    }

    @Test
    fun test3() {
        assert(!ValidParenthesis.isValid("(}"))
    }

    @Test
    fun test4() {
        assert(!ValidParenthesis.isValid("([)]"))
    }

    @Test
    fun test5() {
        assert(ValidParenthesis.isValid("{([])}"))
    }

    @Test
    fun test6() {
        assert(ValidParenthesis.isValid("{([])}"))
    }

    @Test
    fun test7() {
        assert(ValidParenthesis.isValid("{([asd213!@#@#+_])}"))
    }

    @Test
    fun test8() {
        assert(!ValidParenthesis.isValid("["))
    }
}