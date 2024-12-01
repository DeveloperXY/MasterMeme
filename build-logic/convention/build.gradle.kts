plugins {
    `kotlin-dsl`
}

group = "com.developerxy.snoozeloo.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin) // provides ApplicationExtension
    compileOnly(libs.kotlin.gradlePlugin) // provides the KotlinCompile class which allows us to configure Kotlin project wide
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "master.meme.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "master.meme.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "master.meme.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidLibrary") {
            id = "master.meme.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "master.meme.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}