package baseball.controller

import baseball.message.GameMessage.CORRECT_ANSWER
import baseball.message.GameMessage.GAME_START
import baseball.message.GameMessage.PLEASE_INPUT
import baseball.message.GameMessage.RETRY_GAME
import baseball.message.GameMessage.RETRY_OR_END
import baseball.model.BaseballMaker
import baseball.model.Player
import baseball.model.RandomNumberGenerator
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGame {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun runGame() {
        var gameGo = true
        while(gameGo) {
            outputView.printMessage(GAME_START)
            playGame()
            outputView.printMessage (CORRECT_ANSWER)
            gameGo = retry()
        }
    }

    private fun playGame() {
        val numbers = BaseballMaker(RandomNumberGenerator()).makeBaseball()
        val player = Player(numbers)
        var gameResult = hashMapOf(Pair("Strike", 0), Pair("Ball", 0))
        while (gameResult["Strike"] != 3) {
            outputView.printMessage(PLEASE_INPUT)
            gameResult = player.guess()
        }
    }

    private fun retry():Boolean {
        outputView.printMessage(RETRY_OR_END)
        val isRetry = inputView.readRetry()
        if (isRetry == RETRY_GAME)
            return true
        return false
    }
}