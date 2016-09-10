package pl.elpassion

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class BowlingGameTest {

    val game = BowlingGame()

    @Test
    fun shouldReturnScoreEqualsZeroIfPlayerHasNotKnockedAnyPin() {
        rollNPinsTimes(0, 20)
        assertEquals(0, game.score())
    }

    @Test
    fun shouldReturnScoreEquals20IfPlayerHasKnockedOnePinInEveryThrow() {
        rollNPinsTimes(1, 20)
        assertEquals(20, game.score())
    }

    @Test
    fun shouldCorrectlyCountSpare() {
        rollSpare()
        game.roll(1)
        rollNPinsTimes(0, 17)

        assertEquals(12, game.score())
    }

    @Test
    fun shouldCorrectlyCountStrike() {
        rollStrike()
        game.roll(2)
        game.roll(2)
        rollNPinsTimes(0, 16)

        assertEquals(18, game.score())
    }

    private fun rollStrike() {
        game.roll(10)
    }

    private fun rollSpare() {
        rollNPinsTimes(5,2)
    }

    private fun rollNPinsTimes(pins: Int, times: Int) {
        (1..times).forEach {
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
            if (rolls[firstInFrame] == 10){
                score += 10 + rolls[firstInFrame + 1] + rolls[firstInFrame + 2]
                firstInFrame += 1
            } else if (isSpare(firstInFrame)) {
                score += 10 + countSpareBonusScore(firstInFrame)
                firstInFrame += 2
            } else {
                score += countNormalFrameScore(firstInFrame)
                firstInFrame += 2
            }
        }
        return score
    }

    private fun countSpareBonusScore(firstInFrame: Int) = rolls[firstInFrame + 2]

    private fun countNormalFrameScore(firstInFrame: Int) = rolls[firstInFrame] + rolls[firstInFrame + 1]

    private fun isSpare(firstInFrame: Int) = rolls[firstInFrame] + rolls[firstInFrame + 1] == 10

}
