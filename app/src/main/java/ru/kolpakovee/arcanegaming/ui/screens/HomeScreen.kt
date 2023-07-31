package ru.kolpakovee.arcanegaming.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.kolpakovee.arcanegaming.data.Content
import ru.kolpakovee.arcanegaming.data.Repository
import ru.kolpakovee.arcanegaming.data.User
import ru.kolpakovee.arcanegaming.ui.GitUIState

@Composable
fun HomeScreen(
    gitUIState: GitUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onUserClicked: (User) -> Unit,
    onSearchClicked: (String) -> Unit,
    onTextChanged: (String) -> Unit,
    onRepositoryClicked: (Repository) -> Unit,
    onDirectoryClicked: (Content) -> Unit,
    onFileClicked: (Content) -> Unit,
    text: String,
) {
    when (gitUIState) {
        is GitUIState.Loading -> LoadingScreen(modifier = modifier)
        is GitUIState.Error -> ErrorScreen(
            retryAction = retryAction,
            modifier = modifier,
            "Some error"
        )

        is GitUIState.Success -> ListScreen(
            items = gitUIState.gitSearch,
            modifier = modifier,
            onUserClicked = onUserClicked,
            onSearchClicked = onSearchClicked,
            onTextChanged = onTextChanged,
            text = text,
            onRepositoryClicked = onRepositoryClicked,
        )

        is GitUIState.GitContent -> ContentScreen(
            items = gitUIState.contents,
            modifier = modifier,
            onDirectoryClicked = onDirectoryClicked,
            onFileClicked = onFileClicked
        )
    }
}