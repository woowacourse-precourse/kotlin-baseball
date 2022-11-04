package baseball

import baseball.domain.Player
import baseball.resources.*
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGame {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        outputView.getMessageNewLine(GAME_START)
        do {
            outputView.getMessage(REQUEST_PLAYER_NUMBER)
            playGame()
        } while (false)
    }

    private fun playGame() {
        do {
            val player = Player(inputView.getPlayerNumber())
        } while (false)
    }
}
