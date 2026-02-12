package com.trianglebrain.puzzle.system

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object AnalyticsManager {

    private var analytics: FirebaseAnalytics? = null

    fun initialize(context: Context) {
        if (analytics != null) return
        analytics = FirebaseAnalytics.getInstance(context.applicationContext)
    }

    fun logEvent(name: String, params: Map<String, Any> = emptyMap()) {

        val bundle = Bundle()
        params.forEach { (k, v) ->
            when (v) {
                is Int -> bundle.putInt(k, v)
                is String -> bundle.putString(k, v)
                is Float -> bundle.putFloat(k, v)
                is Double -> bundle.putDouble(k, v)
                is Long -> bundle.putLong(k, v)
            }
        }

        analytics?.logEvent(name, bundle)
    }
}
