package alex.com.challenges

import alex.com.challenges.LinkedListAdder.Companion.addTwoNumbers
import org.junit.Test

class LinkedListAdderTest {
    @Test
    fun testAddTwoNumber1() {
        // Test 5 + 5
        val left = LinkedListAdder.ListNode(5)
        val right = LinkedListAdder.ListNode(5)
        val sum = addTwoNumbers(left, right)

        assert(sum!!.toProperString() == "10")
    }

    @Test
    fun testAddTwoNumber2() {
        // Test 199 + 1 = 200
        val left = LinkedListAdder.ListNode(9)
        left!!.next = LinkedListAdder.ListNode(9)
        left!!.next!!.next = LinkedListAdder.ListNode(1)

        val right = LinkedListAdder.ListNode(1)
        val sum = addTwoNumbers(left, right)

        assert(sum!!.toProperString() == "200")
    }

    @Test
    fun testAddTwoNumber3() {
        // Test 999 + 1 = 1000
        val left = LinkedListAdder.ListNode(9)
        left!!.next = LinkedListAdder.ListNode(9)
        left!!.next!!.next = LinkedListAdder.ListNode(9)

        val right = LinkedListAdder.ListNode(1)
        val sum = addTwoNumbers(left, right)

        assert(sum!!.toProperString() == "1000")
    }
}