package com.trianglebrain.puzzle.game

data class TriangleCell(
    val row: Int,
    val col: Int,
    var occupied: Boolean = false,
    val isUp: Boolean = (row + col) % 2 == 0
)
