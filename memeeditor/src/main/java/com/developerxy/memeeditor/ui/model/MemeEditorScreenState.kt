package com.developerxy.memeeditor.ui.model

sealed interface MemeEditorUiState {
    /**
     * Nothing is selected, the UI is in its default initial state.
     */
    data object Standby: MemeEditorUiState

    data object EditingText: MemeEditorUiState

    data object SelectingFont: MemeEditorUiState

    data object AdjustingFontSize: MemeEditorUiState

    data object SelectingFontColor: MemeEditorUiState
}