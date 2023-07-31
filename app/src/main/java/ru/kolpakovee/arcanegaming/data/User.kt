package ru.kolpakovee.arcanegaming.data

data class User(
    val login: String?,
    val score: Int?,
    val avatarUrl: String?,
    val htmlUrl: String?
) : GitItem {
    override fun getKey(): String? = login
}