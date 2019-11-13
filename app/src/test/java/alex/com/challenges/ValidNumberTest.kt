package alex.com.challenges

import org.junit.Assert.assertFalse
import org.junit.Test

class ValidNumberTest {

    @Test
    fun testInputs() {

        assert(ValidNumber.isNumber("0"))
        assert(ValidNumber.isNumber("0.1"))
        assert(ValidNumber.isNumber("2e10"))
        assert(ValidNumber.isNumber("   -90e3   "))
        assert(ValidNumber.isNumber("6e-1"))
        assert(ValidNumber.isNumber("53.5e93"))

        assertFalse(ValidNumber.isNumber("abc"))
        assertFalse(ValidNumber.isNumber("1 a"))
        assertFalse(ValidNumber.isNumber("1e"))
        assertFalse(ValidNumber.isNumber("e3"))
        assertFalse(ValidNumber.isNumber("99e2.5"))
        assertFalse(ValidNumber.isNumber("--6"))
        assertFalse(ValidNumber.isNumber("-+3"))
        assertFalse(ValidNumber.isNumber("95a54e53"))

        // Added test cases
        assert(ValidNumber.isNumber("44e000000000000000000001"))

        assertFalse(ValidNumber.isNumber("1e."))
        assertFalse(ValidNumber.isNumber("6e6.5"))
    }

    @Test
    fun testInputs2() {
        // Test cases
        assert(ValidNumber.isNumber("44e016912630333"))
    }
}