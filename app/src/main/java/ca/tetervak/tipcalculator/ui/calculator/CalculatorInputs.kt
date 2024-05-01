package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.tipcalculator.R
import ca.tetervak.tipcalculator.domain.ServiceQuality

@Composable
fun CalculatorInputs(
    roundUpTip: Boolean, onChangeOfRoundUpTip: (Boolean) -> Unit,
    serviceCost: String, onChangeOfServiceCost: (String) -> Unit,
    serviceQuality: ServiceQuality, onChangeOfServiceQuality: (ServiceQuality) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            ServiceCostInput(
                serviceCost = serviceCost,
                onChange = onChangeOfServiceCost
            )
            ServiceQualityInput(
                serviceQuality = serviceQuality,
                onChange = onChangeOfServiceQuality
            )
            RoundUpTipInput(
                roundUpTip = roundUpTip,
                onChange = onChangeOfRoundUpTip
            )
        }

    }
}

@Composable
fun RoundUpTipInput(roundUpTip: Boolean, onChange: (Boolean) -> Unit) {

    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.round_up_tip_input_label),
            fontSize = 20.sp
        )
        Switch(
            checked = roundUpTip,
            onCheckedChange = onChange,
        )
    }
}

@Composable
fun ServiceQualityInput(serviceQuality: ServiceQuality, onChange: (ServiceQuality) -> Unit) {
    Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
        Text(
            text = stringResource(R.string.service_quality_input_label),
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onChange(ServiceQuality.AMAZING) }
        ) {
            RadioButton(
                selected = serviceQuality == ServiceQuality.AMAZING,
                onClick = null,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = stringResource(id = R.string.quality_amazing_label),
                fontSize = 18.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onChange(ServiceQuality.GOOD) }
        ) {
            RadioButton(
                selected = serviceQuality == ServiceQuality.GOOD,
                onClick = null,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = stringResource(id = R.string.quality_good_label),
                fontSize = 18.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onChange(ServiceQuality.OK) }
        ) {
            RadioButton(
                selected = serviceQuality == ServiceQuality.OK,
                onClick = null,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = stringResource(id = R.string.quality_okay_label),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun ServiceCostInput(serviceCost: String, onChange: (String) -> Unit) {
    TextField(
        label = { Text(text = stringResource(id = R.string.service_cost_label)) },
        value = serviceCost,
        onValueChange = onChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = TextStyle.Default.copy(
            fontSize = 20.sp,
            color = colorResource(id = R.color.purple_500)
        ),
        modifier = Modifier
            .padding(16.dp)
            .sizeIn(minWidth = 256.dp)
    )
}

@Preview
@Composable
fun CalculatorInputsPreview() {
    CalculatorInputs(
        roundUpTip = true,
        onChangeOfRoundUpTip = {},
        serviceCost = "100",
        onChangeOfServiceCost = {},
        serviceQuality = ServiceQuality.GOOD,
        onChangeOfServiceQuality = {}
    )
}
