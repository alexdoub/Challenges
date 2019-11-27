package alex.com.challenges

/**
 * Created by Alex Doub on 11/26/2019.
 * https://www.careercup.com/question?id=16759664
 */

class SmallestSpanningRange {
    companion object {
        
        private fun printDebug(string: String) {
            if (false) println(string)
        }
        
        fun solve(lists: List<IntArray>): IntArray {

            var minSpan = IntArray(lists.size)
            val indexes = IntArray(lists.size)

            //Fill out initial span
            lists.forEachIndexed { index, ints ->
                minSpan[index] = lists[index][0]
            }

            while (true) {

                // Build new span
                val thisSpan = IntArray(lists.size)
                (0 until lists.size).forEach {
                    thisSpan[it] = lists[it][indexes[it]]
                }

                // Compare to our best span
                val thisDiff = thisSpan.max()!! - thisSpan.min()!!
                val existingDiff = minSpan.max()!! - minSpan.min()!!
                if (existingDiff > thisDiff) {
                    minSpan = thisSpan
                    printDebug("Found a better span. ${thisSpan.joinToString()} with diff ${thisDiff}")
                } else {
                    printDebug("Skipping span. ${thisSpan.joinToString()} with diff ${thisDiff}. existing diff is already ${existingDiff}")
                }

                // Push an index up
                // Find minimum in thisSpan where it can be increased
                var minPushableIndex: Int? = null
                var minPushableValue: Int? = null
                thisSpan.forEachIndexed { index, value ->
                    if (indexes[index] < lists[index].size - 1) {
                        if (value < minPushableValue ?: Int.MAX_VALUE) {
                            minPushableIndex = index
                            minPushableValue = value
                        }
                    }
                }

                // Break or iterate
                if (minPushableIndex == null) {
                    printDebug("No more values to push up, breaking")
                    break
                } else {
                    printDebug("Pushing up ${minPushableIndex!!}")
                    indexes[minPushableIndex!!] += 1
                }
            }

            printDebug("Returning min span: ${minSpan.joinToString()}")
            return minSpan
        }
    }
}
