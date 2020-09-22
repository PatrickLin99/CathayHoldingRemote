package com.patrick.cathayholding_android.data.source.remote

import com.patrick.cathayholding_android.Logger
import com.patrick.cathayholding_android.R
import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.data.source.CathayHoldingDataSource
import com.patrick.cathayholding_android.network.Api
import com.patrick.cathayholding_android.util.Util.isInternetConnected
import com.patrick.cathayholding_android.data.Result
import com.patrick.cathayholding_android.data.Plant
import com.patrick.cathayholding_android.util.Util.getString


object CathayHoldingRemoteDataSource : CathayHoldingDataSource {

    override suspend fun getApiAreas(): Result<DisplayArea> {
        if (!isInternetConnected()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            val result = Api.retrofitService.getApiAreas()

            result.error?.let {
                return@let Result.Fail(it)
            }
            Result.Success(result)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }

    override suspend fun getApiPlant(animalArea: String): Result<Plant> {
        if (!isInternetConnected()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            val result = Api.retrofitService.getApiPlant(test = animalArea)

            result.error?.let {
                return@let Result.Fail(it)
            }
            Result.Success(result)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }
}