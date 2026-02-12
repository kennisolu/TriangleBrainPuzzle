package com.trianglebrain.puzzle.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trianglebrain.puzzle.R

class GameActivity : AppCompatActivity() {

    private lateinit var gameView: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)

        gameView = findViewById(R.id.gameView)
    }

    override fun onResume() {
        super.onResume()
        gameView.startGame()
    }

    override fun onPause() {
        super.onPause()
        gameView.stopGame()
    }
}
