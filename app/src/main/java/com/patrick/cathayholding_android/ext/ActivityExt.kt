package com.patrick.cathayholding_android.ext

import android.app.Activity
import android.view.Gravity
import android.widget.Toast
import com.patrick.cathayholding_android.CathayHoldingApplication
import com.patrick.cathayholding_android.factory.ViewModelFactory

fun Activity.getVmFactory(): ViewModelFactory {
    val repository = (applicationContext as CathayHoldingApplication).repository
    return ViewModelFactory(repository)
}

fun Activity?.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).apply {
        setGravity(Gravity.CENTER, 0, 0)
        show()
    }
}