package com.trianglebrain.puzzle.game

class BasicScoringStrategy(
    private val actionType: ActionType,
    private val baseScore: Int
) : ScoringStrategy {

    override fun supports(action: ActionType): Boolean =
        action == actionType

    override fun calculate(combo: Int): Int =
        baseScore + (combo * (baseScore / 2))
}
