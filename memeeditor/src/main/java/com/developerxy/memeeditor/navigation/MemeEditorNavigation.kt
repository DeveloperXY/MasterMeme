package com.developerxy.memeeditor.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.developerxy.memeeditor.ui.MemeEditorScreen
import com.developerxy.memeeditor.ui.MemeEditorViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data class MemeEditorDestination(val templateResourcePath: String)

fun NavGraphBuilder.memeEditorScreen(
    onBack: () -> Unit
) {
    composable<MemeEditorDestination> {
        val viewModel = koinViewModel<MemeEditorViewModel>()
        MemeEditorScreen(
            selectedTemplateResourcePath = it.toRoute<MemeEditorDestination>().templateResourcePath,
            onNavigateBack = onBack
        )
    }
}