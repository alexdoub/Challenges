package alex.com.challenges

//https://leetcode.com/problems/assign-cookies/
class AssignCookies {
    companion object {
        fun findContentChildren(children: IntArray, cookies: IntArray): Int {
            var satisfiedChildren = 0
            val cookiesArray = cookies.toTypedArray().sortedDescending().toMutableList()
            for (child in children.sortedDescending()) {

                if (cookiesArray.isEmpty()) break

                val cookie = cookiesArray.first()
                if (child <= cookie) {
                    cookiesArray.removeAt(0)
                    satisfiedChildren += 1
                }
            }
            return satisfiedChildren
        }
    }
}