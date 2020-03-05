package alex.com.challenges

import alex.com.challenges.dynamic.ShortestDistanceToChar
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 12/3/2019.
 */

class ShortestDistanceToCharTest {
    @Test
    fun test1() {
        val word = "google"
        val char = 'g'
        val expected = IntArray(word.length)
        expected[0] = 0
        expected[1] = 1
        expected[2] = 1
        expected[3] = 0
        expected[4] = 1
        expected[5] = 2

        val solution = ShortestDistanceToChar.shortestToChar2(word, char)
        expected.forEachIndexed { index, i ->
            assertEquals(i, solution[index])
        }
    }

    @Test
    fun test2() {
        val word = "google".reversed()
        val char = 'g'
        var expected = IntArray(word.length)
        expected[0] = 0
        expected[1] = 1
        expected[2] = 1
        expected[3] = 0
        expected[4] = 1
        expected[5] = 2
        expected = expected.reversedArray()

        val solution = ShortestDistanceToChar.shortestToChar2(word, char)
        expected.forEachIndexed { index, i ->
            assertEquals(i, solution[index])
        }
    }

    @Test
    fun test_stress() {
        val word = "a".repeat(10000)
        val char = 'a'
        val expected = IntArray(10000)
        expected.forEachIndexed { index, i ->
            expected[index] = 0
        }

        val solution = ShortestDistanceToChar.shortestToChar2(word, char)
        expected.forEachIndexed { index, i ->
            assertEquals(i, solution[index])
        }
    }
}