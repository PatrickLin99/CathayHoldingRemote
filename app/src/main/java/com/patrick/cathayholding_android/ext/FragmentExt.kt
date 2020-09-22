package com.patrick.cathayholding_android.ext

import androidx.fragment.app.Fragment
import com.patrick.cathayholding_android.CathayHoldingApplication
import com.patrick.cathayholding_android.factory.*
import com.patrick.cathayholding_android.data.*

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as CathayHoldingApplication).repository
    return ViewModelFactory(repository)
}