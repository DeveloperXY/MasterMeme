package com.developerxy.memeeditor.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.developerxy.memeeditor.ui.components.bottombar.MasterMemeBottomAppBar
import com.developerxy.memeeditor.ui.components.MasterMemeTopAppBar
import com.developerxy.memeeditor.ui.components.MemeViewport
import com.developerxy.memeeditor.ui.model.EditorState

@Composable
fun MemeEditorScreen(
    modifier: Modifier = Modifier,
    editorState: EditorState = EditorState.Standby,
    selectedTemplateResourcePath: String = "",
    onNavigateBack: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            MasterMemeTopAppBar(onNavigateBack = onNavigateBack)
        },
        bottomBar = {
            MasterMemeBottomAppBar()
        }
    ) { padding ->
        MemeViewport(
            memeTemplateResourcePath = selectedTemplateResourcePath
        )
    }
}

@Preview
@Composable
fun MemeEditorScreenPreview(modifier: Modifier = Modifier) {
    MemeEditorScreen()
}