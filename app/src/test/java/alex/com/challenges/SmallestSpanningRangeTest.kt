package alex.com.challenges

import org.junit.Test

/**
 * Created by Alex Doub on 11/26/2019.
 */

class SmallestSpanningRangeTest {
    @Test
    fun test1() {
        val input1 = intArrayOf(1, 10, 100)
        val input2 = intArrayOf(2, 20, 200)
        val input3 = intArrayOf(3, 30, 300)
        val inputSet = listOf(input1, input2, input3)
        val answer = SmallestSpanningRange.solve(inputSet)

        assert(input1.any { answer.contains(it) })
        assert(input2.any { answer.contains(it) })
        assert(input3.any { answer.contains(it) })

        assert(answer.contains(1))
        assert(answer.contains(2))
        assert(answer.contains(3))
    }

    @Test
    fun test2() {
        val input1 = intArrayOf(50, 150, 250)
        val input2 = intArrayOf(70, 140, 210)
        val input3 = intArrayOf(90, 145, 299)
        val input4 = intArrayOf(2, 20, 30, 139)
        val inputSet = listOf(input1, input2, input3, input4)
        val answer = SmallestSpanningRange.solve(inputSet)

        assert(input1.any { answer.contains(it) })
        assert(input2.any { answer.contains(it) })
        assert(input3.any { answer.contains(it) })
        assert(input4.any { answer.contains(it) })

        assert(answer.contains(150))
        assert(answer.contains(140))
        assert(answer.contains(145))
        assert(answer.contains(139))
    }
}