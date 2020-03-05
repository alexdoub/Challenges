package alex.com.challenges

import alex.com.challenges.cs.IntegerDivision
import org.junit.Test

class IntegerDivisionTest {

    @Test
    fun test_basic_positive() {
        assert(IntegerDivision.divide(1, 1) == 1)
        assert(IntegerDivision.divide(2, 1) == 2)
        assert(IntegerDivision.divide(3, 1) == 3)
        assert(IntegerDivision.divide(2, 2) == 1)
        assert(IntegerDivision.divide(3, 2) == 1)
        assert(IntegerDivision.divide(4, 2) == 2)
        assert(IntegerDivision.divide(5, 2) == 2)
        assert(IntegerDivision.divide(6, 2) == 3)
    }

    @Test
    fun test_basic_negative_dividend() {
        assert(IntegerDivision.divide(-1, 1) == -1)
        assert(IntegerDivision.divide(-2, 1) == -2)
        assert(IntegerDivision.divide(-3, 1) == -3)
        assert(IntegerDivision.divide(-2, 2) == -1)
        assert(IntegerDivision.divide(-3, 2) == -1)
        assert(IntegerDivision.divide(-4, 2) == -2)
        assert(IntegerDivision.divide(-5, 2) == -2)
        assert(IntegerDivision.divide(-6, 2) == -3)
    }

    @Test
    fun test_basic_negative_divisor() {
        assert(IntegerDivision.divide(1, -1) == -1)
        assert(IntegerDivision.divide(2, -1) == -2)
        assert(IntegerDivision.divide(3, -1) == -3)
        assert(IntegerDivision.divide(2, -2) == -1)
        assert(IntegerDivision.divide(3, -2) == -1)
        assert(IntegerDivision.divide(4, -2) == -2)
        assert(IntegerDivision.divide(5, -2) == -2)
        assert(IntegerDivision.divide(6, -2) == -3)
    }

    @Test
    fun test_basic_negative_both() {
        assert(IntegerDivision.divide(-1, -1) == 1)
        assert(IntegerDivision.divide(-2, -1) == 2)
        assert(IntegerDivision.divide(-3, -1) == 3)
        assert(IntegerDivision.divide(-2, -2) == 1)
        assert(IntegerDivision.divide(-3, -2) == 1)
        assert(IntegerDivision.divide(-4, -2) == 2)
        assert(IntegerDivision.divide(-5, -2) == 2)
        assert(IntegerDivision.divide(-6, -2) == 3)
    }

    @Test
    fun test_large() {
        assert(IntegerDivision.divide(Int.MAX_VALUE, 1) == Int.MAX_VALUE)
    }

    @Test
    fun test_large2() {
        assert(IntegerDivision.divide(1, Int.MAX_VALUE) == 0)
    }

    @Test
    fun test_large3() {
        assert(IntegerDivision.divide(Int.MAX_VALUE, Int.MAX_VALUE) == 1)
    }

    @Test
    fun test_large_neg1() {
        assert(IntegerDivision.divide(1, Int.MIN_VALUE) == 0)
    }

    @Test
    fun test_large_neg2() {
        assert(IntegerDivision.divide(Int.MIN_VALUE, 1) == Int.MIN_VALUE)
    }

    @Test
    fun test_large_neg2_neg() {
        assert(IntegerDivision.divide(Int.MIN_VALUE, -1) == Int.MAX_VALUE)
    }

    @Test
    fun test_large_neg3() {
        assert(IntegerDivision.divide(Int.MIN_VALUE, Int.MIN_VALUE) == 1)
    }
}