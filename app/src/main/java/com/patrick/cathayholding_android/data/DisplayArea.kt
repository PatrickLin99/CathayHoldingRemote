package com.patrick.cathayholding_android.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class DisplayArea(
    val error: String? = null,
    val result: DisplayAreaResults
) : Parcelable