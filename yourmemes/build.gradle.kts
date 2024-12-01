plugins {
    alias(libs.plugins.master.meme.android.feature)
    alias(libs.plugins.master.meme.android.library)
    alias(libs.plugins.master.meme.android.library.compose)
}

android {
    namespace = "com.developerxy.yourmemes"
}

dependencies {
    implementation(projects.core.ui)
}