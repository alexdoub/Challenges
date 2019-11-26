package alex.com.challenges

import alex.com.challenges.dynamic.DiceRollsWithTargetSum
import org.junit.Test

/**
 * Created by Alex Doub on 11/25/2019.
 */

class DiceRollsWithTargetSumTest {
    @Test
    fun test1() {
        assert(1 == DiceRollsWithTargetSum.numRollsToTarget(d = 1, f = 6, target = 3))
    }

    @Test
    fun test2() {
        assert(6 == DiceRollsWithTargetSum.numRollsToTarget(d = 2, f = 6, target = 7))
    }

    @Test
    fun test3() {
        assert(1 == DiceRollsWithTargetSum.numRollsToTarget(d = 2, f = 5, target = 10))
    }

    @Test
    fun test4() {
        assert(0 == DiceRollsWithTargetSum.numRollsToTarget(d = 1, f = 2, target = 3))
    }

    @Test
    fun test5() {
        assert(222616187 == DiceRollsWithTargetSum.numRollsToTarget(d = 30, f = 30, target = 500))
    }
}
