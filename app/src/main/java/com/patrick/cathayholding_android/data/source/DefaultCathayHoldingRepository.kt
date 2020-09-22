package com.patrick.cathayholding_android.data.source

import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.data.Plant
import com.patrick.cathayholding_android.data.Result

class DefaultCathayHoldingRepository(private val remoteDataSource: CathayHoldingDataSource,
                                     private val localDataSource: CathayHoldingDataSource): CathayHoldingRepository {
    override suspend fun getApiAreas(): Result<DisplayArea> {
        return remoteDataSource.getApiAreas()
    }

    override suspend fun getApiPlant(animalArea: String): Result<Plant> {
        return remoteDataSource.getApiPlant(animalArea)
    }

}