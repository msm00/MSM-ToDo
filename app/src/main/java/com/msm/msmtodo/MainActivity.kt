package com.msm.msmtodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.msm.msmtodo.ui.theme.MSMToDoTheme
import com.msm.msmtodo.viewmodel.TodoUiState
import com.msm.msmtodo.viewmodel.TodoUiState.*
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
//                    val todoViewModel: TodoViewModel = viewModel()
//                    val todoViewModel: TodoViewModel = viewModel(factory = TodoViewModel.Factory)
//                    ToDoMainBody(todoUiState = todoViewModel.todoUiState/*, retryAction = todoViewModel.todoUiState*/)
                    ToDoMainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoMainScreen(
//    navigateToItemEntry: () -> Unit,
//    navigateToItemUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier,
//    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val todoViewModel: TodoViewModel = viewModel(factory = TodoViewModel.Factory)

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.app_name))
            })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                shape = MaterialTheme.shapes.medium,
//                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.item_entry_title)
                )
            }
        },
    ) { innerPadding ->
        ToDoMainBody(
            todoUiState = todoViewModel.todoUiState,/*, retryAction = todoViewModel.todoUiState*/
//            onItemClick = navigateToItemUpdate,
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoMainBody(
    todoUiState: TodoUiState, modifier: Modifier = Modifier/*, retryAction: () -> Unit*/
) {
    when (todoUiState) {
        is Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is Success -> LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.outline),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items (todoUiState.items.size) { index -> ToDoItem(itemDesc = todoUiState.items[index].description)

            }
//            repeat(30) {
//                item {
////                ToDoItem(itemDesc = stringResource(R.string.describe_the_note))
//                    ToDoItem(itemDesc = todoUiState)
//                }
//            }
        }
        is Error -> ErrorScreen( modifier = modifier.fillMaxSize()/*, retryAction = retryAction*/ )
    }

}

@Composable
fun ToDoItem(
    modifier: Modifier = Modifier, itemDesc: /*TodoUiState*/ String,
    ) {
//    val TAG = "CHECKBOX ERR"
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
                .padding(4.dp)
                .fillMaxWidth(0.8f),
            color = MaterialTheme.colorScheme.primary,
        )
//        Button(onClick = { /*todoViewModel.loadDataState()*/ }) {
//            Text("Refresh Data")
//        }
        Checkbox(checked = checkState, onCheckedChange = { checkState = !checkState})
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    /*retryAction: () -> Unit*/
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

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
//        ToDoMainScreen(stringResource(R.string.describe_the_note))
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    MSMToDoTheme {
        ErrorScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoItemPreview() {
    MSMToDoTheme {
//        ToDoItem(itemDesc = stringResource(R.string.describe_the_note))
    }
}