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
import com.discord.utilities.search.network.state.SearchState
import com.discord.stores.StoreStream
import com.discord.stores.StoreSearchQuery

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin
class Main : Plugin() {
    override fun start(context: Context) {
        val currentSearchState = StoreSearchQuery::class.java.getDeclaredField("currentSearchState").apply { isAccessible = true }

        patcher.patch(WidgetChatListAdapterItemMessage::class.java, "processMessageText", arrayOf(SimpleDraweeSpanTextView::class.java, MessageEntry::class.java), object : XC_MethodHook() {
            override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam) {
                val data = (param.thisObject as WidgetChatListAdapterItemMessage).adapter.data
                if (data !is WidgetSearchResults.Model)
                    return

                val query = currentSearchState.get(StoreStream.getSearch().getStoreSearchQuery()).get("content") as SearchState

                /*val textView = param.args[0] as SimpleDraweeSpanTextView
                val spannable = textView.text as Spannable
                spannable.setSpan()

                textView.setText(spannable)*/
            }
        })
    }

    override fun stop(context: Context) = patcher.unpatchAll()
}