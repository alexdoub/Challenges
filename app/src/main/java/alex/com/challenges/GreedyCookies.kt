package alex.com.challenges

import java.util.*

class GreedyCookies {
    companion object {
        fun findContentChildren(children: IntArray, cookies: IntArray): Int {
            return solve_greedy(children, cookies)
        }

        private fun solve_greedy(children: IntArray, cookies: IntArray): Int {
            var satisfiedChildren = 0
            val cookiesDeque = ArrayDeque<Int>()
            cookiesDeque.addAll(cookies.toTypedArray().sorted().reversed())
            for (child in children.sorted().reversed()) {
                val cookie = cookiesDeque.peek()
                if (cookie != null && child <= cookie) {
                    cookiesDeque.pop()
                    satisfiedChildren += 1
                }
            }
            return satisfiedChildren
        }
    }
}