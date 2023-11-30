package com.example.libkmm

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return platform.model +" "+ platform.brand
    }
}