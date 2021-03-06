package ru.android.hyrulecompendiummvvm.presentation.model

data class HyruleData(
    val id: Int?,
    val category: String?,
    val name: String?,
    val image: String?,
    val description: String?,
    val commonLocations: List<String>?,
    val attack: Int?,
    val defense: Int?,
    val drops: List<String>?,
    val cookingEffect: String?,
    val heartsRecovered: Double?
)