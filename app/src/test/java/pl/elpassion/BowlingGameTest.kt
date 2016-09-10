package pl.elpassion

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

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

    @Test
    fun shouldCorrectlyCountSpare() {
        game.roll(5)
        game.roll(5) // spare
        game.roll(1)
        (1..17).forEach {
            game.roll(0)
        }

        assertEquals(12, game.score())
    }

    private fun rollNPinsTwentyTimes(pins: Int) {
        (1..20).forEach {
            game.roll(pins)
        }
    }
}

class BowlingGame {

    var score = 0
    val rolls = ArrayList<Int>()

    fun roll(pins: Int) {
        rolls.add(pins)
    }

    fun score(): Int {
        var firstInFrame = 0
        (1..10).forEach {
            if (rolls[firstInFrame] + rolls[firstInFrame + 1] == 10) {
                score += 10 + rolls[firstInFrame + 2]
                firstInFrame += 2
            } else {
                score += rolls[firstInFrame] + rolls[firstInFrame + 1]
                firstInFrame += 2
            }
        }
        return score
    }

}
