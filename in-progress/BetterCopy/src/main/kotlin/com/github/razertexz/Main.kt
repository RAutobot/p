package com.github.razertexz

import android.content.Context

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.Utils

import com.discord.api.commands.ApplicationCommandType

@AliucordPlugin(requiresRestart = false)
internal class Main : Plugin() {
    override fun start(context: Context) {
        commands.registerCommand(
            "mass-copy",
            "Mass copy messages",
            listOf(Utils.createCommandOption(name = "", type = , required = true, default = true))
        ) {
        
        }
    }

    override fun stop(context: Context) = commands.unregisterAll()
}