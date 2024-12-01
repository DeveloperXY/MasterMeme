plugins {
    alias(libs.plugins.master.meme.android.library)
    alias(libs.plugins.master.meme.android.library.compose)
}

android {
    namespace = "com.developerxy.ui"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
}