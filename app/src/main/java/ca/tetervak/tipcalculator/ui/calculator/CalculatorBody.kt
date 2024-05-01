package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.tetervak.tipcalculator.domain.ServiceQuality
import ca.tetervak.tipcalculator.domain.calculateTip

@Composable
@Preview
fun CalculatorBody(modifier: Modifier = Modifier) {

    var serviceCost: String by remember {
        mutableStateOf("")
    }

    var serviceQuality: ServiceQuality by remember {
        mutableStateOf(ServiceQuality.GOOD)
    }

    var roundUpTip: Boolean by remember {
        mutableStateOf(true)
    }

    val billBeforeTip = billBeforeTip(serviceCost)

    val tipAmount = calculateTip(
        billBeforeTip = billBeforeTip,
        serviceQuality = serviceQuality,
        roundUpTip = roundUpTip
    )

    val billTotal = billBeforeTip + tipAmount

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalculatorInputs(
            roundUpTip = roundUpTip,
            onChangeOfRoundUpTip = { roundUpTip = it },
            serviceCost = serviceCost,
            onChangeOfServiceCost = { serviceCost = it },
            serviceQuality = serviceQuality,
            onChangeOfServiceQuality = { serviceQuality = it }
        )
        CalculatorOutputs(
            tipAmount = tipAmount,
            billTotal = billTotal
        )
    }
}

private fun billBeforeTip(entered: String): Double {
    val value = entered.toDoubleOrNull() ?: 0.0
    return if(value < 0.0) 0.0 else value
}
