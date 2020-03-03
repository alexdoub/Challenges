package alex.com.challenges

/**
 * Created by Alex Doub on 3/2/2020.
 * https://www.youtube.com/watch?v=t0OQAD5gjd8
 */

object MostFrequentInts {

    fun approach1a(input: List<Int>, k: Int) {

        // Group lists into map of lists, map those values to their size
        val grouped = input.groupBy { it }.mapValues { it.value.size }  //O(n)

        // Transform into sorted list
        val sorted = grouped.entries.sortedByDescending { it.value }    //O(n log n) because sorting

        // Early return on bad input
        if (sorted.size < k) {
            println("Not enough unique elements")
            return
        }

        // Reduce to top K
        val reduced = sorted.subList(0, k)

        println("The most common entries are... ${
        reduced.joinToString(
            prefix = "\n",
            separator = "\n",
            transform = { "  ${it.key} occured ${it.value} times" }
        )
        }")
    }

    fun approach1b(input: List<Int>, k: Int) {

        // Group list into a map of lists
        val grouped = input.groupBy { it }

        // Enumerate values and find largest list
        val sorted = grouped.entries.sortedByDescending { it.value.size }

        // Early return on bad input
        if (sorted.size < k) {
            println("Not enough unique elements")
            return
        }

        // reduce to top k
        val reduced = sorted.subList(0, k)

        // print
        println("The top k:$k values are.... ${
        reduced.joinToString(
            prefix = "\n",
            separator = "\n",
            transform = { "  ${it.key} with ${it.value.size} occurences" }
        )
        }")
    }

    //input.groupBy { it }.mapValues { it.value.size }  //O(n)
    private fun groupValuesIntoMapWithCount(inputs: List<Int>) {

        //convert to a hashmap of <unique int, counts>
        val map = HashMap<Int, Int>()
        for (input in inputs) {
            // First time seeing this number, set base (0)
            if (map[input] == null) {
                map[input] = 0
            }
            map[input] = map[input]!! + 1
        }
    }
}