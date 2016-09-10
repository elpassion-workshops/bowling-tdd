package pl.elpassion

import org.junit.Assert.assertEquals
import org.junit.Test

class BowlingGameTest {

    val game = BowlingGame()

    @Test
    fun shouldReturnScoreEqualsZeroIfPlayerHasNotKnockedAnyPin() {
        rollNPinsTwentyTimes(0)
        assertEquals(0, game.score())
    }

    @Test
    fun shouldReturnScoreEquals20IfPlayerHasKnockedOnePinInEveryThrow() {
        rollNPinsTwentyTimes(1)
        assertEquals(20, game.score())
    }

    private fun rollNPinsTwentyTimes(pins: Int) {
        (1..20).forEach {
            game.roll(pins)
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
