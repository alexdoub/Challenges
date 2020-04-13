package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 4/13/2020.
 * FB TI #1
 *
 * Mistakes made:
 * -Confused start and end times.
 * -Confused input type (list of strings vs single string)
 * -Stored last start time which led to confusing math
 */

object TotalTimeOfJobsWithCooldown {

    fun runTests() {

        class InputPair(val input: String, val cooldown: Int, val expected: Int)
        val inputs = listOfNotNull(
            InputPair("A", 200, 1),
            InputPair("AB", 200, 2),
            InputPair("AA", 100, 102),
            InputPair("AAA", 100, 203), //0-101, 101-202, 203
            InputPair("AAB", 2, 5), // A _ _ A B
            InputPair("AABA", 2, 7),
            InputPair("ABCABC", 3, 7),
            null
        )

        for (input in inputs) {
            val result = calculateTotalTime(input.input, input.cooldown)
            if (result != input.expected) {
                println("Broken. Got $result")
            } else {
                println("Works!")
            }
        }
    }

    // Record map of 'when can this job start again'. When its on cooldown, just add the diff
    // Always add 1, as jobs take 1 unit of time to complete
    fun calculateTotalTime(input: String, cooldown: Int): Int {

        var totalTime = 0
        val canStartAgainAt = HashMap<Char, Int>()

        for (x in input) {

            val canStartAgainAtTime = canStartAgainAt[x] ?: 0
            if (canStartAgainAtTime > totalTime) {
                totalTime += canStartAgainAtTime - totalTime
            }
            totalTime++

            canStartAgainAt[x] = totalTime + cooldown
        }

        return totalTime
    }
}