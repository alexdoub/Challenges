package alex.com.challenges

import org.junit.Assert.assertFalse
import org.junit.Test

class IsNumberTest {

    @Test
    fun testInputs() {

        assert(IsNumber.isNumber("0"))
        assert(IsNumber.isNumber("0.1"))
        assert(IsNumber.isNumber("2e10"))
        assert(IsNumber.isNumber("   -90e3   "))
        assert(IsNumber.isNumber("6e-1"))
        assert(IsNumber.isNumber("53.5e93"))

        assertFalse(IsNumber.isNumber("abc"))
        assertFalse(IsNumber.isNumber("1 a"))
        assertFalse(IsNumber.isNumber("1e"))
        assertFalse(IsNumber.isNumber("e3"))
        assertFalse(IsNumber.isNumber("99e2.5"))
        assertFalse(IsNumber.isNumber("--6"))
        assertFalse(IsNumber.isNumber("-+3"))
        assertFalse(IsNumber.isNumber("95a54e53"))

        // Added test cases
        assert(IsNumber.isNumber("44e000000000000000000001"))

        assertFalse(IsNumber.isNumber("1e."))
        assertFalse(IsNumber.isNumber("6e6.5"))
    }

    @Test
    fun testInputs2() {
        // Test cases
        assert(IsNumber.isNumber("44e016912630333"))
    }
}