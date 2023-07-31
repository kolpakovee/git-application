package ru.kolpakovee.arcanegaming.data

import ru.kolpakovee.arcanegaming.network.GitService

interface RepoRepository {
    suspend fun getRepositories(query: String): List<Repository>
}

class NetworkRepoRepository(
    private val gitService: GitService
) : RepoRepository {

    override suspend fun getRepositories(query: String): List<Repository> =
        gitService.repositorySearch(query).items.map { item ->
            Repository(
                name = item.name,
                description = item.description,
                forksCount = item.forksCount,
                htmlUrl = item.htmlUrl,
                owner = item.owner?.login
            )
        }
}