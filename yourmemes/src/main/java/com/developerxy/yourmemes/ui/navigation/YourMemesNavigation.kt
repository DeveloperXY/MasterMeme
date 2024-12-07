package com.developerxy.yourmemes.ui.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.developerxy.yourmemes.ui.YourMemesScreen
import com.developerxy.yourmemes.ui.YourMemesViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.yourMemesScreen() {
    composable("your_memes") {
        val viewModel = koinViewModel<YourMemesViewModel>()
        val memeTemplates by viewModel.memeTemplates.collectAsStateWithLifecycle()
        YourMemesScreen(
            onAction = viewModel::onAction,
            memeTemplates = memeTemplates
        )
    }
}