package alex.com.challenges.stack

/**
 * Created by Alex Doub on 3/14/2020.
 * https://leetcode.com/problems/exclusive-time-of-functions/
 */

//NOTE: Instructions didn't say, but we are guaranteed they will pop in order

object ExclusiveTimeOfFunctions {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val stack = ArrayList<Int>()
        var lastTime = 0
        val exclusiveTime = IntArray(n)
        for (log in logs) {
            val split = log.split(':')
            val id = split[0].toInt()
            val isStart = split[1][0] == 's'
            val time = split[2].toInt()
            if (isStart) {
                // starting new function. tally up time
                if (stack.isNotEmpty()) {
                    val lastId = stack.last()
                    val duration = time - lastTime
                    exclusiveTime[lastId] += duration
                }
                stack.add(id)
                lastTime = time
            } else {
                // ending function, tally up time
                val lastId = stack.removeAt(stack.size - 1)
                val duration = time - lastTime + 1  //extra 1 when ending
                lastTime = time + 1
                exclusiveTime[lastId] += duration
            }
        }
        return exclusiveTime
    }
}