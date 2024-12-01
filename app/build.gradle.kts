plugins {
    alias(libs.plugins.master.meme.android.application)
    alias(libs.plugins.master.meme.android.application.compose)
}

android {
    namespace = "com.developerxy.mastermeme"
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.yourmemes)
    implementation(projects.memeeditor)
    implementation(libs.core.splashscreen)
}