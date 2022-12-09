package baseball.controller

import baseball.model.Judgment
import baseball.model.NumberGenerator
import baseball.view.io.InputView
import baseball.view.io.OutputView

class BaseballActivity {
    private val outputView: OutputView = OutputView()
    private val inputView: InputView = InputView()
    private val judgment: Judgment = Judgment()
    private val numberGenerator = NumberGenerator()

    private fun gameStart(){
        outputView.gameStart()
    }
}