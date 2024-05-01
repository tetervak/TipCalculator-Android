package ca.tetervak.tipcalculator.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tetervak.tipcalculator.ui.calculator.CalculatorBody
import ca.tetervak.tipcalculator.ui.calculator.CalculatorTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRootScreen(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = { CalculatorTopBar(scrollBehavior) },
        modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        CalculatorBody(
            viewModel = viewModel(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}