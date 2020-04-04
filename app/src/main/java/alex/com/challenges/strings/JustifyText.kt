package alex.com.challenges.strings

/**
 * Created by Alex Doub on 4/3/2020.
 */

object JustifyText {
    fun justifyText(input: List<String>, maxWidth: Int): List<String> {

        val results = ArrayList<String>()

        // val sb = StringBuilder()
        val wordsInProg = ArrayList<String>()
        var currentLength = 0

        fun finalizeWordsInProgress() {

            if (wordsInProg.size == 1) {
                results.add(wordsInProg[0])
                return
            }

            var totalSpaces = maxWidth - currentLength

            while (totalSpaces > 0) {
                for (x in 0..wordsInProg.size - 2) {

                    if (totalSpaces == 0) break

                    wordsInProg[x] = wordsInProg[x] + " "   // copies & append strings (bad!) (fix: use stringbuilders instead -- very easy, 1 or 2 line change)
                    totalSpaces--
                }
            }
            val resultString = wordsInProg.joinToString(separator = "")
            
            // clear & flush results
            results.add(resultString)
            wordsInProg.clear()
        }

        for (word in input) {
            // check if adding this would be OK or if we should close out the stringbuilder & append to results
            if (currentLength + word.length + wordsInProg.size >= maxWidth) {
                finalizeWordsInProgress()
                currentLength = 0
            }

            wordsInProg.add(word)
            currentLength = word.length
        }

        if (wordsInProg.isNotEmpty()) {
            finalizeWordsInProgress()
        }


        return results
    }
}