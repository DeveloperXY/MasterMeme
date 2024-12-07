package com.developerxy.memeeditor.di

import com.developerxy.memeeditor.ui.MemeEditorViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val memeEditorModule = module {
    viewModelOf(::MemeEditorViewModel)
}