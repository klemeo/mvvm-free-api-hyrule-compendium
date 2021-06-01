package ru.android.hyrulecompendiummvvm.data.model.hyrule_responses

import com.google.gson.annotations.SerializedName

data class HyruleInfoResponses(
    @SerializedName("data")
    val data: List<HyruleDataResponses>?
)