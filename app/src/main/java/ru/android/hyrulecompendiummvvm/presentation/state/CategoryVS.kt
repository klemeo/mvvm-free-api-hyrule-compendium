package ru.android.hyrulecompendiummvvm.presentation.state

import ru.android.hyrulecompendiummvvm.presentation.model.HyruleInfo

sealed class CategoryVS {
    class AddCategory(val categoryVM: HyruleInfo) : CategoryVS()
    class Error(val message: String?) : CategoryVS()
    class ShowLoader(val showLoader: Boolean) : CategoryVS()
}
