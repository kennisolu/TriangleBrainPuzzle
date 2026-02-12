package com.trianglebrain.puzzle.ui

import android.app.Activity
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AlertDialog
import com.trianglebrain.puzzle.R

object DialogFactory {

    fun gameOver(
        activity: Activity,
        score: Int,
        best: Int,
        onRestart: () -> Unit,
        onExit: () -> Unit
    ) {
        val view = activity.layoutInflater.inflate(R.layout.dialog_game_over, null)

        view.findViewById<android.widget.TextView>(R.id.tvScore).text = "Score: $score"
        view.findViewById<android.widget.TextView>(R.id.tvBestScore).text = "Best: $best"

        val dialog = AlertDialog.Builder(activity)
            .setView(view)
            .setCancelable(false)
            .create()

        view.findViewById<View>(R.id.btnRestart).setOnClickListener {
            onRestart()
            dialog.dismiss()
        }

        view.findViewById<View>(R.id.btnExit).setOnClickListener {
            onExit()
        }

        view.scaleX = 0f
        view.scaleY = 0f
        dialog.show()

        view.animate()
            .scaleX(1f)
            .scaleY(1f)
            .setInterpolator(BounceInterpolator())
            .setDuration(300)
            .start()
    }
}
