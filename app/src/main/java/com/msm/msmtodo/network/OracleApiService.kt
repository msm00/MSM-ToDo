package com.msm.msmtodo.network

import com.msm.msmtodo.model.NoteResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface OracleApiService {
//    @GET("msm")
//    @GET("photos")
//    @GET("")
//    @GET("name/Joachym")
    /* note/all_notes */

//    @Headers("Content-Type: application/json", "Accept-Encoding : gzip")
//    @GET("note")
//    suspend fun getOraData(): NoteResponse /*MsmResponse*//*String*/

    @Headers("Content-Type: application/json")
    @GET("note/all_notes/")
    suspend fun getOraData(): NoteResponse /*MsmResponse*//*String*/
}

//object OracleAPI {
//    val retrofitService : OracleApiService by lazy { retrofit.create(OracleApiService::class.java) }
//}



