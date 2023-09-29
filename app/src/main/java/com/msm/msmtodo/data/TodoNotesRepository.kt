package com.msm.msmtodo.data

import com.msm.msmtodo.model.NoteResponse
import com.msm.msmtodo.network.OracleApiService

interface TodoNotesRepository {
    suspend fun getTodoNotes(): NoteResponse /*MsmResponse*/
}

class NetworkTodoNotesRepository(
    private val todoApiService: OracleApiService
) : TodoNotesRepository {
    override suspend fun getTodoNotes(): NoteResponse /*MsmResponse*/ = todoApiService.getOraData()

}