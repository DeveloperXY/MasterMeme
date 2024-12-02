package com.developerxy.yourmemes.ui

sealed interface YourMemesAction {
    data object OnCreateNewMeme : YourMemesAction
}