package baseball

class BaseballActivity {
    private val outputView:OutputView = OutputView()
    init {
        outputView.baseballGame()
        outputView.restartGame()
    }
}