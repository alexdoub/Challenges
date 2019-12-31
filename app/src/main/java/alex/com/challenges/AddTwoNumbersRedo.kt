package alex.com.challenges

class AddTwoNumbersRedo {
    //Head low, Tail high
    //1 -> 2 -> 3 = 321
    companion object {
        fun addTwoNumbers(left: ListNode?, right: ListNode?): ListNode? {
            var thisLeft = left
            var thisRight = right
            var head: ListNode? = null
            var tail: ListNode? = null
            var carry = false

            while (thisLeft != null || thisRight != null || carry) {
                var thisSum = (thisLeft?.`val` ?: 0) + (thisRight?.`val` ?: 0) + if (carry) 1 else 0
                carry = false

                if (thisSum > 9) {
                    thisSum -= 10
                    carry = true
                }

                if (head == null) {
                    head = ListNode(thisSum)
                    tail = head
                } else {
                    val newNode = ListNode(thisSum)
                    tail!!.next = newNode
                    tail = newNode
                }

                thisLeft = thisLeft?.next
                thisRight = thisRight?.next
            }

            return head
        }
    }

    class ListNode(val `val`: Int) {
        var next: ListNode? = null
        fun toProperString(): String {
            var item: ListNode? = this
            var printString = StringBuilder()
            while (item != null) {
                printString.append(item.`val`)
                item = item.next
            }

            return printString.reverse().toString()
        }

        fun toList(): List<Int> {
            val values = mutableListOf<Int>()
            var head:ListNode? = this
            while (head != null) {
                values.add(head.`val`)
                head = head.next
            }
            return values
        }
    }
}
