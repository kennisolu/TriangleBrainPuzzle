package com.trianglebrain.puzzle.data

import android.content.Context
import com.trianglebrain.puzzle.game.GameState

class SavedGameStore(context: Context) {

    private val prefs =
        context.getSharedPreferences("saved_game", Context.MODE_PRIVATE)

    fun save(state: GameState) {
        prefs.edit()
            .putInt("score", state.score)
            .putInt("rows", state.rows)
            .putInt("cols", state.cols)
            .putString("board", state.boardData.joinToString(","))
            .apply()
    }

    fun load(): GameState? {

        val score = prefs.getInt("score", -1)
        val rows = prefs.getInt("rows", -1)
        val cols = prefs.getInt("cols", -1)
        val boardString = prefs.getString("board", null)

        if (score < 0 || rows <= 0 || cols <= 0 || boardString == null)
            return null

        return try {

            val boardData = boardString
                .split(",")
                .map { it.toInt() }
                .toIntArray()

            GameState(score, rows, cols, boardData)

        } catch (_: Exception) {
            null
        }
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}
