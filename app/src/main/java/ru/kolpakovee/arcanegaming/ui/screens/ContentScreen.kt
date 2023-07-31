package ru.kolpakovee.arcanegaming.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.kolpakovee.arcanegaming.data.Content
import ru.kolpakovee.arcanegaming.ui.components.ContentCard

@Composable
fun ContentScreen(
    items: List<Content>,
    modifier: Modifier,
    onDirectoryClicked: (Content) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(items) { item ->
            ContentCard(
                content = item,
                onDirectoryClicked = onDirectoryClicked
            )
        }
    }
}