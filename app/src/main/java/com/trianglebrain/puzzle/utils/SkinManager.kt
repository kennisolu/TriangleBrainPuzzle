package com.trianglebrain.puzzle.utils

import android.content.Context

object SkinManager {

    private const val PREF = "skins"
    private const val KEY_ACTIVE = "active_skin"

    fun getActiveSkin(context: Context): String =
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .getString(KEY_ACTIVE, "default")!!

    fun unlockSkin(context: Context, skinId: String) {
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(skinId, true)
            .apply()
    }

    fun setActiveSkin(context: Context, skinId: String) {
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_ACTIVE, skinId)
            .apply()
    }
}
