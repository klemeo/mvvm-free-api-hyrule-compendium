package ru.android.hyrulecompendiummvvm.app

import org.koin.dsl.module
import ru.android.hyrulecompendiummvvm.data.ApiRepositoryImpl
import ru.android.hyrulecompendiummvvm.data.PostResponseDataSource
import ru.android.hyrulecompendiummvvm.domain.ApiRepository
import ru.android.hyrulecompendiummvvm.domain.interactor.HyruleInfoInteractor

private val postModule = module {

    //region ViewModel


    //endregion

    //region Interactor
    single {
        HyruleInfoInteractor(
            apiRepository = get()
        )
    }
    //endregion

    //region Repository
    single<ApiRepository> {
        ApiRepositoryImpl(
            apiResponseDataSource = get()
        )
    }
    //endregion

    //region Datastore
    single {
        PostResponseDataSource()
    }
    //endregion
}

val modules = listOf(postModule)