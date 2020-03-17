package alex.com.challenges.graph

import java.util.Collections.emptyList

/**
 * Created by Alex Doub on 3/4/2020.
 * https://leetcode.com/problems/find-eventual-safe-states/
 */

object FindEventualSafeStates2 {
    val UNCHECKED = 0
    val SAFE = 1
    val UNSAFE = 2

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val states = IntArray(graph.size)

        // Recursively explore nodes connected to this node
        // Return T if its safe, F if its unsafe
        // Pass in list of visited nodes to detect loops
        fun explore_dfs(x: Int, visited: List<Int>): Boolean {
            if (states[x] == UNCHECKED) {
                val destinations = graph[x]

                // Check if loop found
                if (destinations.any { visited.contains(it) }) {
                    states[x] = UNSAFE
                } else {
                    val thisIsSafe = destinations.all { explore_dfs(it, visited + x) }
                    if (thisIsSafe) {
                        states[x] = SAFE
                    } else {
                        states[x] = UNSAFE
                    }
                }
            }

            return states[x] == SAFE
        }

        // Explore all nodes
        for (x in graph.indices) {
            explore_dfs(x, emptyList())
        }

        // Return safe node indexes
        return graph.indices.filter { states[it] == SAFE }
    }
}