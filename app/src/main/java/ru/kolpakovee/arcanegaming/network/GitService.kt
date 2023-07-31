package ru.kolpakovee.arcanegaming.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kolpakovee.arcanegaming.network.model.ContentResponse
import ru.kolpakovee.arcanegaming.network.model.RepositoriesResponse
import ru.kolpakovee.arcanegaming.network.model.UserResponse

interface GitService {

    @GET("search/repositories")
    suspend fun repositorySearch(@Query("q") searchQuery: String): RepositoriesResponse

    @GET("search/users")
    suspend fun userSearch(@Query("q") searchQuery: String) : UserResponse

    @GET("repos/{owner}/{repo}/contents/{path}")
    suspend fun contentSearch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("path") path: String
    ): List<ContentResponse>
}