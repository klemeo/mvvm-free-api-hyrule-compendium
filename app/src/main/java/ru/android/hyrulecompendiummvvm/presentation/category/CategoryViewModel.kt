package ru.android.hyrulecompendiummvvm.presentation.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.android.hyrulecompendiummvvm.base.platform.BaseViewModel
import ru.android.hyrulecompendiummvvm.base.utils.io
import ru.android.hyrulecompendiummvvm.base.utils.ui
import ru.android.hyrulecompendiummvvm.domain.interactor.HyruleInfoInteractor
import ru.android.hyrulecompendiummvvm.presentation.mapper.CategoryVMMapper
import ru.android.hyrulecompendiummvvm.presentation.state.CategoryVS

class CategoryViewModel(
    private val categoryInteractor: HyruleInfoInteractor
) : BaseViewModel() {

    val viewCategoryState: LiveData<CategoryVS> get() = mViewCategoryState
    private val mViewCategoryState = MutableLiveData<CategoryVS>()

    private val categoryMapper by lazy { CategoryVMMapper() }

    fun getCategory(category: String) {
        viewModelScope.launch {
            mViewCategoryState.value = CategoryVS.ShowLoader(true)
            try {
                io {
                    categoryInteractor.execute(
                        HyruleInfoInteractor.Params(
                            category = category
                        )
                    )
                        .collect {
                            ui {
                                mViewCategoryState.value =
                                    CategoryVS.AddCategory(categoryMapper.map(it))
                            }
                        }
                }
            } catch (e: Exception) {
                ui {
                    mViewCategoryState.value = CategoryVS.Error(e.message)
                }
            }
            mViewCategoryState.value = CategoryVS.ShowLoader(false)
        }
    }

}