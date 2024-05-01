package ca.tetervak.tipcalculator.ui.calculator

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import ca.tetervak.tipcalculator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorTopBar(scrollBehavior: TopAppBarScrollBehavior) = CenterAlignedTopAppBar(
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary,
    ),
    title = {
        Text(
            text = stringResource(id = R.string.tip_calculator_header),
            fontSize = 24.sp
        )
    },
    actions = {
        IconButton(
            onClick = { },
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = stringResource(R.string.menu)
            )
        }
    },
    scrollBehavior = scrollBehavior,
)