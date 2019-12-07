package alex.com.challenges


/**
 * Created by Alex Doub on 12/4/2019.
 * https://leetcode.com/problems/perfect-rectangle/
 */

class PerfectRectangle {
    companion object {
        private fun printDebug(string: String) {
            if (false) println(string)
        }

        //Maintain list of points & count total area
        //Check that all points have proper corresponding points & Area matches
        fun isRectangleCover(rectangles: Array<IntArray>): Boolean {

            var minX: Int = kotlin.math.min(rectangles[0][0], rectangles[0][2])
            var minY: Int = kotlin.math.min(rectangles[0][1], rectangles[0][3])
            var maxX: Int = kotlin.math.max(rectangles[0][0], rectangles[0][2])
            var maxY: Int = kotlin.math.max(rectangles[0][1], rectangles[0][3])
            val pointsMap = HashMap<Point, Int>()
            var calculatedArea = 0L

            fun addPoint(point: Point) {
                if (pointsMap[point] == null) {
                    pointsMap[point] = 1
                } else {
                    pointsMap[point] = pointsMap[point]!! + 1
                }
            }

            // Enumerate rects. Find mins/maxs/areas and build pointsMap
            rectangles.forEach { rect ->

                // Check min/max
                val thisMinX: Int = kotlin.math.min(rect[0], rect[2])
                val thisMinY: Int = kotlin.math.min(rect[1], rect[3])
                val thisMaxX: Int = kotlin.math.max(rect[0], rect[2])
                val thisMaxY: Int = kotlin.math.max(rect[1], rect[3])
                if (thisMinX < minX) {
                    minX = thisMinX
                }
                if (thisMinY < minY) {
                    minY = thisMinY
                }
                if (thisMaxX > maxX) {
                    maxX = thisMaxX
                }
                if (thisMaxY > maxY) {
                    maxY = thisMaxY
                }

                // Add to points map
                val points = (0..3).map {
                    when (it) {
                        0 -> Point(thisMinX, thisMinY)
                        1 -> Point(thisMinX, thisMaxY)
                        2 -> Point(thisMaxX, thisMinY)
                        else -> Point(thisMaxX, thisMaxY)
                    }
                }
                points.forEach { addPoint(it) }

                // Sum area
                val area = rect.getArea()
                calculatedArea += area
            }


            //Area check
            //Area must == full area
            val expectedArea: Long = (maxY - minY).toLong() * (maxX - minX).toLong()
            printDebug("Expected area: ${expectedArea}. Calculated Area: ${calculatedArea}.")
            if (calculatedArea != expectedArea) {
                return false
            }
            if (expectedArea == 0L) {
                printDebug("No area")
                return false
            }

            //Point check
            val topLeft = Point(minX, maxY)
            val topRight = Point(maxX, maxY)
            val botLeft = Point(minX, minY)
            val botRight = Point(maxX, minY)
            pointsMap.keys.forEach { point ->

                //If point lies on corner, there should be only 1
                if (point == topLeft || point == topRight || point == botLeft || point == botRight) {
                    if (pointsMap[point] != 1) {
                        printDebug("Corner Point mismatch at ${point}. Has ${pointsMap[point]} points")
                        return false
                    }
                }
                //If point lies on edge (non corner), there should only be 2
                else if (point.x == minX || point.x == maxX || point.y == minY || point.y == maxY) {
                    if (pointsMap[point] != 2) {
                        printDebug("Outer Point mismatch at ${point}. Has ${pointsMap[point]} points")
                        return false
                    }
                }
                //If point lies in center-ish, there should be 2 or 4 joins max
                else {
                    if (pointsMap[point] != 2 && pointsMap[point] != 4) {
                        printDebug("Inner Point mismatch at ${point}. Has ${pointsMap[point]} points")
                        return false
                    }
                }
            }

            return true
        }

        private fun IntArray.getArea(): Long {
            val minX: Int = kotlin.math.min(this[0], this[2])
            val minY: Int = kotlin.math.min(this[1], this[3])
            val maxX: Int = kotlin.math.max(this[0], this[2])
            val maxY: Int = kotlin.math.max(this[1], this[3])
            val area = (maxY - minY).toLong() * (maxX - minX).toLong()
            printDebug("Rect: ${this.joinToString()}  has area: ${area}")
            return area
        }

        private class Point(val x: Int, val y: Int) {
            override fun toString(): String {
                return "$x $y"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Point

                if (x != other.x) return false
                if (y != other.y) return false

                return true
            }

            override fun hashCode(): Int {
                var result = x
                result = 31 * result + y
                return result
            }
        }


        //Represent rects as Array of BoolArrays
        //Fails: Memory scaling is insane
        fun isRectangleCover_HIGH_MEM(rectangles: Array<IntArray>): Boolean {

            //Find mins and maxes
            var minX: Int = kotlin.math.min(rectangles[0][0], rectangles[0][2])
            var minY: Int = kotlin.math.min(rectangles[0][1], rectangles[0][3])
            var maxX: Int = kotlin.math.max(rectangles[0][0], rectangles[0][2]) - 1
            var maxY: Int = kotlin.math.max(rectangles[0][1], rectangles[0][3]) - 1

            (1 until rectangles.size).forEach { index ->
                val thisMinX = kotlin.math.min(rectangles[index][0], rectangles[index][2])
                val thisMinY = kotlin.math.min(rectangles[index][1], rectangles[index][3])
                val thisMaxX = kotlin.math.max(rectangles[index][0], rectangles[index][2]) - 1
                val thisMaxY = kotlin.math.max(rectangles[index][1], rectangles[index][3]) - 1

                if (thisMinX < minX) {
                    minX = thisMinX
                }
                if (thisMinY < minY) {
                    minY = thisMinY
                }
                if (thisMaxX > maxX) {
                    maxX = thisMaxX
                }
                if (thisMaxY > maxY) {
                    maxY = thisMaxY
                }
            }
            val xOffset = minX
            val yOffset = minY
            printDebug("MinX: ${minX} minY:${minY}. maxX:${maxX}, maxY:${maxY} -- offset: ${xOffset} X and ${yOffset} Y")

            if (maxX < minX || maxY < minY) {
                printDebug("Edge case. No rects")
                return false
            }

            printDebug(".. Enumerating Rects .. Rows: ${maxY - minY + 1} Cols: ${maxX - minX + 1}")

            // Create normalized 2d bool array
            val boolArrays = Array<BooleanArray>(maxY - minY + 1) {
                BooleanArray(maxX - minX + 1)
            }
            rectangles.forEachIndexed { index, rect ->

                printDebug("")

                //2,3 5, 6
                //means from 3 - 6, set 2-5 as filled
                val thisMinX = kotlin.math.min(rectangles[index][0], rectangles[index][2])
                val thisMinY = kotlin.math.min(rectangles[index][1], rectangles[index][3])
                val thisMaxX = kotlin.math.max(rectangles[index][0], rectangles[index][2]) - 1
                val thisMaxY = kotlin.math.max(rectangles[index][1], rectangles[index][3]) - 1

                printDebug("Rect #${index}  ${rect.joinToString()}")
                printDebug("(minX:${thisMinX} maxX:${thisMaxX}   minY:${thisMinY} maxY:${thisMaxY})")

                ((thisMinY - yOffset)..(thisMaxY - yOffset)).forEach { row ->
                    printDebug("... filling row ${row} from ${thisMinX - xOffset} to ${thisMaxX - xOffset}")
                    val boolArray = boolArrays[row]

                    // Check if any of those bits are already set, fail if thats the case
                    val checkArr = boolArray.copyOfRange(thisMinX - xOffset, thisMaxX - xOffset + 1)
                    if (checkArr.any { it }) {
                        printDebug("... Overlap detected, failing")
                        return false
                    }


                    boolArray.fill(true, thisMinX - xOffset, thisMaxX - xOffset + 1)
                }

            }

            // Find any gaps
            return !boolArrays.any { it.any { !it } }
//            boolArrays.forEachIndexed { rowIndex, boolArray ->
//                boolArray.forEachIndexed { colIndex, b ->
//                    if (!b) {
//                        println("Found a gap at: ${colIndex},${rowIndex}")
//                        return false
//                    }
//                }
//            }
//            return true
        }
    }
}