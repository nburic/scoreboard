package com.sportradar.scoreboard

class Scoreboard {
    private val _matchesInProgress: MutableList<Pair<String, String>> = mutableListOf()
    val matchesInProgress: List<Pair<String, String>> = _matchesInProgress

    fun startGame(homeTeam: String, awayTeam: String) {
        val match = Pair(homeTeam, awayTeam)

        val matchInProgress = _matchesInProgress.find { it.first == match.first && it.second == match.second }
        if (matchInProgress != null) {
            println("Match is already in progress.")
        } else {
            _matchesInProgress.add(match)
            println("Match has started.")
        }
    }

}
