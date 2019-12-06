package alex.com.challenges.dynamic

/**
 * Created by Alex Doub on 12/5/2019.
 * https://leetcode.com/problems/word-break-ii/
 */

class WordBreakII {
    companion object {
        private fun debugPrint(string: String) {
            if (true) println(string)
        }

        fun wordBreak(sentence: String, words: List<String>): List<String> {
            return wordBreak_BFS(sentence, words)
        }

        fun wordBreak_BFS(sentence: String, words: List<String>): List<String> {
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
            val maxLengthWord = wordsByLength.keys.max()!!

            // Build solution
            // Iterate along, try to build nodes that branch from previous nodes
            sentence.forEachIndexed { index, char ->
                debugPrint("Index: ${index}")

                //Find any nodes we can build off of or prune
                val pruneList = ArrayList<Int>()
                val nodesToAdd = ArrayList<Node>()

                for (nodeEntry in nodes) {
                    // Only check nodes 'behind' this index
                    if (nodeEntry.key < index) {
                        val length = index - nodeEntry.key

                        //There are words to check that continue this
                        wordsByLength[length]?.let { wordsToCheck ->
                            val thatSubstring: String = sentence.substring(nodeEntry.key+1, nodeEntry.key + length + 1)
                            if (wordsToCheck.contains(thatSubstring)) {

                                //append to existing node or create new node if doesnt exist
                                //@@@PULL, NOT PUSH
                                val prev = nodes[nodeEntry.key]!!
                                nodesToAdd.add(Node(prev, thatSubstring))

                                debugPrint("... found ${thatSubstring}. Added to node at ${index}. Extended off ${prev.size}")
                            }
                        }
                    }

                    //Prune nodes that can no longer be reached
                    if (nodeEntry.key + maxLengthWord < index) {
                        pruneList.add(nodeEntry.key)
                    }
                }

                for (pruneIndex in pruneList) {
                    debugPrint("... pruning node at ${pruneIndex}")
                    nodes.remove(pruneIndex)
                }

                nodes[index] = nodesToAdd
            }

            //DFS backwards from END of nodes, build solution
            val finalNode = nodes[sentence.length - 1]
            finalNode?.let {
                debugPrint("Found final node")
                val sentences = getAllSentences(it)
                return sentences
            } ?: run {
                debugPrint("No final node")
                return emptyList()
            }
        }

        private fun getAllSentences(nodes: List<Node>): List<String> {
            debugPrint(".. getting ALL sentences from node: ${nodes.size} children")
            val sentences = ArrayList<String>()

            if (nodes.isEmpty()) {
                return listOf("")
            }

            nodes.forEach { node ->
                debugPrint(".. getting ALL sentences from node: ${node.word}")
                sentences.addAll(getAllSentences(node.prevNodes).map { it + " ${node.word}" })
            }
            return sentences
        }

        //recursive
//        private fun getSentences(node: Node): List<String> {
//            val sentences = ArrayList<String>()
//
//            //Dont do empty check. Final node is empty space anyway
//            node.prevNodes.map {
//                val prevSentences = getAllSentences(it.prevNodes)
////                val thisSentences = prevSentences.map { it + " ${node.word}" }
//                sentences.addAll(prevSentences)
//            }
//            return sentences
//        }

        private class Node(val prevNodes: List<Node>, val word: String)
    }
}