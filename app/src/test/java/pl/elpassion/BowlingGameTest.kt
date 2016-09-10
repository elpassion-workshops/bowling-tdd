package pl.elpassion

import org.junit.Assert.assertEquals
import org.junit.Test

class BowlingGameTest {

    @Test
    fun shouldReturnScoreEqualsZeroIfPlayerHasNotKnockedAnyPin() {
        val game = BowlingGame()
        rollZeroTwentyTimes(game)
        assertEquals(0, game.score())
    }

    @Test
    fun shouldReturnScoreEquals20IfPlayerHasKnockedOnePinInEveryThrow() {
        val game = BowlingGame()
        (1..20).forEach {
            game.roll(1)
        }
        assertEquals(20, game.score())
    }

    private fun rollZeroTwentyTimes(game: BowlingGame) {
        (1..20).forEach {
            game.roll(0)
        }
    }
}

class BowlingGame {

    var score = 0

    fun roll(pins: Int) {
        score += pins
    }

    fun score(): Int {
        return score
    }

}
