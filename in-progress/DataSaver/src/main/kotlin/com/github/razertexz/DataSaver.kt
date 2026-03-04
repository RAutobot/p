package com.github.razertexz

import android.content.Context

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

import com.discord.api.guildmember.GuildMember

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin
class DataSaver : Plugin() {
    override fun start(context: Context) {
        patcher.patch(GuildMember::class.java, "b", emptyArray(), object : XC_MethodHook() {
            override fun beforeHookedMethod(param: XC_MethodHook.MethodHookParam) {
                param.result = null
            }
        })

        patcher.patch(GuildMember::class.java, "c", emptyArray(), object : XC_MethodHook() {
            override fun beforeHookedMethod(param: XC_MethodHook.MethodHookParam) {
                param.result = null
            }
        })
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}