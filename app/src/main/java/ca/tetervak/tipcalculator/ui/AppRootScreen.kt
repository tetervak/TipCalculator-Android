package ca.tetervak.tipcalculator.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import ca.tetervak.tipcalculator.R
import ca.tetervak.tipcalculator.ui.calculator.CalculatorBody
import ca.tetervak.tipcalculator.ui.calculator.CalculatorTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRootScreen() {

    var showAboutDialog: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            CalculatorTopBar(
                onHelpButtonClick = { showAboutDialog = true },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        CalculatorBody(
            modifier = Modifier.padding(innerPadding)
        )
    }

    if (showAboutDialog) {
        CalculatorAbout(onDismissRequest = { showAboutDialog = false })
    }
}

@Composable
fun CalculatorAbout(onDismissRequest: () -> Unit) =
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(stringResource(R.string.about_calculator)) },
        text = {
            Text(
                text = stringResource(R.string.programming_example),
                fontSize = 18.sp
            )
        },
        confirmButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text(stringResource(R.string.ok))
            }
        }
    )