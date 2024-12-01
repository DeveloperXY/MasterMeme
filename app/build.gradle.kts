plugins {
    alias(libs.plugins.master.meme.android.application)
    alias(libs.plugins.master.meme.android.application.compose)
}

android {
    namespace = "com.developerxy.mastermeme"
}

dependencies {
    implementation(libs.core.splashscreen)
    implementation(projects.core.ui)
}