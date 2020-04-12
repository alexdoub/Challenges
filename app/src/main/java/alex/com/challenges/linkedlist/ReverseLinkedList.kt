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

    // WORKS
    // Note: if you run into crazy problems make sure you have the right thing set!!
    fun reverseList_not_best(head: ListNode?): ListNode? {
        if (head == null) return head

        var prev: ListNode? = null
        var tail: ListNode = head
        var next: ListNode? = tail.next
        while (next != null) {
            //set up next next
            val newNext = next.next //THIS LINE WAS tail.next WHICH WAS WRONG!!

            // T -> P
            tail.next = prev

            // Prev IS tail
            prev = tail

            // Tail IS next
            tail = next

            // Set next
            next = newNext
        }
        tail.next = prev
        return tail
    }

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