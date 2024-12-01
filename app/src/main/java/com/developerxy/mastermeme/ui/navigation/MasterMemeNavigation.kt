package com.developerxy.mastermeme.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.developerxy.yourmemes.ui.YourMemesScreen

@Composable
fun MasterMemeNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "your_memes"
    ) {
        yourMemes(navController)
    }
}

private fun NavGraphBuilder.yourMemes(navController: NavHostController) {
    composable("your_memes") {
        YourMemesScreen()
    }
}