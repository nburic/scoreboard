package com.sportradar.scoreboard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ScoreboardTest {
    @Test
    fun shouldStartGame() {
        val scoreboard = Scoreboard()
        scoreboard.startGame("Mexico", "Canada")

        assertEquals(1, scoreboard.matchesInProgress.count())
    }

    @Test
    fun shouldNotStartAlreadyStartedGame() {
        val scoreboard = Scoreboard()
        scoreboard.startGame("Mexico", "Canada")
        scoreboard.startGame("Mexico", "Canada")

        assertEquals(1, scoreboard.matchesInProgress.count())
    }

    @Test
    fun shouldUpdateScore() {
        val scoreboard = Scoreboard()
        scoreboard.startGame("Mexico", "Canada")
        scoreboard.updateScore("Mexico", "Canada", 0, 5)

        val match = scoreboard.matchesInProgress.find { it.homeTeam == "Mexico" && it.awayTeam == "Canada" }

        assertEquals(5, match!!.getTotalScore())
    }

    @Test
    fun shouldNotUpdateScoreIfParamsAreNegative() {
        val scoreboard = Scoreboard()
        scoreboard.startGame("Mexico", "Canada")
        scoreboard.updateScore("Mexico", "Canada", 0, 5)
        scoreboard.updateScore("Mexico", "Canada", 0, -1)

        val match = scoreboard.matchesInProgress.find { it.homeTeam == "Mexico" && it.awayTeam == "Canada" }

        assertEquals(5, match!!.getTotalScore())
    }
}