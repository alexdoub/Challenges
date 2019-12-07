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

        //Complexity Analysis
        //Time:
            //Buildup: W
            //Iterate: 1/2 S^3 (Enumerates S, S nodes per index, checks S nodes)
            //Search: S^2
        //Space:
            //Buildup: W
            //Iterate: S^2 Nodes + S (add) + S (prune)
            //Search: S^2 * W

        fun wordBreak(sentence: String, words: List<String>): List<String> {
            //Map indexes to nodes (+1 to account for base state)
            // NODES = WORKING SPACE, PRUNE AS YOU GO. CHECK FROM THIS
            val nodes = HashMap<Int, List<Node>>()
            nodes[-1] = listOf(Node(ArrayList(), ""))

            val wordsByLength = HashMap<Int, HashSet<String>>()
            var maxLengthWord = 0
            words.forEach {
                val key = it.length
                if (wordsByLength[key] == null) {
                    wordsByLength[key] = HashSet()
                }
                wordsByLength[key]!!.add(it)

                if (it.length > maxLengthWord) {
                    maxLengthWord = it.length
                }
            }
            if (maxLengthWord == 0) {
                return emptyList()
            }

            // Build solution
            // Iterate along, try to build nodes that branch from previous nodes
            sentence.forEachIndexed { index, char ->
                debugPrint("Index: ${index}")

                //Find any nodes we can build off of or prune
                val pruneList = ArrayList<Int>()
                val nodesToAdd = ArrayList<Node>()

                for (indexedNode in nodes) {
                    // Only check nodes 'behind' this index
                    if (indexedNode.key < index) {
                        val length = index - indexedNode.key

                        //There are words to check that continue this
                        wordsByLength[length]?.let { wordsToCheck ->
                            val thatSubstring: String = sentence.substring(indexedNode.key + 1, indexedNode.key + length + 1)
                            if (wordsToCheck.contains(thatSubstring)) {

                                //append to existing node or create new node if doesnt exist
                                // PULL VALUES FROM PREV, DONT PUSH
                                val prev = nodes[indexedNode.key]!!
                                nodesToAdd.add(Node(prev, thatSubstring))

                                debugPrint("... found ${thatSubstring}. Added to node at ${index}. Extended off ${prev.size}")
                            }
                        }
                    }

                    //Prune nodes that can no longer be reached
                    if (indexedNode.key + maxLengthWord < index) {
                        pruneList.add(indexedNode.key)
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
                val sentenceBuilders = getBuiltSentences(finalNode)
                debugPrint("-----")
                debugPrint(sentenceBuilders.joinToString(separator = "\n"))
                val builtSentences = sentenceBuilders.map { it.toString() }
                return builtSentences
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