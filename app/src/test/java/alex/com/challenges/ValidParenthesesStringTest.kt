package alex.com.challenges

import alex.com.challenges.stack.ValidParenthesesString
import org.junit.Test

/**
 * Created by Alex Doub on 11/18/2019.
 */

class ValidParenthesesStringTest {
    @Test
    fun test1() {
        assert(ValidParenthesesString.checkValidString("()"))
    }

    @Test
    fun test2() {
        assert(ValidParenthesesString.checkValidString("(*)"))
    }

    @Test
    fun test3() {
        assert(ValidParenthesesString.checkValidString("(*))"))
    }

    @Test
    fun test4() {
        assert(ValidParenthesesString.checkValidString("((*)"))
    }

    @Test
    fun test5() {
        assert(ValidParenthesesString.checkValidString(""))
    }

    @Test
    fun test6() {
        assert(ValidParenthesesString.checkValidString("(") == false)
        assert(ValidParenthesesString.checkValidString(")") == false)
    }

    @Test
    fun test7() {
        assert(ValidParenthesesString.checkValidString("*****)))))"))
    }

    @Test
    fun test8() {
        assert(ValidParenthesesString.checkValidString("(((((*****"))
    }

    @Test
    fun test9() {
        assert(ValidParenthesesString.checkValidString("**************"))
    }

    @Test
    fun test10_OBSTACLE() {
        assert(ValidParenthesesString.checkValidString("()(()(*(())()*)(*)))()))*)((()(*(((()())()))()()*)((*)))()))(*)(()()(((()*()()((()))((*((*)()") == false)
    }

    @Test
    fun test11_OBSTACLE() {
        assert(ValidParenthesesString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())") == false)
    }
}