package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 11/26/2019.
 * https://leetcode.com/problems/find-eventual-safe-states/
 *
 * A node is safe if it leads to a terminal node.
 * Thus, any nodes that cycle are unsafe.
 * Return all the safe nodes
 */

class FindEventualSafeStates {
    companion object {
        private fun debugPrint(string: String) {
            if (true) println(string)
        }

        //Second solution: will not pass any node that loops
        fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
            val safeNodeList = HashMap<Int, Boolean>()

            graph.forEachIndexed { index, ints ->

                // Maintain a list of visited nodes. Visit them in order
                // This makes it easy to detect a double-back
                // UPDATE: This only works from left -> right
                val visited = BooleanArray(graph.size) { false }

                val indexesToCheck = mutableSetOf<Int>().toSortedSet()
                indexesToCheck.add(index)

                debugPrint("Processing Node #$index. Initial NodesToCheck:${indexesToCheck.joinToString()}")
                var nodeIsSafe = true
                while (indexesToCheck.isNotEmpty() && nodeIsSafe) {

                    val nodeToCheck = indexesToCheck.first()
                    indexesToCheck.remove(nodeToCheck)
                    debugPrint("... checking $nodeToCheck")

                    if (visited[nodeToCheck]) {
                        nodeIsSafe = false
                        debugPrint(".... double back found. Marking unsafe")
                        break
                    }
                    visited[nodeToCheck] = true

                    graph[nodeToCheck].forEach {

                            if (safeNodeList[it] == false) {
                                // This paths to an unsafe node, thus this node isnt safe
                                nodeIsSafe = false
                                debugPrint(".... leads to $it which is already unsafe")
                            }  else {
                                // Add its path to our list
                                val newNodesToCheck = graph[it].toTypedArray()
                                debugPrint(".... leads to node ${it} with path: ${newNodesToCheck.joinToString()}")
                                indexesToCheck.addAll(newNodesToCheck)
                            }
                    }
                }
                safeNodeList[index] = nodeIsSafe
                debugPrint("Done checking. Marking node #$index as safe: $nodeIsSafe")
                debugPrint("--------------")
            }

            val indexOfSafeNodes = safeNodeList.filter { it.value == true }.map { it.key }
            return indexOfSafeNodes
        }

        //First solution: Misunderstood problem, solved something else
        fun eventualSafeNodes_UNLIMITED(graph: Array<IntArray>): List<Int> {
            val safeNodeList = BooleanArray(graph.size) { false }

            //Base case - Identify any terminal nodes
            graph.forEachIndexed { index, ints ->
                if (ints.isEmpty()) {
                    safeNodeList[index] = true
                    println("Node #${index} now marked as safe")
                }
            }
            debugPrint("Filled out base case")
            debugPrint(safeNodeList.joinToString())

            //Iteration case - propagate any nodes that touch a terminal
            var didChange = true
            while (didChange) {

                didChange = false

                // For each unsafe node
                graph.withIndex()
                    .filter { safeNodeList[it.index] == false }
                    .forEach { indexedValue ->

                        // If any paths are safe then this is safe
                        val paths = indexedValue.value
                        if (paths.any{ safeNodeList[it] == true }) {
                            safeNodeList[indexedValue.index] = true
                            didChange = true
                            println("Node #${indexedValue.index} now marked as safe")
                        }
                    }

                debugPrint(safeNodeList.joinToString())
            }

            val indexOfSafeNodes = safeNodeList.withIndex().filter { it.value == true }.map { it.index }
            return indexOfSafeNodes
        }
    }
}

// do nodes to visit in order, only marking them visited IN ORDER. that way you'll know if it doubles back