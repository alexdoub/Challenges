package alex.com.challenges

import org.junit.Test

/**
 * Created by Alex Doub on 12/4/2019.
 */

class PerfectRectangleTest {
    @Test
    fun test1() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 3, 3),
            intArrayOf(3, 1, 4, 2),
            intArrayOf(3, 2, 4, 4),
            intArrayOf(1, 3, 2, 4),
            intArrayOf(2, 3, 3, 4)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles))
    }

    @Test
    fun test1_extended() {
        val rectangles = arrayOf(
            intArrayOf(100000001, 100000001, 100000003, 100000003),
            intArrayOf(100000003, 100000001, 100000004, 100000002),
            intArrayOf(100000003, 100000002, 100000004, 100000004),
            intArrayOf(100000001, 100000003, 100000002, 100000004),
            intArrayOf(100000002, 100000003, 100000003, 100000004)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles))
    }

    @Test
    fun test1_rev() {
        val rectangles = arrayOf(
            intArrayOf(3, 3, 1, 1),
            intArrayOf(4, 2, 3, 1),
            intArrayOf(4, 4, 3, 2),
            intArrayOf(2, 4, 1, 3),
            intArrayOf(3, 4, 2, 3)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles))
    }

    @Test
    fun test2() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 3, 3),
//            intArrayOf(3, 1, 4, 2),
            intArrayOf(3, 2, 4, 4),
            intArrayOf(1, 3, 2, 4),
            intArrayOf(2, 3, 3, 4)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test3() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 3, 3),
            intArrayOf(3, 1, 4, 2),
            intArrayOf(3, 2, 4, 4),
            intArrayOf(1, 3, 2, 4)
//            intArrayOf(2, 3, 3, 4)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test4() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 3, 3),
            intArrayOf(3, 1, 4, 2),
            intArrayOf(3, 2, 4, 4),
//            intArrayOf(1, 3, 2, 4),
            intArrayOf(2, 3, 3, 4)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test5() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 2, 4),
            intArrayOf(2, 1, 4, 2),
            intArrayOf(2, 3, 4, 4),
            intArrayOf(3, 2, 4, 3)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test6() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 2, 4),
            intArrayOf(2, 1, 4, 2),
            intArrayOf(2, 3, 4, 4),
            intArrayOf(2, 2, 3, 3),
            intArrayOf(3, 2, 4, 3)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles))
    }

    @Test
    fun test7_onebyone() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 1, 1)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles))
    }


    @Test
    fun test7_empty() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 1, 1)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test7_empty1() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 2, 1)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test7_empty2() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 1, 2)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test8_OBSTACLE1_BULLSHIT() {

        //These rectangles overlap so they do not form a 'perfect' rectangle
        val rectangles = arrayOf(
            intArrayOf(1, 1, 3, 3),
            intArrayOf(3, 1, 4, 2),
            intArrayOf(1, 3, 2, 4),
            intArrayOf(2, 2, 4, 4)
        )

        assert(PerfectRectangle.isRectangleCover(rectangles) == false)
    }

    @Test
    fun test9_obstacle2() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(0, 1, 1, 2),
            intArrayOf(0, 2, 1, 3),
            intArrayOf(0, 3, 1, 4)
        )
        assert(PerfectRectangle.isRectangleCover(rectangles))
    }

    @Test
    fun test9_obstacle2_x() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 2, 1),
            intArrayOf(2, 0, 3, 1),
            intArrayOf(3, 0, 4, 1)
        )
        assert(PerfectRectangle.isRectangleCover(rectangles))
    }

    val min = 1000000
    val max = min + 10000
    @Test
    fun stress1() {
        stress(10, min, max)
    }

    @Test
    fun stress2() {
        stress(100, min, max)
    }

    @Test
    fun stress3() {
        stress(1000, min, max)
    }

    @Test
    fun stress4() {
        stress(10000, min, max)
    }

    private fun stress(limit:Int, ymin:Int, ymax:Int) {
        val rectangles = ArrayList<IntArray>()
        (0..limit).forEachIndexed { index, i ->
            val rect = IntArray(4)
            rect[0] = index
            rect[1] = ymin
            rect[2] = index + 1
            rect[3] = ymax
            rectangles.add(rect)
        }
        assert(PerfectRectangle.isRectangleCover(rectangles.toTypedArray()))
    }
}