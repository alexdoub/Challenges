package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class MaxPointsOnALineTest {
    @Test
    fun test1() {
        val points = ArrayList<IntArray>()
        points.add(listOf(3, 0).toIntArray())
        points.add(listOf(3, 1).toIntArray())
        points.add(listOf(3, 2).toIntArray())
        points.add(listOf(2, 0).toIntArray())
        points.add(listOf(2, 1).toIntArray())

        val count = MaxPointsOnALine.maxPoints(points.toTypedArray())
        assertEquals(3, count)
    }

    @Test
    fun test2() {
        val inputString = "[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(4, count)
    }

    @Test
    fun test3() {
        val inputString = "[-1,-1],[-1,1],[1,1],[1,-1]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(2, count)
    }

    @Test
    fun test31() {
        val inputString = "[-1,-1],[-1,1],[1,1],[1,-1],[-1,-1],[-1,1],[1,1],[1,-1],[-1,-1],[-1,1],[1,1],[1,-1]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(6, count)
    }

    @Test
    fun test4() {
        val inputString = "[[${Int.MIN_VALUE},${Int.MIN_VALUE}],[${Int.MAX_VALUE},${Int.MAX_VALUE}]]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(2, count)
    }

    @Test
    fun test5() {
        val inputString = "[[1,1]]]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(1, count)
    }

    @Test
    fun test6() {
        val inputString = "[]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(0, count)
    }

    @Test
    fun test7() {
        val inputString = "[[0,0],[1,1],[0,0]]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(3, count)
    }

    @Test
    fun test8() {
        val inputString = "[[0,0],[1,1], [0,0],[1,1],     [2,2],    [2,3]]"
        val points = inputString.toTypedIntArray()

        val count = MaxPointsOnALine.maxPoints(points)
        assertEquals(5, count)
    }

    fun String.toTypedIntArray(): Array<IntArray> {
        //check for empty
        if (!this.contains(",")) {
            return emptyArray()
        }

        return this.split("],").map { it.replace(" ", "").replace("[", "").replace("]", "") }.map {
            val splitInside: List<String> = it.split(",")
            listOf(splitInside[0].toInt(), splitInside[1].toInt()).toIntArray()
        }.toTypedArray()
    }

    @Test
    fun gcdTest1() {
        assertEquals(2, MaxPointsOnALine.getGreatestCommonDivisor(4, 18))
        assertEquals(2, MaxPointsOnALine.getGreatestCommonDivisor(4, 6))
        assertEquals(2, MaxPointsOnALine.getGreatestCommonDivisor(4, 4002))
    }
}