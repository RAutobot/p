package com.github.razertexz

import android.content.Context

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

import com.discord.api.channel.Channel
import com.discord.widgets.channels.list.`WidgetChannelsList$configureUI$5`
import com.discord.widgets.channels.list.`WidgetChannelsList$onViewBound$5`

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin(requiresRestart = false)
class AutoCollapse : Plugin() {
    override fun start(context: Context) {
        patcher.patch(`WidgetChannelsList$configureUI$5`::class.java, "invoke", arrayOf(Float::class.java), object : XC_MethodHook() {
            override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam) {
                logger.warn("configureUI invoke")
            }
        })

        patcher.patch(`WidgetChannelsList$onViewBound$5`::class.java, "invoke", arrayOf(Channel::class.java, Boolean::class.java), object : XC_MethodHook() {
            override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam) {
                logger.warn("onViewBound invoke")
            }
        })
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}