package alex.com.challenges.common

/**
 * Created by Alex Doub on 2/28/2020.
 */

class ListNode(var `val`: Int) {
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