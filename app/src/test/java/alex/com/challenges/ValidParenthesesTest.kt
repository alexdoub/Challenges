package alex.com.challenges

import alex.com.challenges.stack.ValidParentheses
import org.junit.Test

/**
 * Created by Alex Doub on 11/18/2019.
 */

class ValidParenthesesTest {
    @Test
    fun test1() {
        assert(ValidParentheses.isValid("()"))
    }

    @Test
    fun test2() {
        assert(ValidParentheses.isValid("()[]{}"))
    }

    @Test
    fun test3() {
        assert(!ValidParentheses.isValid("(}"))
    }

    @Test
    fun test4() {
        assert(!ValidParentheses.isValid("([)]"))
    }

    @Test
    fun test5() {
        assert(ValidParentheses.isValid("{([])}"))
    }

    @Test
    fun test6() {
        assert(ValidParentheses.isValid("{([])}"))
    }

    @Test
    fun test7() {
        assert(ValidParentheses.isValid("{([asd213!@#@#+_])}"))
    }

    @Test
    fun test8() {
        assert(!ValidParentheses.isValid("["))
    }
}