package com.patrick.cathayholding_android.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class PlantInfo (
    val limit: Int = 1000,
    val offset: Int = 0,
    val count: Int = 17,
    val sort: String = "",
    val results: @RawValue List<PlantItem>
): Parcelable