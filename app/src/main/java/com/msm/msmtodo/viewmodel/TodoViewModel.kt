package com.msm.msmtodo.viewmodel

import androidx.lifecycle.ViewModel
import com.msm.msmtodo.model.OracleDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import msm

class TodoViewModel : ViewModel(){
    //ToDo UI state
//    private val _uiState = MutableStateFlow(ToDoUiState())
//    // Backing property to avoid state updates from other classes
//    val uiState: StateFlow<ToDoUiState> = _uiState.asStateFlow()

    private val _myData = MutableStateFlow<List<msm>>(emptyList())
    val myData: StateFlow<List<msm>> = _myData

    private fun getData(): MutableList<msm> {
        val conn = OracleDatabase.getConnection()
        // prints true if the connection is valid
        println(conn.isValid(0))

        // define query
        val query = "select ID,\n" +
                "NAME,\n" +
                "DESCRIPTION from MSM"
        val stmt = conn.prepareStatement(query)
        val rs = stmt.executeQuery()

        val msmList = mutableListOf<msm>()

        while (rs.next()) {
            // getting the value of the id column
            val id = rs.getInt("id")
            // getting the value of the name column
            val name = rs.getString("name")
            // getting the value of the description column
            val desc = rs.getString("description")
//        println("id: $id, name: $name, desc: $desc")

            /*
        constructing a msm table object and
        putting data into the list
         */
            msmList.add(msm(id = id, name = name, description = desc))
//            _uiState.value = ToDoUiState(id = id, name = name, description = desc)

        }

        rs.close()
        stmt.close()
        conn.close()

        return msmList
    }

    fun loadDataState(){
        _myData.value = getData()
    }

    fun pprint(){
        println(_myData.value)
        println(myData.value)
    }
}

fun main(){
//    val data = TodoViewModel().getData()
//    data.forEach {
//        println("${it.id} chce ${it.name} a ${it.description}")
//    }
    val todoViewModel = TodoViewModel()
    todoViewModel.pprint()
    todoViewModel.loadDataState()
    todoViewModel.pprint()
}