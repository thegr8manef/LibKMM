package com.example.libkmm

interface DevicePlatform {
    val model: String
    val brand: String
}

expect fun getDevicePlatform(): DevicePlatform