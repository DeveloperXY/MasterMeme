package com.developerxy.mastermeme

import android.app.Application
import com.developerxy.yourmemes.di.yourMemesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MasterMemeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MasterMemeApp)
            androidLogger()

            modules(yourMemesModule)
        }
    }
}