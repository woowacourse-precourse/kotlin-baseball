package baseball.controller

import baseball.utils.Constant.ACTIVE_STATE_CODE
import baseball.utils.Constant.QUIT_STATE_CODE
import baseball.utils.ResultType
import baseball.model.Computer
import baseball.model.Computer.generateRandomNumber
import baseball.utils.Calculator
import baseball.view.Player
import baseball.view.Printer.printExitGamePhrase
import baseball.view.Printer.printGameStartPhrase
import baseball.view.Printer.printNormalResult
import baseball.view.Printer.printNothingPhrase
import baseball.view.Printer.printWinGamePhrase

class Referee(
    private val player: Player
) {

    lateinit var curGameStateCode: String
        private set

    init {
        printGameStartPhrase()
    }

    fun startGame() {
        curGameStateCode = ACTIVE_STATE_CODE
        generateRandomNumber()
        processBaseBallGame()
    }

    private fun processBaseBallGame() {
        while (curGameStateCode == ACTIVE_STATE_CODE) {
            printGameResult(player.inputAnswerNumber().toGameResult())
        }
    }

    private fun printGameResult(gameResultType: ResultType) {
        when (gameResultType) {
            is ResultType.NormalResult -> printNormalResult(gameResultType.ball, gameResultType.strike)
            is ResultType.NothingResult -> printNothingPhrase()
            is ResultType.CorrectResult -> {
                printWinGamePhrase()
                askRetry()
            }
        }
    }

    private fun askRetry() {
        when (player.inputExitCode()) {
            "1" -> this.startGame()
            "2" ->  {
                printExitGamePhrase()
                curGameStateCode = QUIT_STATE_CODE
            }
        }
    }

}

private fun String.toGameResult(): ResultType {
    val calculator = Calculator(userInput = this)
    calculator.countBallAndStrike()

    return if (this == Computer.randomNumber) ResultType.CorrectResult
    else if (
        !this.contains(Computer.randomNumber[0]) &&
        !this.contains(Computer.randomNumber[1]) &&
        !this.contains(Computer.randomNumber[2])
    ) ResultType.NothingResult
    else ResultType.NormalResult(
        calculator.ballAndStrike.first,
        calculator.ballAndStrike.second
    )
}