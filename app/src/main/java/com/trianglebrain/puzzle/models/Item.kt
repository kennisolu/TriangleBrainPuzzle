package com.trianglebrain.puzzle.models

data class Item(
    val iconRes: Int,
    val title: String,
    val description: String,
    val isLocked: Boolean = false
)
