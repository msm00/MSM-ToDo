package com.msm.msmtodo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.msm.msmtodo.TodoNotesApplication
import com.msm.msmtodo.data.TodoNotesRepository
import com.msm.msmtodo.model.Msm
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface TodoUiState {
    data class Success(val items: /*String*/ List<Msm>) : TodoUiState
    object Error : TodoUiState
    object Loading : TodoUiState
}


class TodoViewModel(
    private val todoNotesRepository: TodoNotesRepository
) : ViewModel(){
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
//                    val listResult = OracleAPI.retrofitService.getOraData()
//                val todoNotesRepository = NetworkTodoNotesRepository()
                val listResult = todoNotesRepository.getTodoNotes()
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

    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TodoNotesApplication)
                val todoNotesRepository = application.container.todoNotesRepository
                TodoViewModel(todoNotesRepository = todoNotesRepository)
            }
        }
    }

}