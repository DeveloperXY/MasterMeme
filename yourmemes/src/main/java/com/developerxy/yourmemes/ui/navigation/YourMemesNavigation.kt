package com.developerxy.yourmemes.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.developerxy.yourmemes.ui.YourMemesScreen
import com.developerxy.yourmemes.ui.YourMemesViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.yourMemesScreen() {
    composable("your_memes") {
        val viewModel = koinViewModel<YourMemesViewModel>()
        YourMemesScreen(
            onAction = viewModel::onAction
        )
    }
}