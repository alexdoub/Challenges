package alex.com.challenges.linkedlist

import alex.com.challenges.common.ListNode

/**
 * Created by Alex Doub on 4/11/2020.
 * https://leetcode.com/problems/rotate-list/
 */

object RotateLinkedList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {

        //Loop thru and get length
        var count = 1
        var originalTail = head ?: return null
        while (originalTail.next != null) {
            count++
            originalTail = originalTail.next!!
        }
        // Decide depth of new head
        val depth = count - (k % count)

        // Early terminate if no rolling to do
        if (count == depth) return head

        // Iterate down to the new head. Store and null out the new tail (1 before newHead)
        var newHead = head
        for (x in 1 until depth) {
            newHead = newHead!!.next
        }
        val newTail = newHead
        newHead = newHead!!.next
        newTail!!.next = null

        // Append original head to original tail
        originalTail.next = head

        return newHead
    }
}