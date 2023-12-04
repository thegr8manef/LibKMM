plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    id("maven-publish")
}
buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:8.2.0") // Use the appropriate version
    }
}