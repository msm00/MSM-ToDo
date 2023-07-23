package com.msm.msmtodo.data

import com.msm.msmtodo.model.MsmResponse
import com.msm.msmtodo.network.OracleApiService

interface TodoNotesRepository {
    suspend fun getTodoNotes(): MsmResponse
}

class NetworkTodoNotesRepository(
    private val todoApiService: OracleApiService
) : TodoNotesRepository {
    override suspend fun getTodoNotes(): MsmResponse = todoApiService.getOraData()

}