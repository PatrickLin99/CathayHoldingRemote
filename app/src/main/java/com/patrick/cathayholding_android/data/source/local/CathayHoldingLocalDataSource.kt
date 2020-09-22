package com.patrick.cathayholding_android.data.source.local

import android.content.Context
import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.data.Result
import com.patrick.cathayholding_android.data.source.CathayHoldingDataSource
import com.patrick.cathayholding_android.data.Plant

class CathayHoldingLocalDataSource(val context: Context) : CathayHoldingDataSource {
    override suspend fun getApiAreas(): Result<DisplayArea> {
        TODO("Not yet implemented")
    }

    override suspend fun getApiPlant(animalArea: String): Result<Plant> {
        TODO("Not yet implemented")
    }

}