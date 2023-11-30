package com.example.libkmm

class AndroidPlatform : Platform {
    override val model: String = android.os.Build.MODEL
    override val brand: String = android.os.Build.BRAND
}

actual fun getPlatform(): Platform = AndroidPlatform()