package com.msm.msmtodo.ui.item

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.msm.msmtodo.R
import com.msm.msmtodo.ToDoTopAppBar
import com.msm.msmtodo.ui.home.HomeBody
import com.msm.msmtodo.ui.home.HomeDestination
import com.msm.msmtodo.ui.navigation.NavigationDestination

object ItemAddDestination : NavigationDestination {
    override val route = "item_add"
    override val titleRes = R.string.item_add_screen
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemAddScreen(
    modifier: Modifier = Modifier,
){
    Scaffold(
        modifier = modifier,

        topBar = {
//            ToDoAppBar(navigateUp = {}, currentScreen = ToDoMainNav.ALL_NOTES)
            ToDoTopAppBar(
                title = stringResource(id = ItemAddDestination.titleRes),
                canNavigateBack = true
            )
        }
    )
    { innerPadding ->
        ItemAddBody(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
fun ItemAddBody(
    modifier: Modifier = Modifier
){

}