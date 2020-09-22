package com.patrick.cathayholding_android.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.patrick.cathayholding_android.CathayHoldingApplication

object Util {

    fun isInternetConnected(): Boolean {
        val cm = CathayHoldingApplication.instance
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    fun getString(resourceId: Int): String {
        return CathayHoldingApplication.instance.getString(resourceId)
    }

    fun getColor(resourceId: Int): Int {
        return CathayHoldingApplication.instance.getColor(resourceId)
    }
}