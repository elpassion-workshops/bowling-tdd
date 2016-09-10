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

    private fun rollZeroTwentyTimes(game: BowlingGame) {
        (1..20).forEach {
            game.roll(0)
        }
    }
}

class BowlingGame {

    fun roll(pins: Int) {

    }

    fun score(): Int {
        return 0
    }

}
