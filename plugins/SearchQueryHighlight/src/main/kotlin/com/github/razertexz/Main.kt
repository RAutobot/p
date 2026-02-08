package com.github.razertexz

import android.content.Context
import android.text.Spannable

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage
import com.discord.utilities.view.text.SimpleDraweeSpanTextView
import com.discord.widgets.chat.list.entries.MessageEntry

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin(requiresRestart = false)
internal class Main : Plugin() {
    override fun start(context: Context) {
        patcher.patch(WidgetChatListAdapterItemMessage::class.java, "processMessageText", arrayOf(SimpleDraweeSpanTextView::class.java, MessageEntry::class.java), object : XC_MethodHook() {
            override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam) {
                val adapterData = (param.thisObject as WidgetChatListAdapterItemMessage).adapter.data
                logger.info(adapterData.getName())

                val textView = param.args[0] as SimpleDraweeSpanTextView
                val spannable = textView.getText() as Spannable
            }
        })
    }

    override fun stop(context: Context) = patcher.unpatchAll()
}