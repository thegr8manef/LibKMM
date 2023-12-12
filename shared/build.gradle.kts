import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
    kotlin("native.cocoapods") version "1.9.21"
}

kotlin {
    val xcf = XCFramework()
    jvm()
    js()
    mingwX64()
    linuxX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    val publicationsFromMainHost =
        listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"
    publishing {
        publications {
            matching { it.name in publicationsFromMainHost }.all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
            }
        }
    }
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        android{
            publishLibraryVariants("release", "debug")
            publishLibraryVariantsGroupedByFlavor = true
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            xcf.add(this)
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            //classpath ("com.android.tools.build:gradle:7.0.0") // Use the appropriate version

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
    cocoapods {
        // Required properties
        // Specify the required Pod version here. Otherwise, the Gradle project version is used.
        version = "1.1"
        summary = "Some description for a Kotlin/Native module"
        homepage = "Link to a Kotlin/Native module homepage"

        // Optional properties
        // Configure the Pod name here instead of changing the Gradle project name
        name = "LibKMM"

        framework {
            // Required properties
            // Framework name configuration. Use this property instead of deprecated 'frameworkName'
            baseName = "LibKMM"

            // Optional properties
            // Specify the framework linking type. It's dynamic by default.
            isStatic = false
            // Dependency export
            export(project(":shared"))
            transitiveExport = false // This is default.
            // Bitcode embedding
            embedBitcode(org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode.BITCODE)
        }

        // Maps custom Xcode configuration to NativeBuildType
        xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] = org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] = org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.RELEASE
    }

}

android {
    namespace = "com.example.libkmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
