package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.tipcalculator.R
import java.text.NumberFormat

@Composable
fun CalculatorOutputs(tipAmount: Double, billTotal: Double) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = stringResource(R.string.tip_amount_label),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .sizeIn(minWidth = 112.dp)
                        .wrapContentWidth(align = Alignment.End)
                )
                Text(
                    text = formatCurrency(amount = tipAmount),
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.purple_500)
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.bill_total_label),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .sizeIn(minWidth = 112.dp)
                        .wrapContentWidth(align = Alignment.End)
                )
                Text(
                    text = formatCurrency(amount = billTotal),
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.purple_500)
                )
            }
        }
    }
}

fun formatCurrency(amount: Double): String =
    NumberFormat.getCurrencyInstance().format(amount)

@Preview
@Composable
fun CalculatorOutputsPreview() {
    CalculatorOutputs(tipAmount = 18.0, billTotal = 118.0)
}

