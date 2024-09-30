package org.example.com.sportradar.scoreboard

import java.time.LocalDateTime

class Match(
    val homeTeam: String,
    val awayTeam: String,
    var homeScore: Int = 0,
    var awayScore: Int = 0,
    val startTime: LocalDateTime = LocalDateTime.now()
) {
    fun getTotalScore(): Int {
        return homeScore + awayScore
    }

    override fun toString(): String {
        return "${homeTeam} ${homeScore} - ${awayTeam} ${awayScore}"
    }
}
