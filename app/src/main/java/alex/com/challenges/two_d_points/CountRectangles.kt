package alex.com.challenges.two_d_points

/**
 * Created by Alex Doub on 2019-12-31.
 */

class CountRectangles {
    companion object {
        fun countRectangles(points: List<Point>): Int {
            return countRectangles_simple(points)
        }

        //Attempt 1: Simple squares only
        private fun countRectangles_simple(points: List<Point>): Int {

            //keep map of lines
            var sum = 0
            val lines = HashMap<String, Int>()

            //Enumerate points, compare to other points
            points.forEach { pointA ->
                points.forEach { pointB ->
                    //find lines on same Y axis (left -> right)
                    if (pointA.x < pointB.x && pointA.y == pointB.y) {
                        sum += lines["${pointA.x}-${pointB.x}"] ?: 0
                        lines["${pointA.x}-${pointB.x}"] = (lines["${pointA.x}-${pointB.x}"] ?: 0) + 1
                    }
                }
            }

            return sum
        }
    }

    class Point(val x: Int, val y: Int)
}