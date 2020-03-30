package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/3/2020.
 * https://www.geeksforgeeks.org/quick-sort/
 */

object QuickSort {
    fun partitionAndReturnPartitionIndex(arr: IntArray, low: Int, high: Int): Int {
        //Partition around last element
        var lowIndex = low
        val pivotIndex = high   // Choose high because then we don't have to skip it in the inner loop. cleaner code

        //Loop & partition according to pivot
        // (Anchored forward loop. See MoveZeroes)
        for (x in lowIndex..high) {
            if (arr[x] < arr[pivotIndex]) {
                val tmp = arr[lowIndex]
                arr[lowIndex] = arr[x]
                arr[x] = tmp
                lowIndex++
            }
        }

        //final swap. lowIndex with pivot index (high)
        val tmp = arr[lowIndex]
        arr[lowIndex] = arr[pivotIndex]
        arr[pivotIndex] = tmp

        return lowIndex
    }

    private fun quicksort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {

            //Choose PartitionIndex
            val pi = partitionAndReturnPartitionIndex(arr, low, high)

            // Recursively sort left & right of index
            quicksort(arr, low, pi - 1)
            quicksort(arr, pi + 1, high)
        }
    }

    fun quickselect(arr: IntArray, k: Int): Int {
        return quickselect(arr, 0, arr.size - 1, k)
    }

    private fun quickselect(arr: IntArray, low: Int, high: Int, k: Int): Int {
        if (k > arr.size - 1) return -1 //no kth element

        //Choose PartitionIndex. Partition array around last element & return the partition index
        val pi = partitionAndReturnPartitionIndex(arr, low, high)

        // If pivot == k, then we are done
        if (pi == k) return arr[k]
        // Value we want is on the right side
        else if (k > pi) return quickselect(arr, pi + 1, high, k)
        // Value we want is on the left side
        else return quickselect(arr, low, pi - 1, k)
    }
}
