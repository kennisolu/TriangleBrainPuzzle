package com.trianglebrain.puzzle.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.trianglebrain.puzzle.R
import com.trianglebrain.puzzle.game.GameMode
import com.trianglebrain.puzzle.game.ModeRepository

class ModeSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_select)

        renderModes()
    }

    private fun renderModes() {

        val container = findViewById<LinearLayout>(R.id.modeContainer)
        val inflater = LayoutInflater.from(this)

        GameMode.entries.forEach { mode ->   // Kotlin 1.9 replacement for values()

            val view = inflater.inflate(R.layout.item_mode, container, false)

            val icon = view.findViewById<ImageView>(R.id.icon)
            val title = view.findViewById<TextView>(R.id.title)
            val description = view.findViewById<TextView>(R.id.description)
            val lock = view.findViewById<ImageView>(R.id.lock)

            val unlocked = ModeRepository.isUnlocked(this, mode)

            icon.setImageResource(mode.iconRes)
            title.text = mode.title
            description.text = mode.description
            lock.visibility = if (unlocked) View.GONE else View.VISIBLE

            view.alpha = if (unlocked) 1f else 0.4f

            if (unlocked) {
                view.setOnClickListener { startGame(mode) }
            }

            container.addView(view)
        }
    }
    private fun unlockMode() {

        AdManager.showRewarded(this) {
            unlockSelectedMode()
        }
    }

    private fun startGame(mode: GameMode) {
        startActivity(
            Intent(this, GameActivity::class.java).apply {
                putExtra(GameMode.KEY, mode.id)
            }
        )
        finish()
    }
}
