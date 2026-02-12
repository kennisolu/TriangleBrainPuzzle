package com.trianglebrain.puzzle.utils

import android.animation.ObjectAnimator
import android.view.MotionEvent
import android.view.View

/**
 * Adds a press scale effect with minimal allocations and full accessibility support.
 */
fun View.addPressScaleEffect(
    scale: Float = 0.95f,
    duration: Long = 100L
) {

    fun View.animateScale(value: Float) {
        ObjectAnimator.ofFloat(this, View.SCALE_X, value).apply {
            this.duration = duration
            start()
        }
        ObjectAnimator.ofFloat(this, View.SCALE_Y, value).apply {
            this.duration = duration
            start()
        }
    }

    setOnTouchListener { v, event ->
        when (event.action) {

            MotionEvent.ACTION_DOWN -> {
                v.animateScale(scale)
            }

            MotionEvent.ACTION_UP -> {
                v.animateScale(1f)

                val isClick =
                    event.x in 0f..v.width.toFloat() &&
                            event.y in 0f..v.height.toFloat()

                if (isClick) v.performClick()
            }

            MotionEvent.ACTION_CANCEL -> {
                v.animateScale(1f)
            }
        }
        true
    }
}
