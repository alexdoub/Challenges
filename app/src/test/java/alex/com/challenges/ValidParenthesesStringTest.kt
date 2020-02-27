package alex.com.challenges

import org.junit.Test

/**
 * Created by Alex Doub on 11/18/2019.
 */

class ValidParenthesesStringTest {
    @Test
    fun test1() {
        assert(ValidParenthesisString.checkValidString("()"))
    }

    @Test
    fun test2() {
        assert(ValidParenthesisString.checkValidString("(*)"))
    }

    @Test
    fun test3() {
        assert(ValidParenthesisString.checkValidString("(*))"))
    }

    @Test
    fun test4() {
        assert(ValidParenthesisString.checkValidString("((*)"))
    }

    @Test
    fun test5() {
        assert(ValidParenthesisString.checkValidString(""))
    }

    @Test
    fun test6() {
        assert(ValidParenthesisString.checkValidString("(") == false)
        assert(ValidParenthesisString.checkValidString(")") == false)
    }

    @Test
    fun test7() {
        assert(ValidParenthesisString.checkValidString("*****)))))"))
    }

    @Test
    fun test8() {
        assert(ValidParenthesisString.checkValidString("(((((*****"))
    }

    @Test
    fun test9() {
        assert(ValidParenthesisString.checkValidString("**************"))
    }

    @Test
    fun test10_OBSTACLE() {
        assert(ValidParenthesisString.checkValidString("()(()(*(())()*)(*)))()))*)((()(*(((()())()))()()*)((*)))()))(*)(()()(((()*()()((()))((*((*)()") == false)
    }

    @Test
    fun test11_OBSTACLE() {
        assert(ValidParenthesisString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())") == false)
    }
}