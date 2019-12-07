package alex.com.challenges.dynamic

import java.lang.StringBuilder

/**
 * Created by Alex Doub on 12/5/2019.
 * https://leetcode.com/problems/word-break-ii/
 */

class WordBreakII {
    companion object {
        private fun debugPrint(string: String) {
            if (false) println(string)
        }

        fun wordBreak(sentence: String, words: List<String>): List<String> {
            //Map indexes to nodes (+1 to account for base state)
            // NODES = WORKING SPACE, PRUNE AS YOU GO. CHECK FROM THIS
            val nodes = HashMap<Int, List<Node>>()
            nodes[-1] = listOf(Node(ArrayList(), ""))

            val wordsByLength = HashMap<Int, HashSet<String>>()
            words.forEach {
                val key = it.length
                if (wordsByLength[key] == null) {
                    wordsByLength[key] = HashSet()
                }
                wordsByLength[key]!!.add(it)
            }
            val maxLengthWord = wordsByLength.keys.max() ?: return emptyList()

            // Build solution
            // Iterate along, try to build nodes that branch from previous nodes
            sentence.forEachIndexed { index, char ->
                debugPrint("Index: ${index}")

                //Find any nodes we can build off of or prune
                val pruneList = ArrayList<Int>()
                val nodesToAdd = ArrayList<Node>()

                for (nodesAtIndex in nodes) {
                    // Only check nodes 'behind' this index
                    if (nodesAtIndex.key < index) {
                        val length = index - nodesAtIndex.key

                        //There are words to check that continue this
                        wordsByLength[length]?.let { wordsToCheck ->
                            val thatSubstring: String = sentence.substring(nodesAtIndex.key + 1, nodesAtIndex.key + length + 1)
                            if (wordsToCheck.contains(thatSubstring)) {

                                //append to existing node or create new node if doesnt exist
                                // PULL VALUES FROM PREV, DONT PUSH
                                val prev = nodes[nodesAtIndex.key]!!
                                nodesToAdd.add(Node(prev, thatSubstring))

                                debugPrint("... found ${thatSubstring}. Added to node at ${index}. Extended off ${prev.size}")
                            }
                        }
                    }

                    //Prune nodes that can no longer be reached
                    if (nodesAtIndex.key + maxLengthWord < index) {
                        pruneList.add(nodesAtIndex.key)
                    }
                }

                for (pruneIndex in pruneList) {
                    debugPrint("... pruning node at ${pruneIndex}")
                    nodes.remove(pruneIndex)
                }

                if (nodesToAdd.isNotEmpty()) {
                    nodes[index] = nodesToAdd
                }
            }

            //DFS backwards from END of nodes, build solution
            val finalNode = nodes[sentence.length - 1]
            finalNode?.let { finalNode ->
                debugPrint("Found final node")
                val builtSentences = getBuiltSentences(finalNode)
                debugPrint("-----")
                debugPrint(builtSentences.joinToString(separator = "\n"))
                return builtSentences.map { it.toString() }
            } ?: run {
                debugPrint("No final node")
                return emptyList()
            }
        }

        private fun getBuiltSentences(nodes: List<Node>): List<StringBuilder> {
            debugPrint(".. getting ALL sentences from node: ${nodes.size} children")
            val sentences = ArrayList<StringBuilder>()

            if (nodes.isEmpty()) {
                sentences.add(StringBuilder())
            } else {
                nodes.forEach { node ->
                    debugPrint(".. getting ALL sentences from node: ${node.word}")
                    sentences.addAll(getBuiltSentences(node.prevNodes).map { sb ->
                        if (sb.isNotBlank()) {
                            sb.append(" ${node.word}")
                        } else {
                            sb.append(node.word)
                        }
                        sb
                    })
                }
            }

            return sentences
        }

        private class Node(val prevNodes: List<Node>, val word: String)
    }
}