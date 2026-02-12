package com.trianglebrain.puzzle.game

import android.content.Context
import androidx.core.content.edit
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("unused")
object DailyChallengeManager {

    private const val PREF = "daily_challenge"
    private const val KEY_DATE = "date"
    private const val KEY_SCORE = "score"

    private fun today(): String =
        SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    fun isNewDay(context: Context): Boolean =
        prefs(context).getString(KEY_DATE, "") != today()

    fun startNewDay(context: Context) {
        prefs(context).edit {
            putString(KEY_DATE, today())
            putInt(KEY_SCORE, 0)
        }
    }

    fun saveScore(context: Context, score: Int) {
        prefs(context).edit {
            putInt(KEY_SCORE, score)
        }
    }
}
