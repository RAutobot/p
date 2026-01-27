package com.github.razertexz

import android.content.Context

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.Http

import com.discord.utilities.uri.UriHandler

import kotlin.jvm.functions.Function0

import de.robv.android.xposed.XC_MethodHook

@AliucordPlugin
internal class Main : Plugin() {
    override fun start(context: Context) {
        val rules = Http.simpleJsonGet("https://rules2.clearurls.xyz/data.minify.json", HashMap::class.java)

        patcher.patch(UriHandler::class.java, "handle", arrayOf(Context::class.java, String::class.java, Boolean::class.java, Boolean::class.java, Function0::class.java), object : XC_MethodHook() {
            override fun beforeHookedMethod(param: XC_MethodHook.MethodHookParam) {
                val originalUrl = param.args[1] as String
                logger.infoToast(rules["adtech"])
            }
        })
    }

    override fun stop(context: Context) = patcher.unpatchAll()
}