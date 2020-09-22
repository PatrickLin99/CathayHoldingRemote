package com.patrick.cathayholding_android.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PlantItem(
    @Json(name = "F_Name_Latin") val category: String = "",
    @Json(name = "F_pdf02_ALT") val pdfAltTwo: String = "",
    @Json(name = "F_Location") val location: String = "",
    @Json(name = "F_pdf01_ALT") val pdfAltOne: String = "",
    @Json(name = "rank") val rank: Float = 0F,
    @Json(name = "F_Summary") val summary: String = "",
    @Json(name = "F_Pic01_URL") val picture: String = "",
    @Json(name = "_full_count") val count: String = "",
    @Json(name = "F_pdf02_URL") val pdfUrlTwo: String = "",
    @Json(name = "F_Pic02_URL") val picTwo: String = "",
    @Json(name = "\uFEFFF_Name_Ch") val chinesename: String = "",
    @Json(name = "F_Keywords") val keyword: String = "",
    @Json(name = "F_Code") val code: String = "",
    @Json(name = "F_Geo") val geo: String = "",
    @Json(name = "F_Pic03_URL") val picUrlThree: String = "",
    @Json(name = "F_Voice01_ALT") val voiceAltOne: String = "",
    @Json(name = "F_AlsoKnown") val alsoKnown: String = "",
    @Json(name = "F_Voice02_ALT") val voiceAltTwo: String = "",
    @Json(name = "F_Pic04_ALT") val pciAltFour: String = "",
    @Json(name = "F_Name_En") val englishName: String = "",
    @Json(name = "F_Brief") val brief: String = "",
    @Json(name = "F_Pic04_URL") val picUrlFour: String = "",
    @Json(name = "F_Voice01_URL") val voiceUrlOne: String = "",
    @Json(name = "F_Feature") val feature: String = "",
    @Json(name = "F_Pic02_ALT") val picAltTwo: String = "",
    @Json(name = "F_Family") val family: String = "",
    @Json(name = "F_Voice03_ALT") val voiceAltThree: String = "",
    @Json(name = "F_Voice02_URL") val voiceUrlTwo: String = "",
    @Json(name = "F_Pic03_ALT") val pciAltThree: String = "",
    @Json(name = "F_Pic01_ALT") val picAltOne: String = "",
    @Json(name = "F_CID") val cid: String = "",
    @Json(name = "F_pdf01_URL") val pdfUrlOne: String = "",
    @Json(name = "F_Vedio_URL") val videoUrl: String = "",
    @Json(name = "F_Genus") val genus: String = "",
    @Json(name = "F_Function＆Application") val function: String = "",
    @Json(name = "F_Voice03_URL") val voiceUrlThree: String = "",
    @Json(name = "F_Update") val update: String = "",
    @Json(name = "_id") val id: Int = 0
    ): Parcelable