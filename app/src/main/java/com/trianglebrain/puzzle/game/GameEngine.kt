package com.trianglebrain.puzzle.game

class GameEngine(
    private val board: Board,
    private val rules: GameRules
) {

    private val comboManager = ComboManager(rules.scoringStrategies)

    var score: Int = 0
        private set

    var activePiece: Piece = PieceFactory.randomPiece()
        private set

    fun rotateActivePiece() {
        activePiece.rotate()
        score += rules.calculateScore(ActionType.ROTATE, comboManager)
    }

    fun placeActivePiece(row: Int, col: Int): Boolean {

        if (!board.canPlace(activePiece, row, col)) {
            comboManager.reset()
            return false
        }

        board.place(activePiece, row, col)

        score += rules.calculateScore(ActionType.PLACE, comboManager)

        val clearedLines = board.clearCompletedLines()
        if (clearedLines > 0) {
            comboManager.increment()
        }

        activePiece = PieceFactory.randomPiece()

        return true
    }

    fun isGameOver(): Boolean =
        !board.hasValidMoves()

    fun reset() {
        board.clear()
        comboManager.reset()
        score = 0
        activePiece = PieceFactory.randomPiece()
    }

    fun saveState(): GameState =
        GameState(
            score = score,
            rows = board.rows,
            cols = board.cols,
            boardData = board.serialize()
        )

    fun restoreState(state: GameState) {
        score = state.score
        board.deserialize(state.boardData)
    }
}
