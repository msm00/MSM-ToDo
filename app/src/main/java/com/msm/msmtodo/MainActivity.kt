package com.msm.msmtodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.msm.msmtodo.ui.theme.MSMToDoTheme
import com.msm.msmtodo.viewmodel.TodoViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MSMToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val todoViewModel: TodoViewModel = viewModel()
                    ToDoMainScreen(todoUiState = todoViewModel.todoUiState)
//                    HomeScreen(
//                        marsUiState = todoViewModel.todoUiState)
                }
            }
        }
    }
}

@Composable
fun ToDoMainScreen(
    todoUiState: String,
) {
    // get the connection -- set connection is could not be in Composable function
//    val conn = OracleDatabase.getConnection()
//    val data = ETL().getDBlist()
//    val toDoUiState by todoViewModel.uiState.collectAsState()

//    todoViewModel.loadDataState()

//    println(conn.isValid(0))


    LazyColumn(modifier = Modifier
        .padding(8.dp)
        .background(MaterialTheme.colorScheme.outline),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        repeat(30) {
            item {
//                ToDoItem(itemDesc = stringResource(R.string.describe_the_note))
                ToDoItem(itemDesc = todoUiState)
//                ToDoItem(itemDesc = dataState[0].description)
                }
            }
//            item {toDoUiState.msmList[0]}
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoItem(
    modifier: Modifier = Modifier, itemDesc: String,
//    todoViewModel: TodoViewModel = viewModel()

    ) {
//    val TAG = "CHECKBOX ERR"
//    val itemDesc = stringResource(id = R.string.describe_the_note)
    var checkState by rememberSaveable { mutableStateOf(false)}
//    val dataState: List<msm> by todoViewModel.myData.collectAsState(
//        initial = emptyList()
//    )

    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(all = 4.dp)
            .background(MaterialTheme.colorScheme.inversePrimary)
            .fillMaxWidth()
        ) {
        Text(
            text = itemDesc,
            modifier
                .padding(4.dp),
//                .fillMaxWidth(0.8f),
            color = MaterialTheme.colorScheme.primary,
        )
        Button(onClick = { /*todoViewModel.loadDataState()*/ }) {
            Text("Refresh Data")
        }
        Checkbox(checked = checkState, onCheckedChange = { checkState = !checkState})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingItem(){
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier,
    )

}

@Preview(showBackground = true)
@Composable
fun ToDoMainScreenPreview() {
    MSMToDoTheme {
        ToDoMainScreen(stringResource(R.string.describe_the_note))
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoItemPreview() {
    MSMToDoTheme {
        ToDoItem(itemDesc = stringResource(R.string.describe_the_note))
    }
}