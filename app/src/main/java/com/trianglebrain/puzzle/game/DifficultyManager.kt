package com.trianglebrain.puzzle.game

object DifficultyManager {

    fun boardSize(score: Int): Int {
        return when {
            score < 100 -> 10
            score < 300 -> 11
            score < 600 -> 12
            else -> 13
        }
    }

    fun speedMultiplier(score: Int): Float {
        return when {
            score < 200 -> 1.0f
            score < 500 -> 1.1f
            else -> 1.2f
        }
    }
}
