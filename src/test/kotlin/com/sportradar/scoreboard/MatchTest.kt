package com.sportradar.scoreboard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MatchTest {
    @Test
    fun shouldReturnInitialTotalScoreZero() {
        val match = Match("Mexico", "Canada")

        assertEquals(match.getTotalScore(), 0)
    }

    @Test
    fun shouldReturnTotalScore() {
        val match = Match("Mexico", "Canada")
        match.homeScore = 0
        match.awayScore = 5

        assertEquals(match.getTotalScore(), 5)
    }
}