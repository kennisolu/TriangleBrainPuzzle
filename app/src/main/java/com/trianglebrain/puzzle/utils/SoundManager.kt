package com.trianglebrain.puzzle.system

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.trianglebrain.puzzle.R

object SoundManager {

    private var soundPool: SoundPool? = null
    private val sounds = mutableMapOf<String, Int>()

    fun initialize(context: Context) {

        if (soundPool != null) return

        val attrs = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(attrs)
            .build()

        sounds["place"] =
            soundPool!!.load(context, R.raw.place, 1)

        sounds["rotate"] =
            soundPool!!.load(context, R.raw.rotate, 1)
    }

    fun play(name: String) {
        val id = sounds[name] ?: return
        soundPool?.play(id, 1f, 1f, 1, 0, 1f)
    }

    fun release() {
        soundPool?.release()
        soundPool = null
        sounds.clear()
    }
}
