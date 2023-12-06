package com.example.libkmm

class WINPlatform : DevicePlatform {
    override val model: String = "WINPlatformModel"
    override val brand: String = "WINPlatformBrand"
}

actual fun getDevicePlatform(): DevicePlatform = WINPlatform()