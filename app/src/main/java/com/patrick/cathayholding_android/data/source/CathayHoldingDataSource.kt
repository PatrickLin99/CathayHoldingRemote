package com.patrick.cathayholding_android.data.source

import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.data.*

interface CathayHoldingDataSource {

    suspend fun getApiAreas (): Result<DisplayArea>

    suspend fun getApiPlant (animalArea: String): Result<Plant>

}