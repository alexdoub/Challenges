package alex.com.challenges.linkedlist

import alex.com.challenges.common.ListNode

/**
 * Created by Alex Doub on 2/28/2020.
 *
 * NOTE: Its easier to loop about 'current', not 'next != null'
 */

object ReverseLinkedList {

    fun reverseList(head: ListNode?): ListNode? {

        var prev: ListNode? = null
        var current:ListNode? = head
        while (current != null) {

            // Store next BEFORE swap
            val next = current.next

            // Switch direction of tail
            current.next = prev

            // Advance Prev THEN tail
            prev = current
            current = next
        }

        return prev
    }



    // ran into issues... would not recommend
//    fun reverseList_FAILURE(head: ListNode?): ListNode? {
//        if (head == null) return head
//
//        var prev: ListNode? = null
//        var tail = head!!
//        var next: ListNode? = tail.next
//        while (next != null) {
//            //set up next next
//            val newNext = tail.next
//
//            // T -> P
//            tail.next = prev
//
//            // Prev IS tail
//            prev = tail
//
//            // Tail IS next
//            tail = next
//
//            // Set next
//            next = newNext
//        }
//        tail.next = prev
//
//
//        return tail
//    }

//    // WORKS
//    fun reverseList(initialHead: ListNode?): ListNode? {
//        var prev: ListNode? = null
//        var current = initialHead
//        var next: ListNode? = null
//
//        while (current != null) {
//            // Move next
//            next = current.next
//
//            // Swap
//            current.next = prev
//
//            //Advance
//            prev = current
//            current = next
//        }
//
//        return prev
//    }
//
//
//    // WORKS
//    fun reverseList1(initialHead: ListNode?): ListNode? {
//
//        // Enumerate list. On each, hotswap
//        var head = initialHead
//        var next = head?.next
//        head?.next = null   // null out head
//
//        while (next != null) {
//            //store tmp
//            val newNext = next.next
//
//            //swap
//            next.next = head
//
//            //advance
//            head = next
//            next = newNext
//        }
//
//        return head
//    }
}