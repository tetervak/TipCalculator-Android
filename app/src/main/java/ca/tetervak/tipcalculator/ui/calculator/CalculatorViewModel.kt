package ca.tetervak.tipcalculator.ui.calculator

import androidx.lifecycle.ViewModel
import ca.tetervak.tipcalculator.domain.ServiceQuality
import ca.tetervak.tipcalculator.domain.calculateTip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<CalculatorUiState> =
        MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState

    fun onChangeOfRoundUpTip(newRoundUpTip: Boolean) {
        _uiState.update { state ->
            val billBeforeTip = billBeforeTip(state.serviceCost)
            val newTipAmount = calculateTip(
                billBeforeTip = billBeforeTip,
                serviceQuality = state.serviceQuality,
                roundUpTip = newRoundUpTip
            )
            state.copy(
                roundUpTip = newRoundUpTip,
                tipAmount = newTipAmount,
                billTotal = billBeforeTip + newTipAmount
            )
        }

    }

    fun onChangeOfServiceCost(newServiceCost: String) {
        _uiState.update { state ->
            val billBeforeTip = billBeforeTip(newServiceCost)
            val newTipAmount = calculateTip(
                billBeforeTip = billBeforeTip,
                serviceQuality = state.serviceQuality,
                roundUpTip = state.roundUpTip
            )
            state.copy(
                serviceCost = newServiceCost,
                tipAmount = newTipAmount,
                billTotal = billBeforeTip + newTipAmount
            )
        }
    }

    fun onChangeOfServiceQuality(newServiceQuality: ServiceQuality) {
        _uiState.update { state ->
            val billBeforeTip = billBeforeTip(state.serviceCost)
            val newTipAmount = calculateTip(
                billBeforeTip = billBeforeTip,
                serviceQuality = newServiceQuality,
                roundUpTip = state.roundUpTip
            )
            state.copy(
                serviceQuality = newServiceQuality,
                tipAmount = newTipAmount,
                billTotal = billBeforeTip + newTipAmount
            )
        }
    }

    private fun billBeforeTip(entered: String): Double {
        val value = entered.toDoubleOrNull() ?: 0.0
        return if(value < 0.0) 0.0 else value
    }
}