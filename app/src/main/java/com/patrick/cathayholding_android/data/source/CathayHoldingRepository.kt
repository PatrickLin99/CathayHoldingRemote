package com.patrick.cathayholding_android.data.source

import com.patrick.cathayholding_android.data.*

interface CathayHoldingRepository {

    suspend fun getApiAreas(): Result<DisplayArea>

    suspend fun getApiPlant(animalArea: String): Result<Plant>
}