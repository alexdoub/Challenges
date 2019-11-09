package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class LightsOutTest {
    @Test
    fun test1() {
        val data = arrayOf(
            arrayOf(0, 0, 0).toIntArray(),
            arrayOf(0, 0, 0).toIntArray(),
            arrayOf(0, 0, 0).toIntArray()
        )

        val result = LightsOut.solve(data.toBooleanArrayy())
        assertEquals(0, result)
    }

    @Test
    fun test2() {
        val data = arrayOf(
            arrayOf(0, 1, 0).toIntArray(),
            arrayOf(1, 1, 1).toIntArray(),
            arrayOf(0, 1, 0).toIntArray()
        )

        val result = LightsOut.solve(data.toBooleanArrayy())
        assertEquals(1, result)
    }

    @Test
    fun test3() {
        val data = arrayOf(
            arrayOf(1, 1, 0).toIntArray(),
            arrayOf(1, 0, 1).toIntArray(),
            arrayOf(0, 1, 1).toIntArray()
        )

        val result = LightsOut.solve(data.toBooleanArrayy())
        assertEquals(2, result)
    }


    @Test
    fun test4() {
        val data = arrayOf(
            arrayOf(1, 0, 1).toIntArray(),
            arrayOf(0, 0, 0).toIntArray(),
            arrayOf(1, 0, 1).toIntArray()
        )

        val result = LightsOut.solve(data.toBooleanArrayy())
        assertEquals(4, result)
    }

    private fun Array<IntArray>.toBooleanArrayy(): Array<BooleanArray> {
        return this.map { it.toBooleanArrayy() }.toTypedArray()
    }

    private fun IntArray.toBooleanArrayy(): BooleanArray {
        return this.map { value ->
            if (value == 1) {
                true
            } else {
                false
            }
        }
            .toTypedArray()
            .toBooleanArray()
    }
}
