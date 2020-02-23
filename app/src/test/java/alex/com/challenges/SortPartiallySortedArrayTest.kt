package alex.com.challenges

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by Alex Doub on 2/22/2020.
 */

class SortPartiallySortedArrayTest {
    @Test
    fun test1() {
        val input = intArrayOf(0, 15, 12, 17, 18, 19, 33, 32)
        val output = SortPartiallySortedArray.bucketSort16Bits(input)
        assertTrue(output.isSorted())
    }

    @Test
    fun test2() {
        val input = intArrayOf(100207, 100205, 100204, 100206, 100203)
        val output = SortPartiallySortedArray.bucketSort16Bits(input)
        assertTrue(output.isSorted())
    }

    private fun IntArray.isSorted(): Boolean {
        if (isEmpty()) {
            return true
        }
        var prev = this[0]

        for (x in this) {
            if (x < prev) return false
            else prev = x
        }
        return true
    }
}