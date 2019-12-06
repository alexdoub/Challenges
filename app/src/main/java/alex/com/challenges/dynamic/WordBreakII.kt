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
            val nodes = HashMap<Int, Node>()
            nodes[-1] = Node(ArrayList(), "")

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

//                if (index == 3) {
//                    println("!!")
//                }


                //Find any nodes we can build off of or prune
                val pruneList = ArrayList<Int>()
                val addList = ArrayList<Pair<String, Node>>()
                for (nodeEntry in nodes) {
                    // Only check nodes 'behind' this index
                    if (nodeEntry.key < index) {
                        val length = index - nodeEntry.key

                        //There are words to check that continue this
                        wordsByLength[length]?.let { wordsToCheck ->
                            val thatSubstring: String = sentence.substring(nodeEntry.key+1, nodeEntry.key + length + 1)
                            if (wordsToCheck.contains(thatSubstring)) {

                                //append to existing node or create new node if doesnt exist
                                addList.add(Pair(thatSubstring, nodeEntry.value))

                                debugPrint("... found ${thatSubstring}. Added to node at ${index}")
                            }
                        }
                    }

                    //Prune nodes that can no longer be reached
                    if (nodeEntry.key + maxLengthWord < index) {
                        pruneList.add(nodeEntry.key)
                    }
                }

                for (pruneIndex in pruneList) {
                    nodes.remove(index)
                    debugPrint("... pruned node at ${pruneIndex}")
                }
                for (pair in addList) {
                    if (nodes[index] == null) {
                        nodes[index] = Node(ArrayList(), thatSubstring)
                    }
                    nodes[index]!!.prevNodes.add(nodeEntry.value)
                }
            }

            //DFS backwards from END of nodes, build solution
            val finalNode = nodes[sentence.length]
            finalNode?.let {
                debugPrint("Found final node")
                return emptyList()
            } ?: run {
                debugPrint("No final node")
                return emptyList()
            }
        }

        private class Node(val prevNodes: ArrayList<Node>, val word: String)
    }
}