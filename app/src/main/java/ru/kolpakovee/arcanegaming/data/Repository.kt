package ru.kolpakovee.arcanegaming.data

data class Repository(
    val name: String?,
    val forksCount: Int?,
    val description: String?,
    val htmlUrl: String?,
    val owner: String?
) : GitItem {
    override fun getKey(): String? = name
}