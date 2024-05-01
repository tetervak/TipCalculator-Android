package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ca.tetervak.tipcalculator.domain.ServiceQuality
import ca.tetervak.tipcalculator.domain.calculateTip

class CalculatorViewModel : ViewModel() {

    var serviceCost: String by mutableStateOf("")
        private set

    var serviceQuality: ServiceQuality by mutableStateOf(ServiceQuality.GOOD)
        private set

    var roundUpTip: Boolean by mutableStateOf(true)
        private set

    var tipAmount: Double = 0.0
        private set

    var billTotal: Double = 0.0
        private set

    private fun calculateOutputs() {
        val billBeforeTip = billBeforeTip(serviceCost)
        tipAmount = calculateTip(
            billBeforeTip = billBeforeTip,
            serviceQuality = serviceQuality,
            roundUpTip = roundUpTip
        )
        billTotal = billBeforeTip + tipAmount
    }

    fun onChangeOfRoundUpTip(newRoundUpTip: Boolean) {
        roundUpTip = newRoundUpTip
        calculateOutputs()
    }

    fun onChangeOfServiceCost(newServiceCost: String) {
        serviceCost = newServiceCost
        calculateOutputs()
    }

    fun onChangeOfServiceQuality(newServiceQuality: ServiceQuality) {
        serviceQuality = newServiceQuality
        calculateOutputs()
    }

    private fun billBeforeTip(entered: String): Double {
        val value = entered.toDoubleOrNull() ?: 0.0
        return if(value < 0.0) 0.0 else value
    }
}