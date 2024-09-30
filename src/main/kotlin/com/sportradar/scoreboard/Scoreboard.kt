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
        val matchInProgress = _matchesInProgress.find { it.homeTeam == homeTeam && it.awayTeam == awayTeam }
        when {
            matchInProgress == null -> println("Match is not in progress.")
            homeScore < 0 || awayScore < 0 -> println("Incorrect params.")
            else -> {
                matchInProgress.homeScore = homeScore
                matchInProgress.awayScore = awayScore
            }
        }
    }

    fun finishGame(homeTeam: String, awayTeam: String) {
        _matchesInProgress.removeIf { it.homeTeam == homeTeam && it.awayTeam == awayTeam }
    }

    fun getSummary(): List<Match> {
        return matchesInProgress.sortedWith(compareByDescending<Match> { it.getTotalScore() }.thenByDescending { it.startTime })
    }
}
