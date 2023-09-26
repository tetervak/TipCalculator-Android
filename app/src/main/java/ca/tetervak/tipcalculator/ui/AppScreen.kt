package ca.tetervak.tipcalculator.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.tipcalculator.ui.calculator.CalculatorScreen
import ca.tetervak.tipcalculator.ui.calculator.CalculatorViewModel

@Composable
fun AppScreen(){

    val viewModel: CalculatorViewModel = viewModel()

    CalculatorScreen(viewModel)
}