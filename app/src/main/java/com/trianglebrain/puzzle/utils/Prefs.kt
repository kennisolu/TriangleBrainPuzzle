package com.trianglebrain.puzzle.utils

import android.content.Context

object Prefs {

    private const val PREFS = "triangle_prefs"
    private const val BEST = "best_score"

    fun updateBestScore(context: Context, score: Int): Int {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val best = prefs.getInt(BEST, 0)
        return if (score > best) {
            prefs.edit().putInt(BEST, score).apply()
            score
        } else best
    }
}
fun isSoundEnabled(context: Context): Boolean =
    context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        .getBoolean("sound", true)

fun setSoundEnabled(context: Context, enabled: Boolean) =
    context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        .edit().putBoolean("sound", enabled).apply()

fun isVibrationEnabled(context: Context): Boolean =
    context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        .getBoolean("vibration", true)

fun setVibrationEnabled(context: Context, enabled: Boolean) =
    context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        .edit().putBoolean("vibration", enabled).apply()
