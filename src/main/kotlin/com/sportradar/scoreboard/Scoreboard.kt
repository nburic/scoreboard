package com.sportradar.scoreboard

import org.example.com.sportradar.scoreboard.Match

class Scoreboard {
    private val _matchesInProgress: MutableList<Match> = mutableListOf()
    val matchesInProgress: List<Match> = _matchesInProgress

    fun startGame(homeTeam: String, awayTeam: String) {
        val match = Match(homeTeam, awayTeam)

        val matchInProgress = _matchesInProgress.find { it.homeTeam == match.homeTeam && it.awayTeam == match.awayTeam }
        if (matchInProgress != null) {
            println("Match is already in progress.")
        } else {
            _matchesInProgress.add(match)
            println("Match has started.")
        }
    }

    fun updateScore(homeTeam: String, awayTeam: String, homeScore: Int, awayScore: Int) {
        return
    }
}
