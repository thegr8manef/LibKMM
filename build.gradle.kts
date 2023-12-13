plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("7.4.1").apply(false)
    kotlin("multiplatform").version("1.8.0").apply(false)
    id("maven-publish")


}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

//plugins {
//    //trick: for the same plugin versions in all sub-modules
//    alias(libs.plugins.androidLibrary).apply(false)
//    alias(libs.plugins.kotlinMultiplatform).apply(false)
//    id("maven-publish")
//}
//buildscript {
//    dependencies {
//        classpath ("com.android.tools.build:gradle:8.2.0") // Use the appropriate version
//    }
//}