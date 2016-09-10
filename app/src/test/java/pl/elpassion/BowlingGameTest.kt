package pl.elpassion

import org.junit.Assert.assertEquals
import org.junit.Test

class BowlingGameTest {

    @Test
    fun shouldReturnScoreEqualsZeroIfPlayerHasNotKnockedAnyPin() {
        val game = BowlingGame()
        (1..20).forEach {
            game.roll(0)
        }
        assertEquals(0, game.score())
    }
}

class BowlingGame {

    fun roll(pins: Int) {

    }

    fun score(): Int {
        return 0
    }

}
