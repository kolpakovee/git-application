package ru.kolpakovee.arcanegaming.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.kolpakovee.arcanegaming.data.GitItem
import ru.kolpakovee.arcanegaming.data.Repository
import ru.kolpakovee.arcanegaming.data.User
import ru.kolpakovee.arcanegaming.ui.components.RepositoryCard
import ru.kolpakovee.arcanegaming.ui.components.UserCard
import ru.kolpakovee.arcanegaming.ui.components.SearchLine

@Composable
fun ListScreen(
    items: List<GitItem>,
    modifier: Modifier,
    onUserClicked: (User) -> Unit,
    onSearchClicked: (String) -> Unit,
    onRepositoryClicked: (Repository) -> Unit,
    onTextChanged: (String) -> Unit,
    text: String
) {
    Column {
        SearchLine(onSearchClicked, onTextChanged, text)

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp)
        ) {
            items(items) { item ->
                when (item) {
                    is Repository -> RepositoryCard(
                        repository = item,
                        onRepositoryClicked = onRepositoryClicked,
                    )

                    is User -> UserCard(
                        user = item,
                        onUserClicked = onUserClicked
                    )
                }
            }
        }
    }
}