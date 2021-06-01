package ru.android.hyrulecompendiummvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import ru.android.hyrulecompendiummvvm.presentation.MainActivityContract

class MainActivity : AppCompatActivity(), MainActivityContract {

    private val navHostFragmentId = R.id.main_nav_host_fragment
    private val navController by lazy { findNavController(navHostFragmentId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun openCategoryScreen(category: String) {
        TODO("Not yet implemented")
    }

}