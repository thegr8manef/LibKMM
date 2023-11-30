package com.example.libkmm

class DeviceInfo {
    private val platform: DevicePlatform = getDevicePlatform()

    fun getDeviceInfo(): String {
        return platform.model +" "+ platform.brand
    }
}