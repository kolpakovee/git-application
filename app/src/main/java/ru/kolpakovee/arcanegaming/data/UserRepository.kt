package ru.kolpakovee.arcanegaming.data

import ru.kolpakovee.arcanegaming.network.GitService

interface UserRepository {
    suspend fun getUsers(query: String): List<User>
}

class NetworkUserRepository(
    private val gitService: GitService
) : UserRepository {

    override suspend fun getUsers(query: String): List<User> =
        gitService.userSearch(query).items.map { item ->
            User(
                login = item.login,
                score = item.score,
                avatarUrl = item.avatarUrl,
                htmlUrl = item.htmlUrl
            )
        }
}

