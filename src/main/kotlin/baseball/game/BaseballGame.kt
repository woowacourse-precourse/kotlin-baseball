package baseball.game

import utils.Constants.ANSWER_BALL
import utils.Constants.ANSWER_STRIKE

class BaseballGame : Game {

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun askRestart(): Boolean {
        TODO("Not yet implemented")
    }

    private fun isAnswer(strike: Int, ball: Int): Boolean =
        (strike == ANSWER_STRIKE && ball == ANSWER_BALL)

}