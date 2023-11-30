package com.example.libkmm

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val model: String = UIDevice.currentDevice.model
    override val brand: String = UIDevice.currentDevice.userInterfaceIdiom
}

actual fun getPlatform(): Platform = IOSPlatform()