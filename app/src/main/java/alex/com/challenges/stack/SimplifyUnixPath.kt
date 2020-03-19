package alex.com.challenges.stack

/**
 * Created by Alex Doub on 3/18/2020.
 * https://leetcode.com/problems/simplify-path
 */

object SimplifyUnixPath {
    fun simplifyPath(path: String): String {

        val recordedPath = StringBuilder()
        val pathStack = ArrayList<String>()

        fun endStack() {
            val p = recordedPath.toString()
            if (p.isEmpty()) return

            if (p == "..") {
                if (pathStack.isNotEmpty()) pathStack.removeAt(pathStack.size - 1)
            } else if (p != ".") {
                pathStack.add(p)
            }
            recordedPath.setLength(0)
        }

        for (x in path.indices) {
            if (path[x] == '/') {
                endStack()
            } else {
                recordedPath.append(path[x])
            }
        }
        endStack()

        return pathStack.joinToString(prefix = "/", separator = "/")
    }
}

