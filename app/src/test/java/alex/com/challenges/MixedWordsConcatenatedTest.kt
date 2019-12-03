package alex.com.challenges

import org.junit.Test

/**
 * Created by Alex Doub on 12/1/2019.
 */

class MixedWordsConcatenatedTest {
    @Test
    fun test1() {
        val word = "barfoothefoobarman"
        val strings = listOf("foo", "bar").toTypedArray()
        val expected = IntArray(2)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        expected[0] = 0
        expected[1] = 9
        assert(result.size == 2)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test2() {
        val word = "wordgoodgoodgoodbestword"
        val strings = listOf("word", "good", "best", "word").toTypedArray()
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        assert(result.isEmpty())
    }

    @Test
    fun test3() {
        val word = "foofoobar"
        val strings = listOf("foo", "bar").toTypedArray()
        val expected = IntArray(1)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        expected[0] = 3
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test4() {
        val word = "barfooxfoobar"
        val strings = listOf("foo", "bar").toTypedArray()
        val expected = IntArray(2)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        expected[0] = 0
        expected[1] = 7
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test5() {
        val word = "ababc"
        val strings = listOf("a", "b", "c").toTypedArray()
        val expected = IntArray(1)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        expected[0] = 2
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test6() {
        val word = "abac"
        val strings = listOf("a", "b", "c").toTypedArray()
        val expected = IntArray(1)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        expected[0] = 1
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test7() {
        val word = ""
        val strings = listOf("a", "b", "c").toTypedArray()
        val expected = IntArray(0)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test8() {
        val word = "aabaa"
        val strings = listOf("a", "a", "a").toTypedArray()
        val expected = IntArray(0)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test9() {
        val word = "aabaaabaa"
        val strings = listOf("a", "a", "a").toTypedArray()
        val expected = IntArray(1)
        expected[0] = 3
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test10_BS_Overlap() {
        val word = "barfoofoobarthefoobarman"
        val strings = listOf("bar","foo","the").toTypedArray()
        val expected = mutableListOf<Int>()
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        expected.add(6)
        expected.add(9)
        expected.add(12)
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }

    @Test
    fun test11_EMPTY_INPUT() {
        val word = ""
        val strings = listOf<String>().toTypedArray()
        val expected = IntArray(0)
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }
    
    @Test
    fun test12_BIG_OBSTACLE() {
        val word = "aaaaaaaa"
        val strings = listOf("aa","aa","aa").toTypedArray()
        val expected = mutableListOf<Int>()
        val result = MixedWordsConcatenated.findSubstring(word, strings)
        expected.add(0)
        expected.add(1)
        expected.add(2)
        assert(result.size == expected.size)
        assert(result.containsAll(expected.toList()))
    }
}