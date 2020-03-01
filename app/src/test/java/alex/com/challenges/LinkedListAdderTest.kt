package alex.com.challenges

import alex.com.challenges.common.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class LinkedListAdderTest {
    @Test
    fun testAddTwoNumber1() {
        // Test 5 + 5
        val left = ListNode(5)
        val right = ListNode(5)
        val sum = LinkedListAdderRedo.addTwoNumbers(left, right)

        assertEquals("10", sum!!.toProperString())
    }

    @Test
    fun testAddTwoNumber2() {
        // Test 199 + 1 = 200
        val left = ListNode(9)
        left!!.next = ListNode(9)
        left!!.next!!.next = ListNode(1)

        val right = ListNode(1)
        val sum = LinkedListAdderRedo.addTwoNumbers(left, right)

        assertEquals("200", sum!!.toProperString())
    }

    @Test
    fun testAddTwoNumber3() {
        // Test 999 + 1 = 1000
        val left = ListNode(9)
        left!!.next = ListNode(9)
        left!!.next!!.next = ListNode(9)

        val right = ListNode(1)
        val sum = LinkedListAdderRedo.addTwoNumbers(left, right)

        assertEquals("1000", sum!!.toProperString())
    }

    @Test
    fun testAddTwoNumber31() {
        // Test 999 + 1 = 1000
        val left = ListNode(1)
        left!!.next = ListNode(2)
        left!!.next!!.next = ListNode(3)
        left!!.next!!.next!!.next = ListNode(4)
        left!!.next!!.next!!.next!!.next = ListNode(5)

        val right = ListNode(1)
        val sum = LinkedListAdderRedo.addTwoNumbers(left, right)

        assertEquals("54322", sum!!.toProperString())
    }


    @Test
    fun testAddTwoNumber4_inHouse() {
        // Test 999 + 1 = 1000
        val left = ListNode(2)
        left.next = ListNode(4)
        left.next!!.next = ListNode(3)

        val right = ListNode(5)
        right.next = ListNode(6)
        right.next!!.next = ListNode(4)
        val sum = LinkedListAdderRedo.addTwoNumbers(left, right)

        assertEquals("807", sum!!.toProperString())
    }
}