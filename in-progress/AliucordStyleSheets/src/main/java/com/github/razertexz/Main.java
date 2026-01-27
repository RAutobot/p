package com.github.razertexz;

import android.content.Context;

import com.aliucord.annotations.AliucordPlugin;
import com.aliucord.entities.Plugin;

@AliucordPlugin(requiresRestart = false)
public class Main extends Plugin {
    @Override
    public final void start(final Context context) {
    }

    @Override
    public final void stop(final Context context) {
        patcher.unpatchAll();
    }
}