package alex.com.challenges.cs

/**
 * Created by Alex Doub on 3/3/2020.
 * https://www.geeksforgeeks.org/quick-sort/
 */

object QuickSort {
    fun partitionAndReturnPartitionIndex(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var smallIndex = low // index of smaller element
        println("... partition starting. pivot:${smallIndex} -- ${arr.joinToString()}")

        //Loop & partition according to pivot
        for (x in low until high) {
            // If current element is smaller than the pivot
            if (arr[x] < pivot) {

                // swap arr[i] and arr[j]
                val temp = arr[smallIndex]
                arr[smallIndex] = arr[x]
                arr[x] = temp

                println("... ... partition did bubble swap i:$smallIndex with i:$x because ${arr[x]} < $pivot")
                smallIndex++
            }
        }

        // Finally swap partition with the smallIndex.
        // Everything before smallIndex is smaller than pivot, everything else is larger
        // The return value will be the first index of a value not smaller than the pivot
        val temp = arr[smallIndex]
        arr[smallIndex] = arr[high]
        arr[high] = temp
        println("... ... partition did finally swap i:$smallIndex with i:$high")


        println("... partition returning. pivot:${smallIndex + 1} -- ${arr.joinToString()}")

        return smallIndex
    }

    fun sort(arr: IntArray, low: Int, high: Int) {
        println("Sort called with l:$low h:$high")
        if (low < high) {

            //Choose PartitionIndex
            val pi = partitionAndReturnPartitionIndex(arr, low, high)

            // Recursively sort left & right of index
            sort(arr, low, pi - 1)
            sort(arr, pi + 1, high)
        } else {
            println("... skipped")
        }
    }
}