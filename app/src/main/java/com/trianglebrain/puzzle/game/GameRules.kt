package com.trianglebrain.puzzle.game

class GameRules(
    val scoringStrategies: List<ScoringStrategy>
) {

    fun calculateScore(
        action: ActionType,
        comboManager: ComboManager
    ): Int {
        return comboManager.score(action)
    }

    companion object {

        fun defaultRules(): GameRules =
            GameRules(
                scoringStrategies = listOf(
                    BasicScoringStrategy(ActionType.PLACE, 10),
                    BasicScoringStrategy(ActionType.ROTATE, 2),
                    BasicScoringStrategy(ActionType.CLEAR_LINE, 50)
                )
            )
    }
}
