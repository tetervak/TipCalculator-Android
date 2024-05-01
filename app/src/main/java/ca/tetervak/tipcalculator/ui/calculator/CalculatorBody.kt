package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.tetervak.tipcalculator.domain.ServiceQuality
import ca.tetervak.tipcalculator.domain.calculateTip

@Composable
@Preview
fun CalculatorBody(modifier: Modifier = Modifier) {

    val serviceCost: MutableState<String> = remember {
        mutableStateOf("")
    }

    val serviceQuality: MutableState<ServiceQuality> = remember {
        mutableStateOf(ServiceQuality.GOOD)
    }

    val roundUpTip: MutableState<Boolean> = remember {
        mutableStateOf(true)
    }

    val billBeforeTip = serviceCost.value.toDoubleOrNull() ?: 0.0
    val tipAmount = calculateTip(
        billBeforeTip = billBeforeTip,
        serviceQuality = serviceQuality.value,
        roundUpTip = roundUpTip.value
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
            roundUpTip = roundUpTip.value,
            onChangeOfRoundUpTip = { roundUpTip.value = it },
            serviceCost = serviceCost.value,
            onChangeOfServiceCost = { serviceCost.value = it },
            serviceQuality = serviceQuality.value,
            onChangeOfServiceQuality = { serviceQuality.value = it }
        )
        CalculatorOutputs(
            tipAmount = tipAmount,
            billTotal = billTotal
        )
    }
}


