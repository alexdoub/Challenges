package alex.com.challenges

import alex.com.challenges.AddTwoNumbers.Companion.addTwoNumbers
import org.junit.Test

class AddTwoNumbersTest {
    @Test
    fun testAddTwoNumber1() {
        // Test 5 + 5
        val left = AddTwoNumbers.ListNode(5)
        val right = AddTwoNumbers.ListNode(5)
        val sum = addTwoNumbers(left, right)

        assert(sum!!.toProperString() == "10")
    }

    @Test
    fun testAddTwoNumber2() {
        // Test 199 + 1 = 200
        val left = AddTwoNumbers.ListNode(9)
        left!!.next = AddTwoNumbers.ListNode(9)
        left!!.next!!.next = AddTwoNumbers.ListNode(1)

        val right = AddTwoNumbers.ListNode(1)
        val sum = addTwoNumbers(left, right)

        assert(sum!!.toProperString() == "200")
    }

    @Test
    fun testAddTwoNumber3() {
        // Test 999 + 1 = 1000
        val left = AddTwoNumbers.ListNode(9)
        left!!.next = AddTwoNumbers.ListNode(9)
        left!!.next!!.next = AddTwoNumbers.ListNode(9)

        val right = AddTwoNumbers.ListNode(1)
        val sum = addTwoNumbers(left, right)

        assert(sum!!.toProperString() == "1000")
    }
}