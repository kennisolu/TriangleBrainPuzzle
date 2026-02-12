package com.trianglebrain.puzzle.game

import android.content.Context

object ModeRepository {

    private const val PREF = "mode_unlocks"

    fun isUnlocked(context: Context, mode: GameMode): Boolean {
        if (mode == GameMode.CLASSIC) return true

        val prefs = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return prefs.getBoolean(mode.name, false)
    }

    fun unlock(context: Context, mode: GameMode) {
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(mode.name, true)
            .apply()
    }
}
