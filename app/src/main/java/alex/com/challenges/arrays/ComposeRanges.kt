package alex.com.challenges.arrays

/**
 * Created by Alex Doub on 3/10/2020.
 */

object ComposeRanges {
    fun composeRanges(nums: MutableList<Int>): MutableList<String> {
        if (nums.isEmpty()) return mutableListOf()

        var startIndex: Int = 0 //Represents the START OF A SEQUENCE
        val arrayList = ArrayList<String>()

        // Loop through rest of array
        // Complete sequences as they are found
        // Sequences are always behind thisIndex
        for (thisIndex in 1 until nums.size) {

            if (nums[thisIndex] != nums[startIndex] + thisIndex - startIndex) {

                if (startIndex == thisIndex - 1) {
                    arrayList.add("${nums[startIndex]}")
                    println("Added 1: ${arrayList.last()}")
                } else {
                    arrayList.add("${nums[startIndex]}->${nums[thisIndex - 1]}")
                    println("Added 2: ${arrayList.last()}")
                }

                //set start on next char
                startIndex = thisIndex
            }
        }

        // Finally, close off the last sequence
        if (startIndex == nums.size - 1) {
            arrayList.add("${nums[startIndex]}")
        } else {
            arrayList.add("${nums[startIndex]}->${nums[nums.size - 1]}")
        }

        return arrayList
    }
}