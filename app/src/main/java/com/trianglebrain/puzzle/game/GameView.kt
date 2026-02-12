package com.trianglebrain.puzzle.ui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.Choreographer
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.trianglebrain.puzzle.game.*

class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs), Choreographer.FrameCallback {

    private val board = Board(8, 8)
    private val rules = GameRules.defaultRules()
    private val engine = GameEngine(board, rules)

    private val renderer = TriangleRenderer()
    private val particleSystem = ParticleSystem()

    private val gestureDetector =
        GestureDetector(context, GameGestureListener())

    private var running = false
    private var lastFrameTime = 0L

    /* ---------------- Lifecycle ---------------- */

    fun startGame() {
        if (running) return
        running = true
        lastFrameTime = 0L
        Choreographer.getInstance().postFrameCallback(this)
    }

    fun stopGame() {
        running = false
        Choreographer.getInstance().removeFrameCallback(this)
    }

    fun resetGame() {
        engine.reset()
        invalidate()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stopGame()
    }

    /* ---------------- Frame Loop ---------------- */

    override fun doFrame(frameTimeNanos: Long) {

        if (!running) return

        val delta = if (lastFrameTime == 0L) {
            0f
        } else {
            (frameTimeNanos - lastFrameTime) / 1_000_000_000f
        }

        lastFrameTime = frameTimeNanos

        update(delta)
        invalidate()

        Choreographer.getInstance().postFrameCallback(this)
    }

    private fun update(delta: Float) {
        particleSystem.update(delta)
    }

    /* ---------------- Drawing ---------------- */

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        renderer.renderBoard(canvas, board)
        renderer.renderActivePiece(canvas, engine.activePiece)
        renderer.renderParticles(canvas, particleSystem.particles())
    }

    /* ---------------- Input ---------------- */

    override fun onTouchEvent(event: MotionEvent): Boolean =
        gestureDetector.onTouchEvent(event)

    private inner class GameGestureListener :
        GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(e: MotionEvent): Boolean {

            val cell = renderer.screenToBoard(e.x, e.y)
                ?: return false

            val placed = engine.placeActivePiece(cell.first, cell.second)

            if (placed) {
                particleSystem.emit(e.x, e.y)
            }

            return true
        }

        override fun onLongPress(e: MotionEvent) {
            engine.rotateActivePiece()
        }
    }
}
