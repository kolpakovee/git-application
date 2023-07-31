package ru.kolpakovee.arcanegaming.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.kolpakovee.arcanegaming.GitApplication
import ru.kolpakovee.arcanegaming.data.Content
import ru.kolpakovee.arcanegaming.data.ContentRepository
import ru.kolpakovee.arcanegaming.data.GitItem
import ru.kolpakovee.arcanegaming.data.RepoRepository
import ru.kolpakovee.arcanegaming.data.UserRepository
import java.io.IOException

sealed interface GitUIState {
    data class Success(val gitSearch: List<GitItem>) : GitUIState
    data class GitContent(val contents: List<Content>) : GitUIState
    object Error : GitUIState
    object Loading : GitUIState
}

class GitViewModel(
    private val repoRepository: RepoRepository,
    private val userRepository: UserRepository,
    private val contentRepository: ContentRepository

) : ViewModel() {

    var gitUIState: GitUIState by mutableStateOf(GitUIState.Loading)
        private set

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")

    val searchTextState: State<String> = _searchTextState

    fun updateSearchTextState(text: String) {
        _searchTextState.value = text
    }

    init {
        getItems("arcane")
    }

    fun getItems(query: String) {
        viewModelScope.launch {
            gitUIState = GitUIState.Loading
            gitUIState = try {
                val usersDeferred = async { userRepository.getUsers(query) }
                val repositoriesDeferred = async { repoRepository.getRepositories(query) }

                val users = usersDeferred.await()
                val repositories = repositoriesDeferred.await()

                GitUIState.Success((users + repositories).sortedBy { it.getKey() })

            } catch (e: IOException) {
                GitUIState.Error
            } catch (e: HttpException) {
                GitUIState.Error
            }
        }
    }

    fun getContent(owner: String, path: String, repo: String) {
        viewModelScope.launch {
            gitUIState = GitUIState.Loading
            gitUIState = try {
                GitUIState.GitContent(
                    contentRepository.getContent(
                        owner = owner,
                        path = path,
                        repo = repo
                    )
                )
            } catch (e: Exception) {
                GitUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as GitApplication)
                val repoRepository = application.container.repoRepository
                val userRepository = application.container.userRepository
                val contentRepository = application.container.contentRepository
                GitViewModel(
                    repoRepository = repoRepository,
                    userRepository = userRepository,
                    contentRepository = contentRepository
                )
            }
        }
    }
}