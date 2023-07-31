package ru.kolpakovee.arcanegaming.data

data class Content(
    val name: String?,
    val path: String?,
    val type: FileType,
    val owner: String?,
    val repositoryName: String?
)

enum class FileType {
    FILE,
    DIRECTORY
}