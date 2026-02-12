package com.trianglebrain.puzzle.game

data class Cell(
    val row: Int,
    val col: Int,
    val isLight: Boolean = true,
    var occupied: Boolean = false
)
