package com.github.razertexz

import android.content.Context

import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin

@AliucordPlugin
class Main : Plugin() {
    private val simpleAst = SimpleASTAPI()

    override fun start(context: Context) {}
    override fun stop(context: Context) {}
}