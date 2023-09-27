package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.tipcalculator.R

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {

    val uiState: CalculatorUiState by
        viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.tip_calculator_header),
            fontSize = 24.sp,
            color = colorResource(id = R.color.pink_500)
        )
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


