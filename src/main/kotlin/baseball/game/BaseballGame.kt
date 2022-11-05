package baseball.game

import baseball.hint.BaseballHint
import baseball.hint.Hint
import utils.ComputerFactory
import utils.Constants.ANSWER_BALL
import utils.Constants.ANSWER_STRIKE
import utils.Constants.CORRECT_AND_FINISH
import utils.Constants.START_GAME_TEXT
import utils.Constants.YES_RESTART
import utils.PlayerConsole

class BaseballGame : Game {

    override fun start() {
        println(START_GAME_TEXT)

        do {
            startGame()
        } while (askRestart())
    }

    override fun askRestart(): Boolean =
        PlayerConsole.enterRestart() == YES_RESTART

    private fun startGame() {
        val computer = ComputerFactory.create()

        do {
            val player = PlayerConsole.enterAnswer()
            player.validate(computer)

            val hint: Hint = BaseballHint(computer, player)
            hint.print()

            val (strike, ball) = hint.provideStrikeAndBall()

        } while (!isAnswer(strike, ball))

        println(CORRECT_AND_FINISH)
    }

    private fun isAnswer(strike: Int, ball: Int): Boolean =
        (strike == ANSWER_STRIKE && ball == ANSWER_BALL)
}