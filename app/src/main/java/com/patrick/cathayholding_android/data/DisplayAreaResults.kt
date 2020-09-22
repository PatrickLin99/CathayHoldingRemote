package com.patrick.cathayholding_android.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class DisplayAreaResults (
    val limit: Int = 1000,
    val offset: Int = 0,
    val count: Int = 220,
    val sort: String = "",
    val results: @RawValue List<AnimalCategory>
): Parcelable