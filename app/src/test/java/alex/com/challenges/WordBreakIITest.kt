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
    }

    @Test
    fun test2() {
        val sentence = "pineapplepenapple"
        val words = listOf("apple", "pen", "applepen", "pine", "pineapple")
        val solution = WordBreakII.wordBreak(sentence, words)
        assert(solution.size == 3)
        assert(solution.contains("pine apple pen apple"))
        assert(solution.contains("pineapple pen apple"))
        assert(solution.contains("pine applepen apple"))
    }

    @Test
    fun test3() {
        val sentence = "catsandog"
        val words = listOf("cats", "dog", "sand", "and", "cat")
        val solution = WordBreakII.wordBreak(sentence, words)
        assert(solution.size == 0)
    }

    @Test
    fun test_homemade1() {
        val sentence = "xxxx"
        val words = listOf("x", "xx", "xxx", "xxxx")
        val solution = WordBreakII.wordBreak(sentence, words)
        assert(solution.size == 8)
        assert(solution.contains("xxxx"))
        assert(solution.contains("x xxx"))
        assert(solution.contains("xx xx"))
        assert(solution.contains("x x xx"))
        assert(solution.contains("xxx x"))
        assert(solution.contains("x xx x"))
        assert(solution.contains("xx x x"))
        assert(solution.contains("x x x x"))
    }

    @Test
    fun test5_BS() {
        val sentence = "a"
        val words = listOf<String>()
        val solution = WordBreakII.wordBreak(sentence, words)
        assert(solution.size == 0)
    }
}