package alex.com.challenges.dynamic

import kotlin.math.abs

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
            if (false) println(string)
        }

        //Third solution
        // Correct? but fails on massive input...
        fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {

            // Make list of safe nodes
            val safeNodeList = HashMap<Int, Boolean>()

            //Enumerate nodes
            // 1) Recursively get all possible visitable nodes.
            // 2) If it ever points back to start, fail this node
            graph.forEachIndexed { startingNode, paths ->

                debugPrint("Checking node: ${startingNode}")

                // Maintain list of visited nodes to prevent re-checking
                val visitedNodes = mutableSetOf<Int>()
                visitedNodes.add(startingNode)

                // Maintain list of nodes to visit. base: this nodes paths
                val nodesToVisit = mutableSetOf<Int>()
                nodesToVisit.addAll(paths.toTypedArray())

                // Enumerate paths until all nodes are visited & their paths are checked
                var nodeIsSafe = true
                while (nodesToVisit.isNotEmpty() && nodeIsSafe) {
                    val visitedNode = nodesToVisit.first()
                    visitedNodes.add(visitedNode)
                    nodesToVisit.remove(visitedNode)
                    val visitedNodePath = graph[visitedNode]

                    for (path in visitedNodePath) {
                        if (path == startingNode) {
                            nodeIsSafe = false
                            debugPrint(".... ${visitedNode} points back to start. Marking unsafe")
                        } else if (!visitedNodes.contains(path)) {
                            nodesToVisit.add(path)
                            debugPrint(".... ${visitedNode} has new path ${path}")
                        }
                    }
                }

                safeNodeList[startingNode] = nodeIsSafe
            }


            // Now that we know which nodes can double back, see if any of our nodes point to them
            // If they do, they aren't safe
            var didChange = true
            while (didChange) {
                didChange = false

                debugPrint("Doing final iteration")
                safeNodeList.filter { it.value == true }.forEach {
                    val safeNodePaths = graph[it.key]
                    val nodePointsToUnsafe = safeNodePaths.any { safeNodeList[it] == false }
                    if (nodePointsToUnsafe) {
                        safeNodeList[it.key] = false
                        debugPrint(".... ${it.key} points to a bad node, marking it unsafe")
                        didChange = true
                    } else {
                        debugPrint(".... ${it.key} is safe!")
                    }
                }
            }

            return graph.withIndex().filter { safeNodeList[it.index] == true }.map { it.index }
        }

        //Second solution: will not pass any node that loops
        // Fails because it doesn't properly detect inner loops
        fun eventualSafeNodes_OUTWARD_ITERATION(graph: Array<IntArray>): List<Int> {
            val safeNodeList = HashMap<Int, Boolean>()

            graph.forEachIndexed { index, ints ->

                // Maintain a list of visited nodes & nodes to check
                val visitedNodes = BooleanArray(graph.size) { false }

                val nodesToCheck = mutableSetOf<Int>()
                nodesToCheck.add(index)

                debugPrint("Processing Node #$index. Initial NodesToCheck:${nodesToCheck.joinToString()}")
                var nodeIsSafe = true
                while (nodesToCheck.isNotEmpty() && nodeIsSafe) {

                    //get closest index, not least index
                    // -2 -1 0 1 2
                    val indexesByDistance = nodesToCheck.sortedBy { x -> abs(index - x) }
                    val nodeToCheck = indexesByDistance.first()
                    debugPrint("... indexesToCheck: ${nodesToCheck.joinToString()}")
                    debugPrint("... indexesByDistance: ${indexesByDistance.joinToString()}")
                    debugPrint("... checking $nodeToCheck")
                    nodesToCheck.remove(nodeToCheck)

                    if (visitedNodes[nodeToCheck]) {
                        nodeIsSafe = false
                        debugPrint(".... double back found. Marking unsafe")
                        break
                    }
                    visitedNodes[nodeToCheck] = true

                    graph[nodeToCheck].forEach {

                        if (safeNodeList[it] == false) {
                            // This paths to an unsafe node, thus this node isnt safe
                            nodeIsSafe = false
                            debugPrint(".... leads to $it which is already unsafe")
                        } else {
                            // Add its path to our list
                            val newNodesToCheck = graph[it].toTypedArray()
                            debugPrint(".... leads to node ${it} with path: ${newNodesToCheck.joinToString()}")
                            nodesToCheck.addAll(newNodesToCheck)
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
        // This approach returns any nodes that CAN reach a terminal state
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
                        if (paths.any { safeNodeList[it] == true }) {
                            safeNodeList[indexedValue.index] = true
                            didChange = true
                            println("Node #${indexedValue.index} now marked as safe")
                        }
                    }

                debugPrint(safeNodeList.joinToString())
            }

            val indexOfSafeNodes =
                safeNodeList.withIndex().filter { it.value == true }.map { it.index }
            return indexOfSafeNodes
        }
    }
}

// do nodes to visit in order, only marking them visited IN ORDER. that way you'll know if it doubles back