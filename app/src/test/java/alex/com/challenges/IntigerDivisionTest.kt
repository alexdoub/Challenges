package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

class IntigerDivisionTest {
    @Test
    fun test() {
        assert(IntegerDivision.divide(10, 3) == 3)
        assert(IntegerDivision.divide(7, -3) == -2)
        assert(IntegerDivision.divide(Int.MAX_VALUE, 1) == Int.MAX_VALUE)
        
        // real test case... min -> min
        assertEquals(-2147483648, IntegerDivision.divide(-2147483648, 1))

        // real test case... inverted min -> max
        assertEquals(2147483647, IntegerDivision.divide(-2147483648, -1))
    }
}