package com.trianglebrain.puzzle.game

object PieceFactory {

    fun allPieces(): List<Piece> = listOf(
        trianglePiece(),
        linePiece(),
        squarePiece()
    )

    fun randomPiece(): Piece =
        allPieces().random().deepCopy()

    private fun trianglePiece() = createPiece(
        0 to 0,
        0 to 1
    )

    private fun linePiece() = createPiece(
        0 to 0,
        1 to 0
    )

    private fun squarePiece() = createPiece(
        0 to 0,
        0 to 1,
        1 to 0,
        1 to 1
    )

    private fun createPiece(vararg coords: Pair<Int, Int>): Piece {
        val cells = coords.map {
            Cell(it.first, it.second, true)
        }.toMutableList()

        return Piece(cells)
    }
}
