package alex.com.challenges.custom

/**
 * Created by Alex Doub on 4/2/2020.
 */


object OverlappingSchedules {

    /**
     * Background: You are guaranteed the schedule is correct, now you must place them in columns.
     *
     * Trick: You must track the latest end times of EACH COLUMN (2)
     *
     * Flow:
     * 1) Check next & last times. If there is no overlap at all then take up 2.
     * 2) Else, you know there is overlap. Decide where to put it based on which column ended first
     *
     * Failed Attempt: Did not track both times. Instead tried to alternate in the B case. (It would obviously fail)
     *
     * */
    private fun schedule(inputs: List<ScheduleInput>): List<ScheduleOutput> {
        val output = ArrayList<ScheduleOutput>()

        var leftLastEndTime = -1
        var rightLastEndTime = -1

        for (i in inputs.indices) {

            val input = inputs[i]
            val next = if (i < inputs.size-1) inputs[i+1] else null


            val isAtEndOfBothCols = input.start >= leftLastEndTime && input.start >= rightLastEndTime
            val nextOneStartsAfterThisEnds = next?.start ?: Int.MAX_VALUE >= input.end

//            println("..    isAtEndOfBothCols: $isAtEndOfBothCols    nextIsNull: ${next == null }  nextOneStartsAfterThisEnds: $nextOneStartsAfterThisEnds")

            //No overlap at all, full width
            if (isAtEndOfBothCols && nextOneStartsAfterThisEnds) {
                output.add(ScheduleOutput(input.name, 0, 2))
                leftLastEndTime = input.end
                rightLastEndTime = input.end
//                println("Double")
            } else {
                // This overlaps something. Put on left or right

                //put on RIGHT if not before overlap
                val onLeft = leftLastEndTime <= rightLastEndTime
                if (onLeft) {
                    output.add(ScheduleOutput(input.name, 0, 1))
                    leftLastEndTime = input.end
//                    println("Left. leftLastEndTime:$leftLastEndTime")
                } else {
                    output.add(ScheduleOutput(input.name, 1, 1))
                    rightLastEndTime = input.end
//                    println("Right: $rightLastEndTime")
                }
            }
        }

        return output
    }

    fun assertSame(desc: String, inputs: List<ScheduleInput>, outputs: List<ScheduleOutput>) {

        val results = schedule(inputs)
        if (results != outputs) {
            println("=======================")
            println("FAIL: $desc")
            println("Expected: \n${outputs.joinToString(separator = "\n")}")
            println("--")
            println("Got: \n${results.joinToString(separator = "\n")}")
            println("=======================")
        } else {
            println("Correct: $desc")
        }
    }


    class ScheduleInput(val name: String, val start: Int, val end: Int) {
        override fun toString(): String {
            return "$name: $start - $end"
        }
    }

    class ScheduleOutput(val name: String, val col: Int, val width: Int) {
        override fun toString(): String {
            return "$name: Col:$col - Width:$width"
        }

        override fun equals(other: Any?): Boolean {
            return other != null && other is ScheduleOutput && other.name == name && other.col == col && other.width == width
        }
    }

    // No overlap
    val noOverlap = listOf(ScheduleInput("A", 1, 5), ScheduleInput("B", 5, 10))
    val noOverlapOutput = listOf(ScheduleOutput("A", 0, 2), ScheduleOutput("B", 0, 2))

    // Single overlap
    val singleOverlapInner = listOf(ScheduleInput("A", 1, 10), ScheduleInput("B", 2, 3))
    val singleOverlapMatch = listOf(ScheduleInput("A", 1, 10), ScheduleInput("B", 1, 10))
    val singleOverlapOuter = listOf(ScheduleInput("A", 1, 10), ScheduleInput("B", 2, 11))
    val singleOverlapOutput = listOf(ScheduleOutput("A", 0, 1), ScheduleOutput("B", 1, 1))

    // Double overlap on right
    val doubleOverlapOnRightInner = listOf(ScheduleInput("A", 1, 10), ScheduleInput("B", 2, 4), ScheduleInput("C", 5, 8))
    val doubleOverlapOnRightOver = listOf(ScheduleInput("A", 1, 10), ScheduleInput("B", 2, 4), ScheduleInput("C", 5, 15))

    val doubleOverlapOnRightOutput = listOf(ScheduleOutput("A", 0, 1), ScheduleOutput("B", 1, 1), ScheduleOutput("C", 1, 1))

    // Double overlap, right then left
    val doubleOverlapRightAndLeft = listOf(ScheduleInput("A", 1, 10), ScheduleInput("B", 2, 12), ScheduleInput("C", 11, 12))
    val doubleOverlapRightAndLeftOutput = listOf(ScheduleOutput("A", 0, 1), ScheduleOutput("B", 1, 1), ScheduleOutput("C", 0, 1))
    fun runTests() {

        OverlappingSchedules.assertSame("noOverlap", OverlappingSchedules.noOverlap, OverlappingSchedules.noOverlapOutput)

        OverlappingSchedules.assertSame("singleOverlapInner", OverlappingSchedules.singleOverlapInner, OverlappingSchedules.singleOverlapOutput)
        OverlappingSchedules.assertSame("singleOverlapMatch", OverlappingSchedules.singleOverlapMatch, OverlappingSchedules.singleOverlapOutput)
        OverlappingSchedules.assertSame("singleOverlapOuter", OverlappingSchedules.singleOverlapOuter, OverlappingSchedules.singleOverlapOutput)

        OverlappingSchedules.assertSame("doubleOverlapOnRightInner", OverlappingSchedules.doubleOverlapOnRightInner, OverlappingSchedules.doubleOverlapOnRightOutput)
        OverlappingSchedules.assertSame("doubleOverlapOnRightOver", OverlappingSchedules.doubleOverlapOnRightOver, OverlappingSchedules.doubleOverlapOnRightOutput)

        OverlappingSchedules.assertSame("doubleOverlapRightAndLeft", OverlappingSchedules.doubleOverlapRightAndLeft, OverlappingSchedules.doubleOverlapRightAndLeftOutput)
    }
}