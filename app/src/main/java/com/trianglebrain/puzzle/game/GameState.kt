package com.trianglebrain.puzzle.game

data class GameState(
    val score: Int,
    val rows: Int,
    val cols: Int,
    val boardData: IntArray
)
