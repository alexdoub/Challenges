package alex.com.challenges.cs

/**
 * Created by Alex Doub on 4/3/2020.
 *
 * NOTE: A LinkedHashSet could accomplish all of this
 */

class LRUCache(val capacity: Int) {

    private class Node(val key: Int? = null, val value: Int? = null, var prev: Node? = null, var next: Node? = null)

    private val map = HashMap<Int, Node>()
    private var size = 2

    private var head: Node = Node()
    private var tail: Node = Node()

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        map[key]?.let { node ->
            val value = node.value

            if (node == head) {
                //dont do anything
            } else {

                // Shorten tail
                if (node == tail) {
                    tail = node.prev!!
                    tail.next = null
                }

                // link prev & next
                node.prev!!.next = node.next
                node.next?.prev = node.prev

                //append head
                node.next = head
                head = node
                head.prev = null
                head.next!!.prev = head // THIS WAS THE LINE I MISSED, LAST HOOKUP
            }
            return value!!
        }
        return -1
    }

    fun put(key: Int, value: Int) {

        if (size < capacity) {
            //append to LL queue
            val newHead = Node(key = key, value = value, next = head)
            head.prev = newHead
            head = newHead
            map[key] = newHead
            size++
        } else {

            // remove tail from map
            tail.key?.let { thisKey ->
                map.remove(thisKey)
            }

            // push off tail
            tail = tail.prev!!
            tail.next = null

            //push down head
            val newHead = Node(key = key, value = value, next = head)
            head.prev = newHead
            head = newHead
            map[key] = newHead
        }
    }

}


class LRUCacheFromLHM(val capacity: Int) {
    val map = LinkedHashMap<Int, Int>()

    fun get(key: Int): Int {
        val value = map[key]

        if (value != null) {
            map.remove(key)
            map[key] = value
        }

        return value ?: -1
    }

    fun put(key: Int, value: Int) {

        map[key] = value

        while (map.size > capacity) {

            // this part is sketchy, cant guarantee constant time deletes
            map.remove(map.keys.first())
//            map.remove(map.entries.first().key)
        }
    }
}