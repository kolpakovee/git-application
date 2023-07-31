package ru.kolpakovee.arcanegaming.data

import ru.kolpakovee.arcanegaming.network.GitService

interface ContentRepository {
    suspend fun getContent(
        owner: String,
        repo: String,
        path: String
    ): List<Content>
}

class NetworkContentRepository(
    private val gitService: GitService
) : ContentRepository {

    override suspend fun getContent(owner: String, repo: String, path: String): List<Content> {
        println(gitService.contentSearch(owner = owner, repo = repo, path = path))
        return gitService.contentSearch(owner, repo, path).map { item ->
            Content(
                name = item.name,
                owner = owner,
                path = item.path,
                repositoryName = repo,
                type = if (item.type == "file") FileType.FILE else FileType.DIRECTORY,
                downloadUrl = item.downloadUrl
            )
        }
    }
}