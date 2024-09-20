package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ca.tetervak.tipcalculator.domain.ServiceQuality
import ca.tetervak.tipcalculator.domain.calculateTip

class CalculatorViewModel: ViewModel() {

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

    private fun recalculateOutputs(){
        val billBeforeTip: Double = serviceCost.toDoubleOrNull() ?: 0.0
        tipAmount = calculateTip(
            billBeforeTip = billBeforeTip,
            serviceQuality = serviceQuality,
            roundUpTip = roundUpTip
        )
        billTotal = billBeforeTip + tipAmount
    }

    fun updateServiceCost(newServiceCost: String){
        serviceCost = newServiceCost
        recalculateOutputs()
    }

    fun updateServiceQuality(newServiceQuality: ServiceQuality){
        serviceQuality = newServiceQuality
        recalculateOutputs()
    }

    fun updateRoundUpTip(newRoundUpTip: Boolean){
        roundUpTip = newRoundUpTip
        recalculateOutputs()
    }
}