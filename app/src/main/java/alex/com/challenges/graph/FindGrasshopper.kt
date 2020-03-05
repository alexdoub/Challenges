package alex.com.challenges.graph

/**
 * Created by Alex Doub on 1/31/2020.
 * https://leetcode.com/discuss/interview-question/494186/google-onsite-grasshopper-position
 */


open class Node {
    var left: Node? = null
    var right: Node? = null
    var probability: Double? = null
}

class FindGrasshopper {
    companion object {
        fun find1(startingNode: Node, hopsLeft: Int): List<Node> {
            fun getNodesAfterHops(probability: Double, initialNodes: List<Node>, hopsLeft: Int): List<Node> {
                if (hopsLeft == 0) {
                    // assign probabilities & return
                    initialNodes.forEach { it.probability = probability }
                    return initialNodes
                }

                // Recursive loop: List of nodes -> list of hopped nodes
                val newNodes = initialNodes.flatMap { listOfNotNull(it.left, it.right) }
                return getNodesAfterHops(probability / newNodes.size, newNodes, hopsLeft - 1)
            }

            return getNodesAfterHops(1.0, listOf(startingNode), hopsLeft)
        }

        fun find2(startingNode: Node, hopsLeft: Int): List<Node> {
            val nodesWithProbabilities =
                find1(startingNode, hopsLeft)

            // We have a list of nodes with assigned probabilities. This includes duplicates.
            return nodesWithProbabilities
                    // Group same objects together
                .groupBy { it }
                    // Get sum, replace this list with a single updated node
                .map {
                    val sum = it.value.sumByDouble { it.probability!! }
                    val first = it.value.first()
                    first.probability = sum
                    first
                }
        }
    }
}
