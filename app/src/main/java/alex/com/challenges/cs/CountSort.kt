package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/2/2020.
 */

object CountSort {
    fun sortByCountSort(ints: List<Int>): List<Int> {
        var array = IntArray(0)

        // Fill out array
        for (x in ints) {
            // Extend array if new value is large
            if (x > array.size - 1) {
                array = array.copyOf(x + 1)
            }
            array[x] += 1
        }

        // Enumerate array and build final output array
        val arrayList = ArrayList<Int>()
        for (indexAndValue in array.withIndex()) {
            var x = indexAndValue.value
            while (x > 0) {
                arrayList.add(indexAndValue.index)
                x--
            }
        }

        return arrayList
    }
}