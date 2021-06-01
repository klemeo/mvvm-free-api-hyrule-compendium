package ru.android.hyrulecompendiummvvm.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.android.hyrulecompendiummvvm.data.mapper.HyruleInfoDataMapper
import ru.android.hyrulecompendiummvvm.data.model.hyrule_body.HyruleInfoBody
import ru.android.hyrulecompendiummvvm.domain.ApiRepository

class ApiRepositoryImpl(
    private val apiResponseDataSource: PostResponseDataSource
) : ApiRepository {

    private val hyruleInfoDataMapper by lazy { HyruleInfoDataMapper() }

    override fun getCategory(category: String): Flow<HyruleInfoBody> =
        apiResponseDataSource.getCategory(category).map {
            hyruleInfoDataMapper.map(it)
        }

}