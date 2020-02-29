package alex.com.challenges

import alex.com.challenges.common.ListNode

/**
 * Created by Alex Doub on 2/28/2020.
 */

object ReverseLinkedList {
    fun reverseList(initialHead: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = initialHead
        var next = current?.next

        while (next != null) {
            // Move next
            next = current?.next;

            // Swap
            current?.next = prev;

            //Advance
            prev = current;
            current = next;
        }

        return current
    }


    fun reverseList1(initialHead: ListNode?): ListNode? {

        // Enumerate list. On each, hotswap
        var head = initialHead
        var next = head?.next
        head?.next = null   // null out head

        while (next != null) {
            //store tmp
            val newNext = next.next

            //swap
            next.next = head

            //advance
            head = next
            next = newNext
        }

        return head
    }
}