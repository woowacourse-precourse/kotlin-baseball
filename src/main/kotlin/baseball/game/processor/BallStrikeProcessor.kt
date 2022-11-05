package baseball.game.processor

import baseball.common.MAX_NUMBER_SIZE
import baseball.game.OUTPUT_BALL_MESSAGE
import baseball.game.OUTPUT_BALL_STRIKE_MESSAGE
import baseball.game.OUTPUT_NOTHING_MESSAGE
import baseball.game.OUTPUT_STRIKE_MESSAGE
import baseball.game.ballstate.BallState

class BallStrikeProcessor {
    private val ballStates = MutableList(MAX_NUMBER_SIZE) { BallState.OUT }

    fun checkBallStrike(numberOfComputer: String, numberOfPlayer: String) {

        numberOfComputer.forEachIndexed { cIdx, computerNum ->
            if (computerNum == numberOfPlayer[cIdx]) { // Strike
                ballStates[cIdx] = BallState.STRIKE
            }
            else if (numberOfPlayer.contains(computerNum)) { // Ball
                ballStates[cIdx] = BallState.BALL
            }
            else {
                ballStates[cIdx] = BallState.OUT
            }
        }
    }

    fun isAllStrike(): Boolean =
        ballStates.all { ballState -> ballState == BallState.STRIKE }

    fun makeBallStateMessage(): String {
        val (ballCount, strikeCount, outCount) = calcBallState()
        var message = ""

        if (outCount == ballStates.size) {
            message = OUTPUT_NOTHING_MESSAGE
        }
        if (strikeCount != 0 && ballCount != 0) {
            message = OUTPUT_BALL_STRIKE_MESSAGE.format(ballCount, strikeCount)
        }
        if (strikeCount != 0 && ballCount == 0) {
            message = OUTPUT_STRIKE_MESSAGE.format(strikeCount)
        }
        if (strikeCount == 0 && ballCount != 0) {
            message = OUTPUT_BALL_MESSAGE.format(ballCount)
        }

        return message
    }

    fun initBallState() {
        ballStates.replaceAll { BallState.OUT }
    }

    private fun calcBallState(): Triple<Int, Int, Int> {
        var ballCount = 0
        var strikeCount = 0
        var outCount = 0

        ballStates.forEach { ballState ->
            when (ballState) {
                BallState.BALL -> ballCount++
                BallState.STRIKE -> strikeCount++
                BallState.OUT -> outCount++
            }
        }

        return Triple(ballCount, strikeCount, outCount)
    }

}