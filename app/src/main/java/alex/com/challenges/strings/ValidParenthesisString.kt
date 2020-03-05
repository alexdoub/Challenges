package alex.com.challenges.strings

/**
 * Created by Alex Doub on 11/18/2019.
 * https://leetcode.com/problems/valid-parenthesis-string/
 */

class ValidParenthesisString {
    companion object {
        fun checkValidString(s: String): Boolean {
            fun stringIsValid(position: Int, stackSize: Int): Boolean {
                // Assert stack is not negative
                if (stackSize < 0) {
                    return false
                }

                //Assert remaining solution is still possible
                if (s.length - position < stackSize) {
                    return false
                }

                var stack = stackSize
                (position until s.length).forEach {
                    debugPrint("Checking position: $it with stack:$stack")
                    val char = s[it]
                    when (char) {
                        '(' -> {
                            stack += 1
                            debugPrint("... it was open. Stack is now $stack")
                        }
                        ')' -> {
                            if (stack == 0) {
                                debugPrint("... it was close. No stack, early fail")
                                return false
                            }
                            stack -= 1
                        }
                        '*' -> {
                            debugPrint("... it was star. Triple split")
                            return stringIsValid(it + 1, stack - 1) // If it was close
                                    || stringIsValid(it + 1, stack) // If it was empty string
                                    || stringIsValid(it + 1, stack + 1) // If it was open string
                        }
                    }
                }
                debugPrint("Done enumerating from $position and stack $stackSize. Final stack is $stack")
                return stack == 0
            }

            return stringIsValid(0, 0)
        }

        private fun debugPrint(string: String) {
            if (false) {
                println(string)
            }
        }
    }
}