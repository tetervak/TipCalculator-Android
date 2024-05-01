package ca.tetervak.tipcalculator.ui.calculator

import ca.tetervak.tipcalculator.domain.ServiceQuality
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class CalculatorViewModelTest {

    @Before
    fun setUp() {
        println("--- testing case ---")
    }

    @After
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @Test
    fun calculateTip_Rounding(){
        println("calculate tip 18% of 10 with rounding")
        val viewModel = CalculatorViewModel()
        viewModel.onChangeOfServiceCost("10")
        viewModel.onChangeOfServiceQuality(ServiceQuality.GOOD)
        viewModel.onChangeOfRoundUpTip(true)
        assertEquals(2.0, viewModel.uiState.value.tipAmount, 0.001)
        println("tipAmount = ${viewModel.uiState.value.tipAmount}")
        assertEquals(12.0, viewModel.uiState.value.billTotal, 0.001)
        println("billTotal = ${viewModel.uiState.value.billTotal}")
    }
}