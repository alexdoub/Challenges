package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/15/2020.
 * https://leetcode.com/problems/merge-intervals/
 */

object MergeIntervals {

    //@@NOTE: THIS FAILS. [1,1].
    //ALSO IT SCALES LIKE SHIT DUE TO BOOL ARRAY LOL
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        var booleanArray = BooleanArray(0)

        // Fill out array
        for (interval in intervals) {
            val start = interval[0]
            val end = interval[1]
            if (end > booleanArray.size-1) {
                booleanArray = booleanArray.copyOf(end)
            }

            booleanArray.fill(true, start, end)
        }

        //Prepare return array
        // loop over bool array and create start/end indicies
        val rArray = ArrayList<IntArray>()
        var start = 0
        var end = 0
        var recording = false
        for (index in booleanArray.indices) {
            end = index
            val thisVal = booleanArray[index]
            if (thisVal) {
                // Is true, start or continue
                if (!recording) {
                    recording = true
                    start = index
                }
            } else {
                // Found stop or successive stop
                if (recording) {
                    rArray.add(intArrayOf(start, end))
                    recording = false
                }
            }
        }
        if (recording) {
            rArray.add(intArrayOf(start, booleanArray.size))
        }
        return rArray.toTypedArray()
    }
}