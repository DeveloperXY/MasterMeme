package com.developerxy.mastermeme.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.developerxy.yourmemes.ui.navigation.yourMemesScreen

@Composable
fun MasterMemeNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "your_memes"
    ) {
        yourMemesScreen()
    }
}