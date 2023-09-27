package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ca.tetervak.tipcalculator.domain.ServiceQuality
import ca.tetervak.tipcalculator.domain.calculateTip

class CalculatorViewModel: ViewModel() {

    val serviceCost: MutableState<String> = mutableStateOf("")
    val serviceQuality: MutableState<ServiceQuality> = mutableStateOf(ServiceQuality.GOOD)
    val roundUpTip: MutableState<Boolean> = mutableStateOf(true)

    var tipAmount: Double = 0.0
    private set

    var billTotal: Double = 0.0
    private set

    private fun calculateOutputs(){
        val billBeforeTip = serviceCost.value.toDoubleOrNull() ?: 0.0
        tipAmount = calculateTip(
            billBeforeTip = billBeforeTip,
            serviceQuality = serviceQuality.value,
            roundUpTip = roundUpTip.value
        )
        billTotal = billBeforeTip + tipAmount
    }

    fun onChangeOfRoundUpTip(newRoundUpTip: Boolean) {
        roundUpTip.value = newRoundUpTip
        calculateOutputs()
    }

    fun onChangeOfServiceCost(newServiceCost: String) {
        serviceCost.value = newServiceCost
        calculateOutputs()
    }

    fun onChangeOfServiceQuality(newServiceQuality: ServiceQuality) {
        serviceQuality.value = newServiceQuality
        calculateOutputs()
    }

}