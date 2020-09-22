package com.patrick.cathayholding_android.data

import android.os.Parcelable
import com.patrick.cathayholding_android.data.DisplayAreaResults
import com.patrick.cathayholding_android.data.PlantInfo
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Plant(
    val error: String? = null,
    val result: PlantInfo
) : Parcelable