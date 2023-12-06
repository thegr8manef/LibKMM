package com.example.libkmm

class LNXPlatform : DevicePlatform {
    override val model: String = "LNXPlatformModel"
    override val brand: String = "LNXPlatformBrand"
}

actual fun getDevicePlatform(): DevicePlatform = LNXPlatform()