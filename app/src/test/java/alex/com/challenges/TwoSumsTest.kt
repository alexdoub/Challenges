package alex.com.challenges

import org.junit.Test

class TwoSumsTest {
    @Test
    fun test1() {
        val ints = arrayOf(1, 2, 3, 4, 5, 6).toIntArray()
        val target = 7
        val indicies = TwoSums.getIndicesToMatchTarget(ints, target)
        assert(ints[indicies[0]] + ints[indicies[1]] == target)
    }

    @Test
    fun test2() {
        val ints = arrayOf(1, 2, 3, 4, 5, 6).toIntArray()
        val target = 3
        val indicies = TwoSums.getIndicesToMatchTarget(ints, target)
        assert(ints[indicies[0]] + ints[indicies[1]] == target)
    }

    @Test
    fun test3() {
        val ints = arrayOf(11, 2, 3, 4, 5, 6).toIntArray()
        val target = 17
        val indicies = TwoSums.getIndicesToMatchTarget(ints, target)
        assert(ints[indicies[0]] + ints[indicies[1]] == target)
    }

    @Test
    fun test4() {
        val ints = arrayOf(100, 200, 300, 400, 500, 600).toIntArray()
        val target = 700
        val indicies = TwoSums.getIndicesToMatchTarget(ints, target)
        assert(ints[indicies[0]] + ints[indicies[1]] == target)
    }

    @Test
    fun test5() {
        val ints = arrayOf(500, 500).toIntArray()
        val target = 1000
        val indicies = TwoSums.getIndicesToMatchTarget(ints, target)
        assert(ints[indicies[0]] + ints[indicies[1]] == target)

        //no same index
        assert(indicies[0] != indicies[1])
    }
}