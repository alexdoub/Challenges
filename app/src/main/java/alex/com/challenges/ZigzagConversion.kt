package alex.com.challenges

/**
 * Created by Alex Doub on 12/31/2019.
 *  https://leetcode.com/problems/zigzag-conversion/
 */

class ZigzagConversion {
    companion object {
        fun convert(s: String, numRows: Int): String {

            if (numRows == 1) {
                return s
            }

            // Init
            val rows = mutableListOf<StringBuilder>()
            (0 until numRows).forEach {
                rows.add(StringBuilder())
            }

            // Loop over chars and add to rows
            var thisRow = 0
            var goingDown = true
            s.forEach{
                rows[thisRow].append(it)
                if (goingDown) {
                    if (thisRow < numRows - 1) {
                        thisRow += 1
                    } else {
                        goingDown = !goingDown
                        thisRow -=1
                    }

                } else {
                    if (thisRow > 0) {
                        thisRow -= 1
                    } else {
                        thisRow += 1
                        goingDown = !goingDown
                    }
                }

            }

            // Join rows
            return rows.joinToString(separator = "")
        }
    }
}