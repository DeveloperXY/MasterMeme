package com.developerxy.yourmemes.di

import com.developerxy.yourmemes.ui.YourMemesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val yourMemesModule = module {
    viewModelOf(::YourMemesViewModel)
}