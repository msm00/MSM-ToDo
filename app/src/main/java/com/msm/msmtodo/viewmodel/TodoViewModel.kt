package com.msm.msmtodo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msm.msmtodo.model.Msm
import com.msm.msmtodo.network.OracleAPI
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface TodoUiState {
    data class Success(val items: /*String*/ List<Msm>) : TodoUiState
    object Error : TodoUiState
    object Loading : TodoUiState
}


class TodoViewModel : ViewModel(){
    //ToDo UI state
//    private val _uiState = MutableStateFlow(ToDoUiState())
//    // Backing property to avoid state updates from other classes
//    val uiState: StateFlow<ToDoUiState> = _uiState.asStateFlow()

//    private val _myData = MutableStateFlow<List<msm>>(emptyList())
//    val myData: StateFlow<List<msm>> = _myData
    var todoUiState : TodoUiState by mutableStateOf(TodoUiState.Loading)
        private set

    init {
//        loadDataState()
        getToDoNotes()
    }

    private fun getToDoNotes() {
//        todoUiState = "Set the Mars API status response here!"
        viewModelScope.launch {
            todoUiState = try {
                    val listResult = OracleAPI.retrofitService.getOraData()
    //                todoUiState = listResult
//                    TodoUiState.Success(listResult)
                TodoUiState.Success(
//                    "Success: ${listResult.items.get(5).name} items retrieved"
                    listResult.items
                )
                } catch (e: IOException) {
//                    print(e.message)
                    TodoUiState.Error
                }
        }
    }

}

//fun main(){
////    val data = TodoViewModel().getData()
////    data.forEach {
////        println("${it.id} chce ${it.name} a ${it.description}")
////    }
//    val todoViewModel = TodoViewModel()
////    todoViewModel.pprint()
////    todoViewModel.loadDataState()
////    todoViewModel.pprint()
//}