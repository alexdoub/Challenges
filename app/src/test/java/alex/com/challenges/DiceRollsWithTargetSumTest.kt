package alex.com.challenges

import alex.com.challenges.dynamic.DiceRollsWithTargetSum
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 11/25/2019.
 */

class DiceRollsWithTargetSumTest {
    @Test
    fun test1() {
        assertEquals(1, DiceRollsWithTargetSum.numRollsToTarget(d = 1, f = 6, target = 3))
    }

    @Test
    fun test2() {
        assertEquals(6, DiceRollsWithTargetSum.numRollsToTarget(d = 2, f = 6, target = 7))
    }

    @Test
    fun test3() {
        assertEquals(1, DiceRollsWithTargetSum.numRollsToTarget(d = 2, f = 5, target = 10))
    }

    @Test
    fun test4() {
        assertEquals(0, DiceRollsWithTargetSum.numRollsToTarget(d = 1, f = 2, target = 3))
    }

    @Test
    fun test42() {
        assertEquals(2, DiceRollsWithTargetSum.numRollsToTarget(d = 2, f = 6, target = 3))
    }

    @Test
    fun test5() {
        assertEquals(222616187, DiceRollsWithTargetSum.numRollsToTarget(d = 30, f = 30, target = 500))
    }
}
