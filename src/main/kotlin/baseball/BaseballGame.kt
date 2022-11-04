package baseball

import baseball.resources.*
import baseball.view.OutputView

class BaseballGame {

    private val outputView = OutputView()

    fun run() {
        outputView.getMessageNewLine(GAME_START)
       do {
           outputView.getMessage(REQUEST_PLAYER_NUMBER)
       } while (false)
    }
}
