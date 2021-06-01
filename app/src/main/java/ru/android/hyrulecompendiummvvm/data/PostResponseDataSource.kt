package ru.android.hyrulecompendiummvvm.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.android.hyrulecompendiummvvm.data.model.hyrule_responses.HyruleInfoResponses

class PostResponseDataSource {

    fun getCategory(category: String): Flow<HyruleInfoResponses> = flow {
        emit(
            PostApiClient.getApiClient().getCategory(category)
        )
    }

}