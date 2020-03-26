package alex.com.challenges.linkedlist

import alex.com.challenges.common.ListNode

/**
 * Created by Alex Doub on 3/26/2020.
 * https://leetcode.com/problems/odd-even-linked-list/
 */

object EvenOddLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        var oddTail = head ?: return null
        var evenTail = head.next ?: return head
        var tail = evenTail.next

        var isOdd = true

        // constants
        val oddHead = oddTail
        val evenHead = evenTail

        while (tail != null) {
            if (isOdd) {
                oddTail.next = tail
                oddTail = tail
            } else {
                evenTail.next = tail
                evenTail = tail
            }
            tail = tail.next
            isOdd = !isOdd
        }
        evenTail.next = null    //must null out even tail or it may still point to something
        oddTail.next = evenHead
        return oddHead
    }
}