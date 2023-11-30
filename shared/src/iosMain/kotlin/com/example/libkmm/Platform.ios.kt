package com.example.libkmm

import com.example.libkmm.DevicePlatform.UIKit.UIDevice

class IOSPlatform: DevicePlatform {
    override val model: String = UIDevice.currentDevice.model
    override val brand: String = UIDevice.currentDevice.userInterfaceIdiom
}

actual fun getDevicePlatform(): DevicePlatform = IOSPlatform()