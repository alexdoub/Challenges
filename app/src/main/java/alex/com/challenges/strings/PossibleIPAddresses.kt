package alex.com.challenges.strings

/**
 * Created by Alex Doub on 4/11/2020.
 * https://leetcode.com/problems/restore-ip-addresses/
 */

object PossibleIPAddresses {

    // These optimizations didnt end up making it faster and they were a pain to think out, but if we had a deeper search space they would come in handy
    fun restoreIpAddresses_unnecessary_optimizations(s: String): List<String> {

        val results = ArrayList<String>()
        fun buildOptions(index: Int, used: ArrayList<String>) {

            // Check if we have a solution
            if (used.size == 4) {
                results.add(used.joinToString(separator = "."))
                return
            }

            val batchesLeft = 3 - used.size
            val minRemaining = s.length - (3 * batchesLeft) // Must leave at max 3 digits per remaining group
            val maxRemaining = s.length - batchesLeft       // Must leave at least 1 digit for remaining batches

            //Try all valid combos for this batch
            for (x in 1..3) {
                val newIndex = x + index

                if (newIndex < minRemaining) continue
                if (newIndex > s.length || newIndex > maxRemaining) break

                val substring = s.substring(index, newIndex)

                val intVal = substring.toInt()
                if (intVal > 255 || intVal.toString() != substring) break   //exclude "567" or "010"

                used.add(substring)
                buildOptions(newIndex, used)
                used.removeAt(used.lastIndex)
            }
        }
        buildOptions(0, ArrayList())
        return results
    }

    // Brute force? Still technically constant time as s has a max length of 12 & this will branch (3^4)
    fun restoreIpAddresses_simple(s: String): List<String> {

        val results = ArrayList<String>()
        fun buildOptions(index: Int, used: List<String>) {

            // Check if we have a solution
            if (used.size == 4) {
                if (index == s.length) {
                    results.add(used.joinToString(separator = "."))
                }
                return
            }

            //Try all valid combos for this batch
            for (x in 1..3) {
                if (x + index > s.length) break

                val substring = s.substring(index, index + x)

                val intVal = substring.toInt()
                if (intVal > 255 || intVal.toString() != substring) break   //exclude "567" or "010"

                buildOptions(index + x, used + substring)
            }
        }
        buildOptions(0, emptyList())
        return results
    }
}