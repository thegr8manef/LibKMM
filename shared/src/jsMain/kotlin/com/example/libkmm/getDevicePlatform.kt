package com.example.libkmm

 class JsPlatform : DevicePlatform {
    override val model: String
        get() = js("navigator.userAgent") as String
    override val brand: String = "JsPlatformBrand"
}

actual fun getDevicePlatform(): DevicePlatform = JsPlatform()