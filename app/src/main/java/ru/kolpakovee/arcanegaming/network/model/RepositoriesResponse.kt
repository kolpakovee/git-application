package ru.kolpakovee.arcanegaming.network.model

import com.google.gson.annotations.SerializedName


data class RepositoriesResponse (
  @SerializedName("total_count"        ) var totalCount        : Int?             = null,
  @SerializedName("incomplete_results" ) var incompleteResults : Boolean?         = null,
  @SerializedName("items"              ) var items             : ArrayList<RepositoryItems> = arrayListOf()
)