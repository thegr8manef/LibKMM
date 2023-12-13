//import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("maven-publish")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "19"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "LibKMM"
        homepage = "https://github.com/thegr8manef/LibKMM"
        version = "2.0.0"
        authors = "Thegr8manef, Manef Jedidi"
        license = "Apache-2.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "LibKMM"
        }
    }

    sourceSets {
        val ktor_version = "2.2.4"
        val commonMain by getting {
            dependencies {
                //implementation("io.ktor:ktor-client-core:$ktor_version")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                //implementation("io.ktor:ktor-client-okhttp:$ktor_version")
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                //implementation("io.ktor:ktor-client-ios:$ktor_version")
            }
        }
    }
}

android {
    namespace = "com.example.libkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 27
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}
//
//plugins {
//    alias(libs.plugins.kotlinMultiplatform)
//    alias(libs.plugins.androidLibrary)
//    id("maven-publish")
//    kotlin("native.cocoapods") version "1.9.21"
//}
//
//kotlin {
//    val xcf = XCFramework()
//    jvm()
//    js()
//    mingwX64()
//    linuxX64()
//    iosX64()
//    iosArm64()
//    iosSimulatorArm64()
//    val publicationsFromMainHost =
//        listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"
//    publishing {
//        publications {
//            matching { it.name in publicationsFromMainHost }.all {
//                val targetPublication = this@all
//                tasks.withType<AbstractPublishToMaven>()
//                    .matching { it.publication == targetPublication }
//                    .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
//            }
//        }
//    }
//    androidTarget {
//        compilations.all {
//            kotlinOptions {
//                jvmTarget = "1.8"
//            }
//        }
//        android{
//            publishLibraryVariants("release", "debug")
//            publishLibraryVariantsGroupedByFlavor = true
//        }
//    }
//
//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//            isStatic = true
//            xcf.add(this)
//        }
//    }
//
//    sourceSets {
//        commonMain.dependencies {
//            //put your multiplatform dependencies here
//            //classpath ("com.android.tools.build:gradle:7.0.0") // Use the appropriate version
//
//        }
//        commonTest.dependencies {
//            implementation(libs.kotlin.test)
//        }
//    }
//    cocoapods {
//        // Required properties
//        // Specify the required Pod version here. Otherwise, the Gradle project version is used.
//        version = "1.1"
//        summary = "Some description for a Kotlin/Native module"
//        homepage = "Link to a Kotlin/Native module homepage"
//
//        // Optional properties
//        // Configure the Pod name here instead of changing the Gradle project name
//        name = "LibKMM"
//
//        framework {
//            // Required properties
//            // Framework name configuration. Use this property instead of deprecated 'frameworkName'
//            baseName = "LibKMM"
//
//            // Optional properties
//            // Specify the framework linking type. It's dynamic by default.
//            isStatic = false
//            // Dependency export
//            export(project(":shared"))
//            transitiveExport = false // This is default.
//            // Bitcode embedding
//            embedBitcode(org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode.BITCODE)
//        }
//
//        // Maps custom Xcode configuration to NativeBuildType
//        xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] = org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.DEBUG
//        xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] = org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.RELEASE
//    }
//
//}
//
//android {
//    namespace = "com.example.libkmm"
//    compileSdk = 34
//    defaultConfig {
//        minSdk = 24
//    }
//}
