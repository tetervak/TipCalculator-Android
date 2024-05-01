package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculatorBody(
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier
) {
    val uiState: CalculatorUiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalculatorInputs(
            roundUpTip = uiState.roundUpTip,
            onChangeOfRoundUpTip = viewModel::onChangeOfRoundUpTip,
            serviceCost = uiState.serviceCost,
            onChangeOfServiceCost = viewModel::onChangeOfServiceCost,
            serviceQuality = uiState.serviceQuality,
            onChangeOfServiceQuality = viewModel::onChangeOfServiceQuality
        )
        CalculatorOutputs(
            tipAmount = uiState.tipAmount,
            billTotal = uiState.billTotal
        )
    }
}

@Composable
@Preview
fun CalculatorBodyPreview(){
    CalculatorBody(viewModel = viewModel())
}
