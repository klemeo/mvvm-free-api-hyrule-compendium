package ru.android.hyrulecompendiummvvm.data.model.hyrule_responses

import com.google.gson.annotations.SerializedName

data class HyruleDataResponses(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("common_locations")
    val commonLocations: List<String>?,
    @SerializedName("attack")
    val attack: Int?,
    @SerializedName("defense")
    val defense: Int?,
    @SerializedName("drops")
    val drops: List<String>?,
    @SerializedName("cooking_effect")
    val cookingEffect: String?,
    @SerializedName("hearts_recovered")
    val heartsRecovered: Double?
)