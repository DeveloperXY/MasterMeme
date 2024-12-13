package com.developerxy.memeeditor.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
        val editorState by viewModel.editorState.collectAsStateWithLifecycle()
        MemeEditorScreen(
            editorState = editorState,
            selectedTemplateResourcePath = it.toRoute<MemeEditorDestination>().templateResourcePath,
            onNavigateBack = onBack
        )
    }
}