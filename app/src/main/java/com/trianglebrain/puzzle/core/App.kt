package com.trianglebrain.puzzle.core

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.trianglebrain.puzzle.system.AnalyticsManager
import com.trianglebrain.puzzle.system.SoundManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeAds()
        AnalyticsManager.initialize(this)
        SoundManager.initialize(this)
    }

    private fun initializeAds() {
        MobileAds.initialize(this)
    }
}
