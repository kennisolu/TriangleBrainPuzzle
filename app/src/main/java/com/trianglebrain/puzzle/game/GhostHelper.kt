package com.trianglebrain.puzzle.game

object GhostHelper {

    fun findBestPlacement(board: Board, piece: TrianglePiece): Pair<Int, Int>? {
        for (r in 0 until board.rows) {
            for (c in 0 until board.cols) {
                if (board.canPlace(piece, r, c)) {
                    return r to c
                }
            }
        }
        return null
    }
}
