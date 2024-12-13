package com.developerxy.memeeditor.ui.components.bottombar

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.developerxy.memeeditor.ui.model.EditorState

@Composable
fun MasterMemeBottomAppBar(
    modifier: Modifier = Modifier,
    editorState: EditorState = EditorState.Standby,
) {
    BottomAppBar(modifier = modifier) {
        StandbyBottomAppBar()
    }
}

@Preview
@Composable
fun MasterMemeBottomAppBarPreview(modifier: Modifier = Modifier) {
    MasterMemeBottomAppBar()
}