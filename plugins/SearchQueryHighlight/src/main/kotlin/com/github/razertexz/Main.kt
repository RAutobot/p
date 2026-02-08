package com.github.razertexz

import android.content.Context
import android.text.Spannable

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage
import com.discord.widgets.chat.list.entries.MessageEntry
import com.discord.widgets.search.results.WidgetSearchResults
import com.discord.utilities.view.text.SimpleDraweeSpanTextView
import com.discord.utilities.spans.BlockBackgroundSpan

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin(requiresRestart = false)
internal class Main : Plugin() {
    override fun start(context: Context) {
        patcher.patch(WidgetChatListAdapterItemMessage::class.java, "processMessageText", arrayOf(SimpleDraweeSpanTextView::class.java, MessageEntry::class.java), object : XC_MethodHook() {
            override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam) {
                val data = (param.thisObject as WidgetChatListAdapterItemMessage).adapter.data
                if (data is WidgetSearchResults.Model) {
                    val textView = param.args[0] as SimpleDraweeSpanTextView
                    val spannable = textView.text as Spannable
                    spannable.setSpan()

                    textView.setText(spannable)
                }
            }
        })
    }

    override fun stop(context: Context) = patcher.unpatchAll()
}