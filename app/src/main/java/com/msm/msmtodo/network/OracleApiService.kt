package com.msm.msmtodo.network

import com.msm.msmtodo.model.MsmResponse
import retrofit2.http.GET

//private const val BASE_URL =
////    "https://android-kotlin-fun-mars-server.appspot.com/"
////    "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/msm/"
//    "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/get_all/"
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(
//    /*ScalarsConverterFactory.create()*/
//        /*Json.asConverterFactory("application/json".toMediaType())*/
//        GsonConverterFactory.create()
//    )
//    .baseUrl(BASE_URL)
//    .build()


interface OracleApiService {
    @GET("msm")
//    @GET("photos")
//    @GET("")
//    @GET("name/Joachym")
    suspend fun getOraData(): MsmResponse/*String*/
}

//object OracleAPI {
//    val retrofitService : OracleApiService by lazy { retrofit.create(OracleApiService::class.java) }
//}



