plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    id("maven-publish")
    kotlin("native.cocoapods") version "1.9.21"

}
buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:8.1.4") // Use the appropriate version
    }
}