package alex.com.challenges

/**
 * Created by Alex Doub on 11/18/2019.
 * https://leetcode.com/problems/valid-parentheses/
 */

class ValidParentheses {
    companion object {
        fun isValid(s: String): Boolean {

            val stack = mutableListOf<Char>()
            s.forEach { char ->
                //push
                if (char == '[' || char == '(' || char == '{') {
                    stack.add(char)
                }
                // pop
                else {
                    //check if pop char
                    when (char) {
                        ']' -> {
                            val top = if (stack.isEmpty()) null else stack.removeAt(stack.size-1)
                            if (top != '[') {
                                return false
                            }
                        }
                        '}' -> {
                            val top = if (stack.isEmpty()) null else stack.removeAt(stack.size-1)
                            if (top != '{') {
                                return false
                            }
                        }
                        ')' -> {
                            val top = if (stack.isEmpty()) null else stack.removeAt(stack.size-1)
                            if (top != '(') {
                                return false
                            }
                        }
                        else -> {
                            //do nothing
                        }
                    }
                }
            }

            return stack.isEmpty()
        }
    }
}