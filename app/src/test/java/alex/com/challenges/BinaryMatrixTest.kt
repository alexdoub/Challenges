package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryMatrixTest {
    @Test
    fun test1() {

        val actual = BinaryMatrix.reconstructMatrix(2, 1, intArrayOf(1, 1, 1))
        val expected1 = listOf(listOf(1, 1, 0), listOf(0, 0, 1))
        val expected2 = listOf(listOf(1, 0, 1), listOf(0, 1, 0))
        val expected3 = listOf(listOf(1, 0, 0), listOf(1, 0, 0))

        assert(actual == expected1 || actual == expected2 || actual == expected3)
    }

    @Test
    fun test2() {
        assertEquals(listOf<List<Int>>(), BinaryMatrix.reconstructMatrix(2, 3, intArrayOf(2,2,1,1)))
    }

    @Test
    fun test3() {
        val expected = listOf(listOf(1,1,1,0,1,0,0,1,0,0), listOf(1,0,1,0,0,0,1,1,0,1))
        assertEquals(expected, BinaryMatrix.reconstructMatrix(5, 5, intArrayOf(2,1,2,0,1,0,1,2,0,1)))
    }
}