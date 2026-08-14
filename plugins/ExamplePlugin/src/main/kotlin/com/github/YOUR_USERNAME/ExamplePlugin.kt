package com.github.YOUR_USERNAME

import android.content.Context

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.patcher.*

@AliucordPlugin(requiresRestart = false)
class ExamplePlugin : Plugin() {
    override fun start(context: Context) {
        // Code here
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}