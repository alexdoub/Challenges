package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/29/2020.
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * This supports a single char wildcard of '.'.
 * Hardmode: What if it supported multichar wildcard of '*'? Answer; It would change to DFS to filter values before search space is joined.
 */


object TrieWithWildcards {

    class WordDictionary() {

        class Node(
            var isWord: Boolean = false,
            val next: HashMap<Char, Node> = HashMap()
        )

        private val root = Node()

        fun addWord(word: String) {
            var current = root
            for (c in word) {
                if (current.next[c] == null) {
                    current.next[c] = Node()
                }
                current = current.next[c]!!
            }
            current.isWord = true
        }

        // Map approach
        fun search(word: String): Boolean {
            // Start at root. This can branch to many nodes so it must be a list
            var nodes: List<Node> = listOf(root)
            for (c in word) {

                // Map next values
                nodes = if (c == '.') {
                    nodes.map { it.next.values }.flatten()   //map{}.flatten() is much more performant than flatMap{}
                } else {
                    nodes.mapNotNull { it.next[c] }
                }

                if (nodes.isEmpty()) return false
            }
            return nodes.any { it.isWord }
        }

        // Looks concise but MUCH slower & higher mem for some reason
        fun search_fold(word: String) =
            word.fold(listOf(root), { nodes, c ->
                if (nodes.isEmpty()) return false
                if (c == '.') {
                    nodes.map { it.next.values }.flatten()
                } else {
                    nodes.mapNotNull { it.next[c] }
                }
            }).any { it.isWord }
    }
}