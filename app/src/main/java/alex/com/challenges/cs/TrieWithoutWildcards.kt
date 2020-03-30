package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/29/2020.
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

object TrieWithoutWildcards {
    class Trie() {

        /** Initialize your data structure here. */
        class Node(
            var isWord: Boolean = false,
            val next: HashMap<Char, Node> = HashMap()
        )

        private val root = Node()

        /** Inserts a word into the trie. */
        fun insert(word: String) {
            var current = root
            for (c in word) {
                if (current.next[c] == null) {
                    current.next[c] = Node()
                }
                current = current.next[c]!!
            }
            current.isWord = true
        }

        /** Returns if the word is in the trie. */
        fun search(word: String): Boolean {
            var node = root
            for (c in word) {
                node = node.next[c] ?: return false
            }
            return node.isWord
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        fun startsWith(prefix: String): Boolean {
            var node = root
            for (c in prefix) {
                node = node.next[c] ?: return false
            }
            return node.isWord || node.next.isNotEmpty()
        }

    }
}