package com.developerxy.memeeditor.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerxy.memeeditor.ui.model.EditorState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn

class MemeEditorViewModel : ViewModel() {
    val editorState: StateFlow<EditorState> =
        flowOf(EditorState.Standby)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = EditorState.Standby,
            )
}