package com.example.libkmm

interface Platform {
    val model: String
    val brand: String
}

expect fun getPlatform(): Platform