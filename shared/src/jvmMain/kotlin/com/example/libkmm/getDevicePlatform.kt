package com.example.libkmm

class JVMPlatform : DevicePlatform {
    override val model: String = "JVMPlatformModel"
    override val brand: String = "JVMPlatformBrand"
}

actual fun getDevicePlatform(): DevicePlatform = JVMPlatform()