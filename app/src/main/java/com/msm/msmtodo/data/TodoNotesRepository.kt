package com.msm.msmtodo.data

import com.msm.msmtodo.model.Msm

interface TodoNotesRepository {
    suspend fun getTodoNotes(): List<Msm>
}