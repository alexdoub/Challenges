package alex.com.challenges.linkedlist

import alex.com.challenges.common.ListNode

/**
 * Created by Alex Doub on 3/14/2020.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

object RemoveDuplicatesFromLinkedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null
        var tail = head
        var lastVal = head.`val`


        // Main loop
        while (tail != null) {
            var next = tail.next

            //Next loop - skip duplicates
            while (next != null && next.`val` == lastVal) {
                next = next.next
            }
            tail.next = next
            tail = tail.next

            if (tail != null) {
                lastVal = tail.`val`
            }

        }
        return head
    }
}