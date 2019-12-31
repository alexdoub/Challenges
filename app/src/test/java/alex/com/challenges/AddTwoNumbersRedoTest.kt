package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class AddTwoNumbersRedoTest {

    @Test
    fun test_basic() {
        val left= listOf(2,4,3).toListNode()
        val right = listOf(5,6,4).toListNode()
        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        // Check input parsing
        assertEquals(2, left!!.`val`)
        assertEquals(4, left!!.next!!.`val`)
        assertEquals(3, left!!.next!!.next!!.`val`)

        // Check sum
        assertEquals(7, sum!!.`val`)
        assertEquals(0, sum!!.next!!.`val`)
        assertEquals(8, sum!!.next!!.next!!.`val`)

        assertEquals("807", sum!!.toProperString())
        assertEquals(listOf(7,0,8), sum!!.toList())
    }

    //[9]
    //[1,9,9,9,9,9,9,9,9,9]
    //aka 999999991 + 9
    @Test
    fun test2() {
        val left= listOf(9).toListNode()
        val right = listOf(1,9,9,9,9,9,9,9,9,9).toListNode()

        assertEquals(1, right!!.`val`)

        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        assertEquals(listOf(0,0,0,0,0,0,0,0,0,0,1), sum!!.toList())
    }

    @Test
    fun test3_overflow() {
        val left = listOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1).toListNode()
        val right = listOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1).toListNode()

        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        assertEquals(listOf(2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2), sum!!.toList())
    }

    //2,4,3 = 342
    private fun List<Int>.toListNode(): AddTwoNumbersRedo.ListNode? {
        var head: AddTwoNumbersRedo.ListNode? = null
        reversed().forEach {
            val node = AddTwoNumbersRedo.ListNode(it)
            node.next = head
            head = node
        }
        return head
    }
}