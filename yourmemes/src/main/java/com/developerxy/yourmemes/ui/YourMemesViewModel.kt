package com.developerxy.yourmemes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerxy.yourmemes.domain.MemeTemplatesDataSource
import com.developerxy.yourmemes.ui.model.toUiModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class YourMemesViewModel(
    private val memeTemplatesDataSource: MemeTemplatesDataSource
) : ViewModel() {

    val memeTemplates = flow {
        emit(
            memeTemplatesDataSource.getAllMemeTemplates()
                .map { it.toUiModel() }
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = listOf()
    )

    fun onAction(action: YourMemesAction) {
        when (action) {
            YourMemesAction.OnCreateNewMeme -> {

            }
        }
    }
}