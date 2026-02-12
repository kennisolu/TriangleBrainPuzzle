package com.trianglebrain.puzzle.services

import android.app.Activity
import com.google.android.gms.games.PlayGames

object PlayGamesManager {

    fun signIn(activity: Activity) {
        PlayGames.getGamesSignInClient(activity)
            .signIn()
    }

    fun submitScore(activity: Activity, leaderboardId: String, score: Int) {
        PlayGames.getLeaderboardsClient(activity)
            .submitScore(leaderboardId, score.toLong())
    }

    fun unlockAchievement(activity: Activity, achievementId: String) {
        PlayGames.getAchievementsClient(activity)
            .unlock(achievementId)
    }
}
