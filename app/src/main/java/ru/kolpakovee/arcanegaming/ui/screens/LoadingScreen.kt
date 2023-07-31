package ru.kolpakovee.arcanegaming.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.kolpakovee.arcanegaming.ui.components.ProgressComponent

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ProgressComponent()
    }
}
