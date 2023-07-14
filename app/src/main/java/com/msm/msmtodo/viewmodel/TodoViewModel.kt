package com.msm.msmtodo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msm.msmtodo.network.OracleAPI
import kotlinx.coroutines.launch
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