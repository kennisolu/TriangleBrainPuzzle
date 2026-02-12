package com.trianglebrain.puzzle.game

data class Piece(
    val cells: MutableList<Cell>
) {

    fun rotate() {
        if (cells.isEmpty()) return

        val pivot = cells.first()

        val rotated = cells.map { cell ->
            val newRow = pivot.row - (cell.col - pivot.col)
            val newCol = pivot.col + (cell.row - pivot.row)
            cell.copy(row = newRow, col = newCol)
        }

        cells.clear()
        cells.addAll(rotated)
    }

    fun deepCopy(): Piece =
        Piece(cells.map { it.copy() }.toMutableList())
}
