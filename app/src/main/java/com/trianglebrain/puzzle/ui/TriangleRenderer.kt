package com.trianglebrain.puzzle.ui

import android.graphics.Canvas
import android.graphics.Paint
import com.trianglebrain.puzzle.game.Cell
import com.trianglebrain.puzzle.game.Board
import com.trianglebrain.puzzle.game.Piece
import com.trianglebrain.puzzle.game.Particle

class TriangleRenderer {

    private val lightPaint = Paint().apply { isAntiAlias = true }
    private val darkPaint = Paint().apply { isAntiAlias = true }
    private val occupiedPaint = Paint().apply { isAntiAlias = true }
    private val particlePaint = Paint().apply { isAntiAlias = true }

    private var cellSize = 80f

    fun renderBoard(canvas: Canvas, board: Board) {

        board.cells().forEach { cell ->
            drawCell(canvas, cell)
        }
    }

    fun renderActivePiece(canvas: Canvas, piece: Piece) {
        piece.cells.forEach {
            drawCell(canvas, it.copy(occupied = true))
        }
    }

    fun renderParticles(canvas: Canvas, particles: List<Particle>) {

        particles.forEach { p ->
            canvas.drawCircle(
                p.x,
                p.y,
                6f * p.life,
                particlePaint
            )
        }
    }

    private fun drawCell(canvas: Canvas, cell: Cell) {

        val left = cell.col * cellSize
        val top = cell.row * cellSize
        val right = left + cellSize
        val bottom = top + cellSize

        val paint = when {
            cell.occupied -> occupiedPaint
            cell.isLight -> lightPaint
            else -> darkPaint
        }

        canvas.drawRect(left, top, right, bottom, paint)
    }

    /* ---------- Coordinate Mapping ---------- */

    fun screenToBoard(x: Float, y: Float): Pair<Int, Int>? {

        val col = (x / cellSize).toInt()
        val row = (y / cellSize).toInt()

        if (row < 0 || col < 0) return null

        return row to col
    }
}
