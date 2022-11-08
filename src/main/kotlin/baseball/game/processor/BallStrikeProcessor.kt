package baseball.game.processor

import baseball.common.MAX_NUMBER_SIZE
import baseball.game.OUTPUT_BALL_MESSAGE
import baseball.game.OUTPUT_BALL_STRIKE_MESSAGE
import baseball.game.OUTPUT_NOTHING_MESSAGE
import baseball.game.OUTPUT_STRIKE_MESSAGE
import baseball.game.ballstate.BallState

object BallStrikeProcessor {
    private val ballStates = MutableList(MAX_NUMBER_SIZE) { BallState.OUT }

    /** 숫자를 비교해서 볼, 스트라이크로 처리하는 함수 **/
    fun processBallStrike(numberOfComputer: String, numberOfPlayer: String) {

        numberOfComputer.forEachIndexed { computerIndex, computerNum ->
            if (computerNum == numberOfPlayer[computerIndex]) { // Strike
                ballStates[computerIndex] = BallState.STRIKE
            }
            else if (numberOfPlayer.contains(computerNum)) { // Ball
                ballStates[computerIndex] = BallState.BALL
            }
            else {
                ballStates[computerIndex] = BallState.OUT
            }
        }
    }

    fun isAllStrike(): Boolean =
        ballStates.all { ballState -> ballState == BallState.STRIKE }

    fun makeBallStateMessage(): String {
        val (ballCount, strikeCount, outCount) = countBallState()
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

    /** 볼, 스트라이크, 아웃의 개수를 세는 함수 **/
    private fun countBallState(): Triple<Int, Int, Int> {
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