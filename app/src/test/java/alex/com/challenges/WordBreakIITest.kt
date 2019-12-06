package alex.com.challenges

import alex.com.challenges.dynamic.WordBreakII
import org.junit.Test

/**
 * Created by Alex Doub on 12/5/2019.
 */

class WordBreakIITest{
    @Test
    fun test1() {
        val sentence = "xcatsanddogsxcatsanddogs"
        val words = listOf("x", "cat", "cats", "and", "sand", "dogs")
        val solution = WordBreakII.wordBreak(sentence, words)
        assert(solution.size == 4)
        assert(solution.contains("x cats and dogs x cats and dogs"))
        assert(solution.contains("x cat sand dogs x cats and dogs"))
        assert(solution.contains("x cats and dogs x cat sand dogs"))
        assert(solution.contains("x cat sand dogs x cat sand dogs"))

        //@@TODO: FIX DOUBLE SPACE
    }
}