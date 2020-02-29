package alex.com.challenges.common

open class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun debugPrintToConsole() {

        var nodes = ArrayList<TreeNode>()
        nodes.add(this)

        while (nodes.isNotEmpty()) {
            val newList = ArrayList<TreeNode>()
            for (node in nodes) {
                print(node.`val`.toString() + " -> (${node.left?.`val` ?: "null"}, ${node.right?.`val` ?: "null"})")
                node.left?.let {
                    newList.add(it)
                }
                node.right?.let {
                    newList.add(it)
                }
                println("")
            }
            println("----")
            nodes = newList
        }
    }
}