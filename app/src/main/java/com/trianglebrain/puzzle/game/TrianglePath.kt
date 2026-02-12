package com.trianglebrain.puzzle.game

object TrianglePath {

    fun adjacentCells(cell: Cell): List<Pair<Int, Int>> {
        return if (cell.isLight) {
            listOf(
                cell.row to cell.col - 1,
                cell.row to cell.col + 1,
                cell.row + 1 to cell.col
            )
        } else {
            listOf(
                cell.row to cell.col - 1,
                cell.row to cell.col + 1,
                cell.row - 1 to cell.col
            )
        }
    }

    fun findConnectedGroup(
        start: Cell,
        boardCells: Map<Pair<Int, Int>, Cell>
    ): Set<Cell> {

        val visited = mutableSetOf<Cell>()
        val queue = ArrayDeque<Cell>()

        queue.add(start)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (!visited.add(current)) continue

            adjacentCells(current).forEach { (r, c) ->
                val next = boardCells[r to c]
                if (next != null && next.occupied && next !in visited) {
                    queue.add(next)
                }
            }
        }

        return visited
    }
}
