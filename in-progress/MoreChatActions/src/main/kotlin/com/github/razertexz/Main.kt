package com.github.razertexz

import android.content.Context
import android.view.View

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

import com.discord.widgets.chat.list.WidgetChatList

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin
internal class Main : Plugin() {
    override fun start(context: Context) {
        var isMultiSelecting = true

        patcher.patch(`WidgetChatListAdapterItemMessage$onConfigure$3`::class.java, "onClick", arrayOf(View::class.java), object : XC_MethodHook() {
            override fun beforeHookedMethod(param: XC_MethodHook.MethodHookParam) {
                if (isMultiSelecting) {
                    param.result = null
                }
            }
        })
    }

    override fun stop(context: Context) = patcher.unpatchAll()
}