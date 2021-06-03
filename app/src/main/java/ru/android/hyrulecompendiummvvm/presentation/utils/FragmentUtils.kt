package ru.android.hyrulecompendiummvvm.presentation.utils

import androidx.fragment.app.Fragment
import ru.android.hyrulecompendiummvvm.presentation.category.DialogInfo

fun Fragment.showDialogNoInternet() {
    val dialog = DialogInfo()
    val manager = childFragmentManager
    dialog.show(manager, "dialogInfo")
}