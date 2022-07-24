package com.floriantrecul.findmeadeveloper.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.floriantrecul.findmeadeveloper.presentation.screens.home.HomeScreen

@Composable
fun FindMeADeveloppeAppNavigator(startDestination: String = Screens.HomeScreen.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }
    }

}