package baseball.controller

import baseball.view.io.OutputView

class BaseballActivity {
    private val outputView: OutputView = OutputView()
    init {
        outputView.gameStart()
        outputView.baseballGame()
        outputView.restartGame()
    }
}