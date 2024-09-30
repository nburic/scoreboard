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

    @Test
    fun shouldFinishGame() {
        val scoreboard = Scoreboard()
        scoreboard.startGame("Mexico", "Canada")
        scoreboard.updateScore("Mexico", "Canada", 0, 5)
        scoreboard.finishGame("Mexico", "Canada")

        assertEquals(0, scoreboard.matchesInProgress.count())
    }

    @Test
    fun shouldGetSummary() {
        val scoreboard = Scoreboard()
        scoreboard.startGame("Mexico", "Canada")
        scoreboard.startGame("Spain", "Brazil")
        scoreboard.startGame("Germany", "France")
        scoreboard.startGame("Uruguay", "Italy")
        scoreboard.startGame("Argentina", "Australia")

        scoreboard.updateScore("Mexico", "Canada", 0, 5)
        scoreboard.updateScore("Spain", "Brazil", 10, 2)
        scoreboard.updateScore("Germany", "France", 2, 2)
        scoreboard.updateScore("Uruguay", "Italy", 6, 6)
        scoreboard.updateScore("Argentina", "Australia", 3, 1)

        val expectedListOfGames = listOf(
            "Uruguay 6 - Italy 6",
            "Spain 10 - Brazil 2",
            "Mexico 0 - Canada 5",
            "Argentina 3 - Australia 1",
            "Germany 2 - France 2",
        )

        assertEquals(5, scoreboard.matchesInProgress.count())
        assertEquals(expectedListOfGames, scoreboard.getSummary())
    }
}