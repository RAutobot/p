package com.github.razertexz

import android.content.Context
import android.view.View

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

import com.discord.widgets.chat.list.adapter.`WidgetChatListAdapterItemMessage$onConfigure$4`

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin(requiresRestart = false)
internal class Main : Plugin() {
    override fun start(context: Context) {
        patcher.patch(`WidgetChatListAdapterItemMessage$onConfigure$4`::class.java, "invoke", arrayOf(View::class.java), object : XC_MethodHook() {
            override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam) {
                logger.infoToast("nice")
                param.result = null
            }
        })
    }

    override fun stop(context: Context) = patcher.unpatchAll()
}