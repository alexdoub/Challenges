package alex.com.challenges

/**
 * Created by Alex Doub on 1/7/2020.
 * https://leetcode.com/problems/generate-parentheses/
 */

class GenerateParenthesis {
    companion object {
        fun generateParenthesis(n: Int): List<String> {
            fun getParenthesisStrings(string: String, left: Int, right: Int): List<String> {
                val options = ArrayList<String>()

                if (left == n && right == n) {
                    return listOf(string)
                }

                //Try left
                if (left < n) {
                    options.addAll(getParenthesisStrings(string + "(", left + 1, right))
                }
                //Try right
                if (right < n && right < left) {
                    options.addAll(getParenthesisStrings(string + ")", left, right + 1))
                }

                return options
            }

            return getParenthesisStrings("", 0, 0)
        }
    }
}