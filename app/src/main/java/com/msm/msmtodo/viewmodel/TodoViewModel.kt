package com.msm.msmtodo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msm.msmtodo.model.OracleDatabase
import com.msm.msmtodo.network.OracleAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import msm
import java.io.IOException


class TodoViewModel : ViewModel(){
    //ToDo UI state
//    private val _uiState = MutableStateFlow(ToDoUiState())
//    // Backing property to avoid state updates from other classes
//    val uiState: StateFlow<ToDoUiState> = _uiState.asStateFlow()

//    private val _myData = MutableStateFlow<List<msm>>(emptyList())
//    val myData: StateFlow<List<msm>> = _myData
    var todoUiState : String by mutableStateOf("")
        private set

    init {
//        loadDataState()
        getToDoNotes()
    }

    private fun getToDoNotes() {
//        todoUiState = "Set the Mars API status response here!"
        try {
            viewModelScope.launch {
                val listResult = OracleAPI.retrofitService.getOraData()
                todoUiState = listResult
            }
        } catch (e : IOException){
            print(e.message)
        }

    }

    private fun getData(): MutableList<msm> {
//        Class.forName("oracle.jdbc.driver.OracleDriver")
        val conn = OracleDatabase.getConnection()
        // prints true if the connection is valid
//        println(conn.isValid(0))

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

//    fun loadDataState(){
//        _myData.value = getData()
////        _myData.value = "Set the Mars API status response here!"
//    }

//    fun pprint(){
//        println(_myData.value)
//        println(myData.value)
//    }


}

fun main(){
//    val data = TodoViewModel().getData()
//    data.forEach {
//        println("${it.id} chce ${it.name} a ${it.description}")
//    }
    val todoViewModel = TodoViewModel()
//    todoViewModel.pprint()
//    todoViewModel.loadDataState()
//    todoViewModel.pprint()
}