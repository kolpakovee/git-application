package ru.kolpakovee.arcanegaming.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kolpakovee.arcanegaming.network.GitService

interface AppContainer {
    val repoRepository: RepoRepository
    val userRepository: UserRepository
    val contentRepository: ContentRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://api.github.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: GitService by lazy {
        retrofit.create(GitService::class.java)
    }

    override val repoRepository: RepoRepository by lazy {
        NetworkRepoRepository(retrofitService)
    }

    override val userRepository: UserRepository by lazy {
        NetworkUserRepository(retrofitService)
    }

    override val contentRepository: ContentRepository by lazy {
        NetworkContentRepository(retrofitService)
    }
}