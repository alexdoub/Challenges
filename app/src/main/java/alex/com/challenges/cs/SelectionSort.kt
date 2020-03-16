package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/15/2020.
 */

object SelectionSort {
    fun IntArray.selectionSort() {
        for (x in indices) {

            // find max
            var maxIndex = x
            for (y in x until size-1) {
                val thisVal = this[y]
                if (thisVal < this[maxIndex]) {
                    maxIndex = y
                }
            }

            // swap this with max
            if (maxIndex != x) {
                val thisVal = this[x]
                this[x] = this[maxIndex]
                this[maxIndex] = thisVal
            }
        }
    }
}