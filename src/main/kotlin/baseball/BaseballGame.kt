package baseball

import baseball.resources.*
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGame {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        outputView.getMessageNewLine(GAME_START)
        try {
            do {
                outputView.getMessage(REQUEST_PLAYER_NUMBER)
                playGame()
            } while (false)
        }catch (e : IllegalArgumentException) {
            println("${e.message} 은/는 올바른 입력 형식이 압니다.")
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun playGame() {
        do {
            val playerNumber = inputView.getPlayerNumber().toInt()
        }while (false)
    }
}
