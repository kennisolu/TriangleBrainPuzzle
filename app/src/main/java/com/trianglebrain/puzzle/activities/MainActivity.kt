package com.trianglebrain.puzzle.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trianglebrain.puzzle.R
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.playButton)
            .setOnClickListener {
                startActivity(Intent(this, GameActivity::class.java))
            }
    }
}
