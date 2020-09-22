package com.patrick.cathayholding_android

import android.app.Application
import android.content.Context
import com.patrick.cathayholding_android.data.source.CathayHoldingRepository
import com.patrick.cathayholding_android.util.ServiceLocator
import kotlin.properties.Delegates

class CathayHoldingApplication : Application() {
    val repository: CathayHoldingRepository
        get() = ServiceLocator.provideRepository(this)

    companion object {
        var instance: CathayHoldingApplication by Delegates.notNull()
        lateinit var appContext: Context

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
    }

    fun isLiveDataDesign() = true
}