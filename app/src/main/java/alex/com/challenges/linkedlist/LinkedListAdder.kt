package alex.com.challenges.linkedlist

import alex.com.challenges.common.ListNode

//https://leetcode.com/problems/add-two-numbers/
class LinkedListAdder {

    companion object {

        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

            var left: ListNode? = l1!!
            var right: ListNode? = l2!!
            var head: ListNode? = null
            var created: ListNode? = null
            var carry = false

            while (left != null || right != null || carry) {

                // Calculate new `val`
                var thisVal = (left?.`val` ?: 0) + (right?.`val` ?: 0) + if (carry) 1 else 0

                // handle carry
                carry = thisVal >= 10
                if (thisVal >= 10) thisVal -= 10


                // Create node and mark head OR link to previous
                val newNode = ListNode(thisVal)
                if (head == null) {
                    head = newNode
                }
                created?.next = newNode

                // Advance
                created = newNode
                left = left?.next
                right = right?.next
            }

            return head
        }
    }

}