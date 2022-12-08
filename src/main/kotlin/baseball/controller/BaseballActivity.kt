package baseball.controller

import baseball.view.OutputView

class BaseballActivity {
    private val outputView: OutputView = OutputView()
    init {
        outputView.gameStart()
        outputView.baseballGame()
        outputView.restartGame()
    }
}