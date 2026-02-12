package com.trianglebrain.puzzle.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*

class GameBackgroundService : Service() {

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Default
    )

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    fun runTask(block: suspend () -> Unit) {
        scope.launch { block() }
    }
}
