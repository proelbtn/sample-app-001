// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.5.30" apply false
}

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.41")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
