package com.example.projeto18_03.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.projeto18_03.ui.screens.CreatePostScreen
import com.example.projeto18_03.ui.screens.ListPostScreen
import com.example.projeto18_03.ui.screens.PostScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "post_list",
            modifier = Modifier.padding(paddingValues)
        ){
            composable("post_list"){
                ListPostScreen(
                    navController = navController,
                    snackBarHostState = snackbarHostState
                )
            }
            composable("post_by_id"){
                PostScreen(
                    navController = navController,
                    snackBarHostState = snackbarHostState
                )
            }
            composable("create_post"){
                CreatePostScreen(
                    navController = navController,
                    snackbarHostState = snackbarHostState
                )
            }
        }




    }
}