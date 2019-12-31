package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class AddTwoNumbersTest {
    @Test
    fun testAddTwoNumber1() {
        // Test 5 + 5
        val left = AddTwoNumbersRedo.ListNode(5)
        val right = AddTwoNumbersRedo.ListNode(5)
        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        assertEquals("10", sum!!.toProperString())
    }

    @Test
    fun testAddTwoNumber2() {
        // Test 199 + 1 = 200
        val left = AddTwoNumbersRedo.ListNode(9)
        left!!.next = AddTwoNumbersRedo.ListNode(9)
        left!!.next!!.next = AddTwoNumbersRedo.ListNode(1)

        val right = AddTwoNumbersRedo.ListNode(1)
        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        assertEquals("200", sum!!.toProperString())
    }

    @Test
    fun testAddTwoNumber3() {
        // Test 999 + 1 = 1000
        val left = AddTwoNumbersRedo.ListNode(9)
        left!!.next = AddTwoNumbersRedo.ListNode(9)
        left!!.next!!.next = AddTwoNumbersRedo.ListNode(9)

        val right = AddTwoNumbersRedo.ListNode(1)
        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        assertEquals("1000", sum!!.toProperString())
    }

    @Test
    fun testAddTwoNumber31() {
        // Test 999 + 1 = 1000
        val left = AddTwoNumbersRedo.ListNode(1)
        left!!.next = AddTwoNumbersRedo.ListNode(2)
        left!!.next!!.next = AddTwoNumbersRedo.ListNode(3)
        left!!.next!!.next!!.next = AddTwoNumbersRedo.ListNode(4)
        left!!.next!!.next!!.next!!.next = AddTwoNumbersRedo.ListNode(5)

        val right = AddTwoNumbersRedo.ListNode(1)
        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        assertEquals("54322", sum!!.toProperString())
    }


    @Test
    fun testAddTwoNumber4_inHouse() {
        // Test 999 + 1 = 1000
        val left = AddTwoNumbersRedo.ListNode(2)
        left.next = AddTwoNumbersRedo.ListNode(4)
        left.next!!.next = AddTwoNumbersRedo.ListNode(3)

        val right = AddTwoNumbersRedo.ListNode(5)
        right.next = AddTwoNumbersRedo.ListNode(6)
        right.next!!.next = AddTwoNumbersRedo.ListNode(4)
        val sum = AddTwoNumbersRedo.addTwoNumbers(left, right)

        assertEquals("807", sum!!.toProperString())
    }
}