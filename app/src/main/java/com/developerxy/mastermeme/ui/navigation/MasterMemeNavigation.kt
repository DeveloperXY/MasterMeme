package com.developerxy.mastermeme.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.developerxy.memeeditor.navigation.MemeEditorDestination
import com.developerxy.memeeditor.navigation.memeEditorScreen
import com.developerxy.yourmemes.ui.navigation.YourMemesDestination
import com.developerxy.yourmemes.ui.navigation.yourMemesScreen

@Composable
fun MasterMemeNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = YourMemesDestination
    ) {
        yourMemesScreen(
            onTemplateSelected = {
                navController.navigate(MemeEditorDestination(templateResourcePath = it))
            }
        )
        memeEditorScreen(
            onBack = {
                navController.popBackStack()
            }
        )
    }
}