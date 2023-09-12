package com.msm.msmtodo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.msm.msmtodo.ui.home.HomeDestination
import com.msm.msmtodo.ui.home.HomeScreen

/**
 * Provides Navigation graph for the application.
 */

@Composable
fun ToDoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ){
        composable(route = HomeDestination.route){
            HomeScreen(
                navigateToItemEntry = {},
                navigateToItemUpdate = {6}
//                todoUiState = todoViewModel.todoUiState,/*, retryAction = todoViewModel.todoUiState*/
//                //            onItemClick = navigateToItemUpdate,
//                modifier = modifier.fillMaxSize()
            )
        }
//        composable(route = ToDoMainNav.ADD_NOTES.name){

//        }
    }

}