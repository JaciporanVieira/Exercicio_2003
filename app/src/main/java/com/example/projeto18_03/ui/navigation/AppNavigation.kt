package com.example.projeto18_03.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.projeto18_03.ui.screens.ListPostScreen
import com.example.projeto18_03.ui.screens.PostScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "post_list"
    ){
        composable("post_list"){
            ListPostScreen(navController = navController)
        }
        composable("post_by_id"){
            PostScreen(navController = navController)
        }




    }
}