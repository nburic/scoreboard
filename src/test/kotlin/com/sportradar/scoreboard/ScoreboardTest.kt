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
}