package alex.com.challenges

//https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        fun toProperString(): String {
            var item: ListNode? = this
            var printString = ""
            while (item != null) {
                printString += item.`val`
                item = item.next
            }

            return printString.reversed()
        }
    }

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