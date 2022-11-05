package baseball.game.processor

import baseball.game.ballstate.BallState

class BallStrikeProcessor {
    private val ballStates = mutableListOf(BallState.OUT, BallState.OUT, BallState.OUT)

    fun checkBallStrike(
        numberOfComputer: String,
        numberOfPlayer: String
    ) {

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

//        if (ballStates.all { ballState -> ballState == BallState.STRIKE }) {
//            successGame()
//        }
//        else {
//            printBallState()
//        }
    }

//    private fun printBallState() {
//        val (ballCount, strikeCount, outCount) = calcBallState()
//
//        if (outCount == ballStates.size) {
//            printMessage(message = OUTPUT_NOTHING_MESSAGE)
//        }
//        if (strikeCount != 0 && ballCount != 0) {
//            printMessage(message = OUTPUT_BALL_STRIKE_MESSAGE.format(ballCount, strikeCount))
//        }
//        if (strikeCount != 0 && ballCount == 0) {
//            printMessage(message = OUTPUT_STRIKE_MESSAGE.format(strikeCount))
//        }
//        if (strikeCount == 0 && ballCount != 0) {
//            printMessage(OUTPUT_BALL_MESSAGE.format(ballCount))
//        }
//    }

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