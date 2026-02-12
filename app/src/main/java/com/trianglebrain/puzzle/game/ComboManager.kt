package com.trianglebrain.puzzle.game

class ComboManager(
    private val strategies: List<ScoringStrategy>
) {

    private var comboCount = 0

    fun increment() {
        comboCount++
    }

    fun reset() {
        comboCount = 0
    }

    fun score(action: ActionType): Int {
        val strategy = strategies.firstOrNull { it.supports(action) }
            ?: return 0

        return strategy.calculate(comboCount)
    }

    fun currentCombo(): Int = comboCount
}
