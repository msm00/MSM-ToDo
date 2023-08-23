package com.msm.msmtodo.fake

import android.util.Log
import com.msm.msmtodo.data.NetworkTodoNotesRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkTodoNotesRepositoryTest {

    @Test
    fun networkTodoNotesRepository_getOraData_verify_itemsFromDB() = runTest {
        val repository = NetworkTodoNotesRepository(todoApiService = FakeOracleApiService())
        assertEquals(FakeDataSource.itemsList, repository.getTodoNotes())
//        Log.d("MSM repository", "networkTodoNotesRepository_getOraData_verify_itemsFromDB: $repository")
    }
}