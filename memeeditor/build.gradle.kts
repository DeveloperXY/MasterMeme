plugins {
    alias(libs.plugins.master.meme.android.feature)
    alias(libs.plugins.master.meme.android.library)
    alias(libs.plugins.master.meme.android.library.compose)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.developerxy.memeeditor"
}

dependencies {
    implementation(projects.core.ui)
    implementation(libs.kotlinx.serialization.json)
}