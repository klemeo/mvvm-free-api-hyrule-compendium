package ru.android.hyrulecompendiummvvm.domain

import kotlinx.coroutines.flow.Flow
import ru.android.hyrulecompendiummvvm.data.model.hyrule_body.HyruleInfoBody

interface ApiRepository {

    fun getCategory(category: String): Flow<HyruleInfoBody>

}