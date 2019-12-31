package alex.com.challenges

import alex.com.challenges.two_d_points.CountRectangles
import android.graphics.Point
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 2019-12-31.
 */

class CountRectanglesTest {


    @Test
    fun test2x2() {
        val points = listOf(
            CountRectangles.Point(0, 0),
            CountRectangles.Point(1, 0),
            CountRectangles.Point(0, 1),
            CountRectangles.Point(1, 1)
        )

        assertEquals(1, CountRectangles.countRectangles(points))
    }

    @Test
    fun test2x3() {
        val points = listOf(
            CountRectangles.Point(0, 0),
            CountRectangles.Point(1, 0),
            CountRectangles.Point(0, 1),
            CountRectangles.Point(1, 1),
            CountRectangles.Point(0, 2),
            CountRectangles.Point(1, 2)
        )

        assertEquals(3, CountRectangles.countRectangles(points))
    }


    @Test
    fun test2x4() {
        val points = listOf(
            CountRectangles.Point(0, 0),
            CountRectangles.Point(1, 0),
            CountRectangles.Point(0, 1),
            CountRectangles.Point(1, 1),
            CountRectangles.Point(0, 2),
            CountRectangles.Point(1, 2),
            CountRectangles.Point(0, 3),
            CountRectangles.Point(1, 3)
        )

        assertEquals(6, CountRectangles.countRectangles(points))
    }

    @Test
    fun test3x3() {
        val points = listOf(
            CountRectangles.Point(0, 0),
            CountRectangles.Point(1, 0),
            CountRectangles.Point(2, 0),
            CountRectangles.Point(0, 1),
            CountRectangles.Point(1, 1),
            CountRectangles.Point(2, 1),
            CountRectangles.Point(0, 2),
            CountRectangles.Point(1, 2),
            CountRectangles.Point(2, 2)
        )

        assertEquals(9, CountRectangles.countRectangles(points))
    }
}