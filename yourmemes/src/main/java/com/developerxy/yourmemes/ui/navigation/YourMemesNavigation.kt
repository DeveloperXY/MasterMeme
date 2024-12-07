package com.developerxy.yourmemes.ui.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.developerxy.yourmemes.ui.YourMemesScreen
import com.developerxy.yourmemes.ui.YourMemesViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object YourMemesDestination

fun NavGraphBuilder.yourMemesScreen(
    onTemplateSelected: (resourcePath: String) -> Unit
) {
    composable<YourMemesDestination> {
        val viewModel = koinViewModel<YourMemesViewModel>()
        val memeTemplates by viewModel.memeTemplates.collectAsStateWithLifecycle()
        YourMemesScreen(
            onAction = viewModel::onAction,
            onTemplateSelected = {
                onTemplateSelected(it.resourcePath)
            },
            memeTemplates = memeTemplates
        )
    }
}