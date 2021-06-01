package ru.android.hyrulecompendiummvvm.data

import retrofit2.http.*
import ru.android.hyrulecompendiummvvm.data.model.hyrule_responses.HyruleInfoResponses

interface ApiServices {

    @GET("category/{category}")
    suspend fun getCategory(
        @Path("category") category: String
    ): HyruleInfoResponses


}