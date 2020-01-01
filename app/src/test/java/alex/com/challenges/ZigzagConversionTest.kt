package alex.com.challenges

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Alex Doub on 12/31/2019.
 */

class ZigzagConversionTest {
    @Test
    fun test1() {
        assertEquals("PINALSIGYAHRPI", ZigzagConversion.convert("PAYPALISHIRING", 4))
    }

    @Test
    fun test2() {
        assertEquals("PAHNAPLSIIGYIR", ZigzagConversion.convert("PAYPALISHIRING", 3))
    }


    @Test
    fun test3() {
        assertEquals("PAYPALISHIRING", ZigzagConversion.convert("PAYPALISHIRING", 1))
    }
}