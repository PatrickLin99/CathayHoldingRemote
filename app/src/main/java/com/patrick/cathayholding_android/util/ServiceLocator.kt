package com.patrick.cathayholding_android.util

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.patrick.cathayholding_android.data.source.CathayHoldingDataSource
import com.patrick.cathayholding_android.data.source.CathayHoldingRepository
import com.patrick.cathayholding_android.data.source.DefaultCathayHoldingRepository
import com.patrick.cathayholding_android.data.source.local.CathayHoldingLocalDataSource
import com.patrick.cathayholding_android.data.source.remote.CathayHoldingRemoteDataSource

object ServiceLocator {

    @Volatile
    var repository: CathayHoldingRepository? = null
        @VisibleForTesting set

    fun provideRepository(context: Context): CathayHoldingRepository {
        synchronized(this) {
            return repository
                ?: repository
                ?: createPublisherRepository(context)
        }
    }

    private fun createPublisherRepository(context: Context): CathayHoldingRepository {
        return DefaultCathayHoldingRepository(
            CathayHoldingRemoteDataSource,
            createLocalDataSource(context)
        )
    }

    private fun createLocalDataSource(context: Context): CathayHoldingDataSource {
        return CathayHoldingLocalDataSource(context)
    }
}