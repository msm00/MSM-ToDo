package com.msm.msmtodo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msm.msmtodo.R
import com.msm.msmtodo.ui.theme.MSMToDoTheme
import com.msm.msmtodo.viewmodel.TodoUiState
import com.msm.msmtodo.viewmodel.TodoViewModel

/**
 * enum values that represent the screens in the app
 */
enum class ToDoMainNav(){
    ALL_NOTES,
    ADD_NOTES,
    EDIT_NOTES,
    DELETE_NOTES
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val todoViewModel: TodoViewModel = viewModel(factory = TodoViewModel.Factory)

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            ToDoAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.item_entry_title)
                )
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ToDoMainNav.ALL_NOTES.name,
            modifier = modifier.padding(innerPadding)
        ){
            composable(route = ToDoMainNav.ALL_NOTES.name){
                ToDoMainBody(
                    todoUiState = todoViewModel.todoUiState,/*, retryAction = todoViewModel.todoUiState*/
        //            onItemClick = navigateToItemUpdate,
                    modifier = modifier.fillMaxSize()
                )
            }
            composable(route = ToDoMainNav.ADD_NOTES.name){

            }
        }

//        ToDoMainBody(
//            todoUiState = todoViewModel.todoUiState,/*, retryAction = todoViewModel.todoUiState*/
////            onItemClick = navigateToItemUpdate,
//            modifier = modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoAppBar
            (
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Row (
//                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icons8_note_64),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_medium)),
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        },
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoMainBody(
    todoUiState: TodoUiState,
    modifier : Modifier = Modifier/*, retryAction: () -> Unit*/
) {
    when (todoUiState) {
        is TodoUiState.Loading -> LoadingScreen(
            modifier = modifier.fillMaxSize()
        )
        is TodoUiState.Success -> LazyColumn(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_min)),
//                .background(MaterialTheme.colorScheme.primaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items (todoUiState.items.size) { index -> ToDoItem(
                itemDesc = todoUiState.items[index].description
            )

            }
        }
        is TodoUiState.Error -> ErrorScreen(
            modifier = modifier.fillMaxSize()/*, retryAction = retryAction*/
        )
    }

}

@Composable
fun ToDoItem(
    modifier: Modifier = Modifier,
    itemDesc: String,
) {
    var checkState by rememberSaveable { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_min),
                horizontal = dimensionResource(id = R.dimen.padding_medium)
            )
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_min))
            )
//            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

    ) {
        Text(
            text = itemDesc,
            modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
////                .fillMaxWidth(0.8f),
        )
        Spacer(Modifier.weight(1f))
        Checkbox(
            checked = checkState,
            onCheckedChange = { checkState = !checkState},

            )
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
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(
            dimensionResource(id = R.dimen.padding_medium)
        ))
    }
}

//@Composable
//fun AddingItem(modifier: Modifier = Modifier){
//    TextField(
//        value = "+",
//        onValueChange = {},
//        modifier = modifier,
//    )
//}

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