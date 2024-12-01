package com.developerxy.mastermeme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.developerxy.mastermeme.ui.navigation.MasterMemeNavigation
import com.developerxy.ui.theme.MasterMemeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MasterMemeTheme {
                val navHostController = rememberNavController()
                MasterMemeNavigation(navHostController)
            }
        }
    }
}