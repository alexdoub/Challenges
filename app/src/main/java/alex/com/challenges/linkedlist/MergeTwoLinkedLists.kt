package alex.com.challenges.linkedlist

import alex.com.challenges.common.ListNode

/**
 * Created by Alex Doub on 3/3/2020.
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

object MergeTwoLinkedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var leftHead = l1
        var rightHead = l2

        // Early return
        if (leftHead == null) {
            return rightHead
        }
        if (rightHead == null) {
            return leftHead
        }

        var head: ListNode? = null
        var tail: ListNode? = null

        // We have 2 heads, choose the best
        while (leftHead != null && rightHead != null) {

            // base case - set head
            // Only runs once
            if (head == null) {
                if (leftHead.`val` < rightHead.`val`) {
                    head = leftHead
                    leftHead = leftHead.next
                } else {
                    head = rightHead
                    rightHead = rightHead.next
                }
                tail = head
            } else {
                // Main loop1 - 2 possible heads
                if (leftHead.`val` < rightHead.`val`) {
                    tail!!.next = leftHead
                    leftHead = leftHead.next
                } else {
                    tail!!.next = rightHead
                    rightHead = rightHead.next
                }
                tail = tail.next
            }
        }

        // We must have a returnTail now

        // One head is null, append rest of the other
        while (leftHead != null) {
            // Main loop 2 - 1 possible head
            tail!!.next = leftHead
            leftHead = leftHead.next
            tail = tail!!.next
        }

        while (rightHead != null) {
            // Main loop 3 - 1 possible head
            tail!!.next = rightHead
            rightHead = rightHead.next
            tail = tail!!.next
        }

        // Done enumerating input
        tail!!.next = null
        return head
    }
}