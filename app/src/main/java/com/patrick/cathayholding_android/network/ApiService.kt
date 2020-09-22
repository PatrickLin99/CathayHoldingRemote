package com.patrick.cathayholding_android.network

import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.data.Plant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://data.taipei/opendata/datalist/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface ApiService {
    @GET("apiAccess")
    suspend fun getApiAreas(
        @Query("rid") rid: String = "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a",
        @Query("scope") scope: String = "resourceAquire"
    ): DisplayArea

    @GET("apiAccess")
    suspend fun getApiPlant(
        @Query("rid") rid: String = "f18de02f-b6c9-47c0-8cda-50efad621c14",
        @Query("scope") scope: String = "resourceAquire",
        @Query("q") test: String
    ): Plant
}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}