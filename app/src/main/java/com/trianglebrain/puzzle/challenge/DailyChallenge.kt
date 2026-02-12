package com.trianglebrain.puzzle.challenge

import java.util.Calendar

object DailyChallenge {

    fun todaySeed(): Int {
        val c = Calendar.getInstance()
        return c.get(Calendar.YEAR) * 1000 +
                c.get(Calendar.DAY_OF_YEAR)
    }

    fun getTargetScore(): Int {
        return 500 + (todaySeed() % 300)
    }
}
