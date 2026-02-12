package com.trianglebrain.puzzle.ads

import android.app.Activity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class AdManager {

    private var interstitial: InterstitialAd? = null

    fun load(activity: Activity, adUnit: String) {

        val request = AdRequest.Builder().build()

        InterstitialAd.load(
            activity,
            adUnit,
            request,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitial = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    interstitial = null
                }
            }
        )
    }

    fun show(activity: Activity, onClosed: (() -> Unit)? = null) {

        val ad = interstitial ?: run {
            onClosed?.invoke()
            return
        }

        ad.fullScreenContentCallback =
            object : FullScreenContentCallback() {

                override fun onAdDismissedFullScreenContent() {
                    interstitial = null
                    onClosed?.invoke()
                }
            }

        ad.show(activity)
    }
}
