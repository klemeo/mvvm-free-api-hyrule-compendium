package ru.android.hyrulecompendiummvvm.presentation

interface MainActivityContract : CategoryScreen

interface CategoryScreen {
    fun openCategoryScreen(category: String)
}