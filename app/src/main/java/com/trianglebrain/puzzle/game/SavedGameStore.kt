package com.trianglebrain.puzzle.game

import android.content.Context

object SavedGameStore {
    private const val PREF = "game_state"
    private const val KEY = "state"
    fun save(context: Context, state: GameState) {
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .edit().putString(KEY, state.toString()).apply()
    }
    fun load(context: Context): GameState? = null
}
