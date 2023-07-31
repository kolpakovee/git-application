package ru.kolpakovee.arcanegaming.ui

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kolpakovee.arcanegaming.data.Content
import ru.kolpakovee.arcanegaming.data.User
import ru.kolpakovee.arcanegaming.ui.components.WebViewComponent
import ru.kolpakovee.arcanegaming.ui.screens.HomeScreen

@Composable
fun GitApp(
    modifier: Modifier = Modifier,
    onUserClicked: (User) -> Unit,
    onFileClicked: (Content) -> Unit
) {
    val gitViewModel: GitViewModel =
        viewModel(factory = GitViewModel.Factory)

    HomeScreen(
        gitUIState = gitViewModel.gitUIState,
        retryAction = { gitViewModel.getItems("") },
        modifier = modifier,
        onSearchClicked = { gitViewModel.getItems(it) },
        onTextChanged = { gitViewModel.updateSearchTextState(it) },
        text = gitViewModel.searchTextState.value,
        onUserClicked = onUserClicked,
        onRepositoryClicked = {
            it.owner?.let { o ->
                it.name?.let { n ->
                    gitViewModel.getContent(
                        owner = o,
                        path = "",
                        repo = n
                    )
                }
            }
        },
        onDirectoryClicked = {
            it.owner?.let { o ->
                it.repositoryName?.let { n ->
                    it.path?.let { p ->
                        gitViewModel.getContent(
                            owner = o,
                            path = p,
                            repo = n
                        )
                    }
                }
            }
        },

        onFileClicked = onFileClicked
    )
}