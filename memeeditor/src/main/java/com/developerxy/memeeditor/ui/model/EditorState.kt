package com.developerxy.memeeditor.ui.model

sealed interface EditorState {
    /**
     * Nothing is selected, the UI is in its default initial state.
     */
    data object Standby: EditorState

    data object EditingText: EditorState

    data object SelectingFont: EditorState

    data object AdjustingFontSize: EditorState

    data object SelectingFontColor: EditorState
}