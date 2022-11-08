package baseball

import baseball.domain.Game
import baseball.view.InputView
import baseball.view.OutputView
import baseball.view.OutputView.THREE_STRIKE

const val PLAY_GAME = 1
const val STOP_GAME = 2

fun main() {
    OutputView.printStaringMent()
    var gameStatus = PLAY_GAME
    while (gameStatus == PLAY_GAME) {
        playGame()
        gameStatus = InputView.inputGameStatus()
    }
}

fun playGame() {
    val game = Game()
    println(game.computerNumber)

    while (game.strike != THREE_STRIKE) {
        game.resetScore()
        val userNumber = InputView.inputExpectingNumber()
        game.compareNumbers(userNumber)
        OutputView.printResult(game)
    }
}


