package ca.tetervak.tipcalculator.domain

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class CalculateTipKtTest {

    @Before
    fun setUp() {
        println("--- testing case ---")
    }

    @After
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @Test
    fun calculateTip_Rounding() {
        println("calculate tip 18% of 10 with rounding")
        val tipValue: Double = calculateTip(
            billBeforeTip = 10.0,
            serviceQuality = ServiceQuality.GOOD
        )
        assertEquals(2.0, tipValue,0.001)
        println("tipValue = $tipValue")
    }

    @Test
    fun calculateTip_NoRounding() {
        println("calculate tip 18% of 10 without rounding")
        val tipValue: Double = calculateTip(
            billBeforeTip = 10.0,
            serviceQuality = ServiceQuality.GOOD,
            roundUpTip = false
        )
        assertEquals(1.8, tipValue, 0.001)
        println("tipValue = $tipValue")
    }

    @Test
    fun calculateTip_Negative() {
        println("calculate tip from negative bill value")
        val calc: () -> Unit = {
            calculateTip(
                billBeforeTip = -10.0,
                serviceQuality = ServiceQuality.GOOD
            )
        }
        assertThrows(IllegalArgumentException::class.java, calc)
    }
}