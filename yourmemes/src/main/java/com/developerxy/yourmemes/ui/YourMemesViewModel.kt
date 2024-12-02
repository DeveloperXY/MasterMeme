package com.developerxy.yourmemes.ui

import androidx.lifecycle.ViewModel

class YourMemesViewModel : ViewModel() {

    fun onAction(action: YourMemesAction) {
        when (action) {
            YourMemesAction.OnCreateNewMeme -> {

            }
        }
    }
}