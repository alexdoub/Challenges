package alex.com.challenges

import alex.com.challenges.strings.SimilarWords2
import org.junit.Assert.assertEquals
import org.junit.Test

class SimilarWordsTest {
    @Test
    fun same_char_set() {
        val word = "love"
        val wordList = "velo low vole lovee volvell lowly lower lover levo loved love lovee lowe lowes lovey lowan lowa evolve loves volvelle lowed love".split(" ")

        val count = SimilarWords2.solve_same_char_set2(word, wordList)
        assertEquals(8, count)
    }

    @Test
    fun with_same_char_count() {
        val word = "love"
        val wordList = "velo low vole lovee volvell lowly lower lover levo loved love lovee lowe lowes lovey lowan lowa evolve loves volvelle lowed love".split(" ")

        // same chars AND count
        val count = SimilarWords2.solve_with_same_char_count(word, wordList)
        assertEquals(4, count)
    }
}