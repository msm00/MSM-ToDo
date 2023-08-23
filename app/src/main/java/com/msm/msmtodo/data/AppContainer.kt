package com.msm.msmtodo.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.msm.msmtodo.network.OracleApiService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor


interface AppContainer {
    val todoNotesRepository : TodoNotesRepository
}

class DefaultAppContainer : AppContainer {

    private val BASE_URL =
//    "https://android-kotlin-fun-mars-server.appspot.com/"
//    "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/msm/"
//        "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/get_all/"
    "https://g8c9a51bc78a43e-adwmsmdb.adb.eu-zurich-1.oraclecloudapps.com/ords/ociuser/"


    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addNetworkInterceptor { chain ->
            val request = chain.request()
            val url = request.url
            val headers = request.headers

            println("Request URL: $url")
            headers.names().forEach { headerName ->
                println("Header: $headerName = ${headers.get(headerName)}")
            }

            val response = chain.proceed(request)
            response
        }
        .build()


    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(
            /*ScalarsConverterFactory.create()*/
            /*Json.asConverterFactory("application/json".toMediaType())*/
//            Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType())
            GsonConverterFactory.create()
        )
        .baseUrl(BASE_URL)
//        .client(okHttpClient)
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