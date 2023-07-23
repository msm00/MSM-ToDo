package com.msm.msmtodo.data

import com.msm.msmtodo.network.OracleApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val todoNotesRepository : TodoNotesRepository
}

class DefaultAppContainer : AppContainer {

    private val BASE_URL =
//    "https://android-kotlin-fun-mars-server.appspot.com/"
//    "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/msm/"
        "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/get_all/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(
            /*ScalarsConverterFactory.create()*/
            /*Json.asConverterFactory("application/json".toMediaType())*/
            GsonConverterFactory.create()
        )
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : OracleApiService by lazy {
        retrofit.create(
            OracleApiService::class.java
        )
    }
    override val todoNotesRepository: TodoNotesRepository by lazy {
        NetworkTodoNotesRepository(retrofitService)
    }

}