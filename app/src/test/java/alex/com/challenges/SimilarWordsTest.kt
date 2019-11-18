package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class SimilarWordsTest {
    @Test
    fun test_similar() {
        val word = "love"
        val wordList = "velo low vole lovee volvell lowly lower lover levo loved love lovee lowe lowes lovey lowan lowa evolve loves volvelle lowed love"

        val count = SimilarWords.solve_quick(word, wordList)
        assert(count == 8)
    }

    @Test
    fun test_exact() {
        val word = "love"
        val wordList = "velo low vole lovee volvell lowly lower lover levo loved love lovee lowe lowes lovey lowan lowa evolve loves volvelle lowed love"

        //velo vole love levo
        val count = SimilarWords.solve_exact(word, wordList)
        assertEquals(4, count)
    }
}