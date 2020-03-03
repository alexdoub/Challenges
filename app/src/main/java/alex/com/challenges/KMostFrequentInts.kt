package alex.com.challenges

/**
 * Created by Alex Doub on 3/2/2020.
 * https://www.youtube.com/watch?v=t0OQAD5gjd8
 */

object KMostFrequentInts {

    //Runs in linear time! No sorting required
    fun groupIntoMapThenBucket(input: IntArray, k: Int) {

        // Group lists into map of lists, map those values to their size
        val grouped = input.groupBy { it }.mapValues { it.value.size }  //O(n)

        //transform into buckets. index = occurrence, value = list of ints
        var buckets = Array<ArrayList<Int>?>(0) { null }
        for (entry in grouped.entries) {

            //expand buckets array
            if (buckets.size < entry.value) {
                buckets = buckets.copyOf(entry.value + 1)
            }

            //initialize bucket
            if (buckets[entry.value] == null) buckets[entry.value] = ArrayList()

            //add to bucket
            buckets[entry.value]!!.add(entry.key)
        }

        println("The most common entries are...")
        var k = k

        //reverse enumerate bucket & print k
        for (x in buckets.indices.reversed()) {
            val bucket = buckets[x]
            while (bucket != null && bucket.isNotEmpty()) {
                val value = bucket.removeAt(0)
                println("..${value} with ${x} occurences")
                k--

                if (k == 0) {
                    return
                }
            }
        }
    }

    //Speed = O(n log n)
    //Mem = O(n)    //Worst case: individually groups everything separately into hashmap
    fun groupIntoMap1(input: List<Int>, k: Int) {

        // Group lists into map of lists, map those values to their size
        val grouped = input.groupBy { it }.mapValues { it.value.size }  //O(n)

        // Transform into sorted list
        val sorted = grouped.entries.sortedByDescending { it.value }    //O(n log n) because sorting.. or O(n+m)    //@@TODO: Implement

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

    //Speed = O(n log n)
    //Mem = O(n)    //Worst case: individually groups everything separately into hashmap
    fun groupIntoMap2(input: List<Int>, k: Int) {

        // Group list into a map of lists
        val grouped = input.groupBy { it }

        // Enumerate values and find largest list
        val sorted = grouped.entries.sortedByDescending { it.value.size }   //O(n log n) because sorting.. or O(n+m)

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