package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.tipcalculator.R
import ca.tetervak.tipcalculator.domain.ServiceQuality

@Composable
fun CalculatorBody(
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier
) {
    val serviceCost: String by viewModel.serviceCost
    val serviceQuality: ServiceQuality by viewModel.serviceQuality
    val roundUpTip: Boolean by viewModel.roundUpTip

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
            onChangeOfRoundUpTip = viewModel::onChangeOfRoundUpTip,
            serviceCost = serviceCost,
            onChangeOfServiceCost = viewModel::onChangeOfServiceCost,
            serviceQuality = serviceQuality,
            onChangeOfServiceQuality = viewModel::onChangeOfServiceQuality
        )
        CalculatorOutputs(
            tipAmount = viewModel.tipAmount,
            billTotal = viewModel.billTotal
        )
    }
}

@Composable
@Preview
fun CalculatorBodyPreview(){
    CalculatorBody(viewModel = viewModel())
}
