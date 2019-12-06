package alex.com.challenges

import alex.com.challenges.dynamic.WordBreakII
import org.junit.Test

/**
 * Created by Alex Doub on 12/5/2019.
 */

class WordBreakIITest{
    @Test
    fun test1() {
        val sentence = "xcatsanddogs"
        val words = listOf("x", "cat", "cats", "and", "sand", "dogs")
        assert(WordBreakII.wordBreak(sentence, words).size == 2)
    }
}