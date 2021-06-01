package ru.android.hyrulecompendiummvvm.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.android.hyrulecompendiummvvm.base.interactor.Interactor
import ru.android.hyrulecompendiummvvm.data.model.hyrule_body.HyruleInfoBody
import ru.android.hyrulecompendiummvvm.domain.ApiRepository

class HyruleInfoInteractor(
    private val apiRepository: ApiRepository
) : Interactor<HyruleInfoInteractor.Params, Flow<HyruleInfoBody>> {

    override fun execute(params: Params): Flow<HyruleInfoBody> {
        return apiRepository.getCategory(
            category = params.category
        )
    }

    data class Params(
        val category: String
    )

}