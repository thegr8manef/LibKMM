package com.example.libkmm

class AndroidPlatform : DevicePlatform {
    override val model: String = android.os.Build.MODEL
    override val brand: String = android.os.Build.BRAND
}

actual fun getDevicePlatform(): DevicePlatform = AndroidPlatform()