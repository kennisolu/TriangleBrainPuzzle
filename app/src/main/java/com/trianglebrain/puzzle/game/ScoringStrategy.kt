package com.trianglebrain.puzzle.game

interface ScoringStrategy {
    fun supports(action: ActionType): Boolean
    fun calculate(combo: Int = 0): Int
}
