package com.developerxy.yourmemes.di

import com.developerxy.yourmemes.data.LocalMemeTemplatesDataSource
import com.developerxy.yourmemes.domain.MemeTemplatesDataSource
import com.developerxy.yourmemes.ui.YourMemesViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val yourMemesModule = module {
    viewModelOf(::YourMemesViewModel)
    singleOf(::LocalMemeTemplatesDataSource) {
        bind<MemeTemplatesDataSource>()
    }
}