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
            val rectLines = HashMap<String, Int>()

            //Enumerate points, compare to other points
            points.forEach { pointA ->
                points.forEach { pointB ->
                    //find lines on same Y axis (left -> right)
                    if (pointA.x < pointB.x && pointA.y == pointB.y) {
                        val key = "${pointA.x}-${pointB.x}"
                        sum += rectLines[key] ?: 0
                        rectLines[key] = (rectLines[key] ?: 0) + 1
                    }
                }
            }

            return sum
        }

        //NOTES: Did not need 2nd map. Just need a single map
        //Approach for Diamond doesnt work because it should also count non perfect diamonds. Thus no need for hashmap
        //EDIT: The problem statement was rectangles, not parallelograms (like rhombus)
        private fun countRectangles_myway(points: List<Point>): Int {
            //convert list to hashmap
            //do N^2 loop. Check for rects, check for diamonds
            //Check rect: If its NOT on the same axis, check of other 2 corresponding corner points exist
            //Check diamond. If IS on the same axis, check if left/right exist

            val xMap = HashMap<Int, HashSet<Int>>()
//            val yMap = HashMap<Int, HashSet<Int>>()
            points.forEach {
                if (xMap[it.x] == null) {
                    xMap[it.x] = HashSet()
                }
                xMap[it.x]!!.add(it.y)
//                if (yMap[it.y] == null) {
//                    yMap[it.y] = HashSet()
//                }
//                yMap[it.y]!!.add(it.x)
            }

            val savedRects = HashSet<String>()
            val savedDiamonds = HashSet<String>()
            var sum = 0

            points.forEach { pointA ->
                points.forEach { pointB ->

                    //Check if these 2 points can form a rect
                    if (pointA.x < pointB.x && pointA.y < pointB.y) {
                        //check if other 2 points exist
                        val topLeftExists = xMap[pointA.x]?.contains(pointB.y) == true
                        val bottomRightExists = xMap[pointB.x] ?.contains(pointA.y) == true
                        val rectString = "${pointA.x},${pointA.y}-${pointB.x},${pointB.y}"
                        val rectAlreadySaved = savedRects.contains(rectString)

                        //check if this rect has already been saved
                        if (topLeftExists && bottomRightExists && !rectAlreadySaved) {
                            savedRects.add(rectString)
                            sum += 1
                        }
                    }

                    //Check if these 2 points can form a diamond
                    else if (pointA != pointB && (pointA.x == pointB.x || pointA.y == pointB.y)) {

                    }
                }
            }
            return sum
        }
    }

    class Point(val x: Int, val y: Int)
}