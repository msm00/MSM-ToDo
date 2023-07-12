package com.msm.msmtodo.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL =
//    "https://android-kotlin-fun-mars-server.appspot.com"
    "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface OracleApiService {
    @GET("msm")
    suspend fun getOraData(): String
}

object OracleAPI {
    val retrofitService : OracleApiService by lazy { retrofit.create(OracleApiService::class.java) }
}



