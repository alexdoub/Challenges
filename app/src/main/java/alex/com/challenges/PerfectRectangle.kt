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

        //@@Fails: Memory scaling is insane
        fun isRectangleCover(rectangles: Array<IntArray>): Boolean {

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