package com.trianglebrain.puzzle.game

import com.trianglebrain.puzzle.R

enum class GameMode(
    val id: Int,
    val title: String,
    val description: String,
    val iconRes: Int
) {

    CLASSIC(
        id = 0,
        title = "Classic",
        description = "Standard triangle puzzle gameplay",
        iconRes = R.drawable.ic_mode_classic
    ),

    TIMED(
        id = 1,
        title = "Timed",
        description = "Score as much as possible before time runs out",
        iconRes = R.drawable.ic_mode_timed
    ),

    CHALLENGE(
        id = 2,
        title = "Challenge",
        description = "Daily and special challenges",
        iconRes = R.drawable.ic_mode_challenge
    );

    companion object {

        const val KEY = "game_mode"

        fun fromId(id: Int): GameMode {
            return entries.firstOrNull { it.id == id } ?: CLASSIC
        }
    }
}
