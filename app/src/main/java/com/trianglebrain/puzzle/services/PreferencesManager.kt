package com.trianglebrain.puzzle.system

import android.content.Context

class PreferencesManager(context: Context) {

    private val prefs =
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    var soundEnabled: Boolean
        get() = prefs.getBoolean("sound", true)
        set(value) = prefs.edit().putBoolean("sound", value).apply()

    var highScore: Int
        get() = prefs.getInt("high_score", 0)
        set(value) = prefs.edit().putInt("high_score", value).apply()
}
