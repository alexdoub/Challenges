package alex.com.challenges

import org.junit.Test

class MatchingWordsTest {
    @Test
    fun test1() {
        val word = "love"
        val wordList = "velo low vole lovee volvell lowly lower lover levo loved love lovee lowe lowes lovey lowan lowa evolve loves volvelle lowed love"

        val count = MatchingWords.solve(word, wordList)
        assert(count == 8)
    }
}