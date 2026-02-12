package com.trianglebrain.puzzle.game

class TrianglePiece(
    cells: MutableList<Cell>
) : Piece(cells) {

    fun isValid(): Boolean =
        cells.isNotEmpty()
}
