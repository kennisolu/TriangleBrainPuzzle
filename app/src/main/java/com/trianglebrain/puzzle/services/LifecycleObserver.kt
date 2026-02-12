package com.trianglebrain.puzzle.system

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class AppLifecycleObserver : DefaultLifecycleObserver {

    override fun onPause(owner: LifecycleOwner) {
        SoundManager.release()
    }

    override fun onResume(owner: LifecycleOwner) {
        // SoundManager will lazy re-init
    }
}
