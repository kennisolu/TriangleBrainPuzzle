package com.trianglebrain.puzzle.game

class Board(
    val rows: Int,
    val cols: Int
) {

    private val grid: Array<Array<Cell>> =
        Array(rows) { r ->
            Array(cols) { c ->
                Cell(r, c)
            }
        }

    fun cells(): List<Cell> {
        val list = mutableListOf<Cell>()
        for (row in grid) {
            for (cell in row) {
                list.add(cell)
            }
        }
        return list
    }
    fun clear() {
        cells().forEach { it.occupied = false }
    }


    fun hasValidMoves(): Boolean {
        // your logic
        return true
    }


    fun deserialize(data: String) {
        // restore logic
    }
}