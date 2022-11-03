package baseball

import baseball.Constant.Companion.startBallCount
import baseball.Constant.Companion.startStrikeCount
import baseball.Constant.Companion.errorMessage
import baseball.Constant.Companion.gameCloseSwitch
import baseball.Constant.Companion.gameEndMessage
import baseball.Constant.Companion.newGameSwitch
import baseball.Constant.Companion.numberRange

import camp.nextstep.edu.missionutils.Console.readLine

class PlayBaseballGame(private val computerNum: MutableList<Int>) {
    private val playerNumCreate = PlayerNumberCreate()
    private val printObject = PrintMethod()
    private val playerNum = playerNumCreate.playerNumber()
    private val strike = countStrike(computerNum, playerNum)
    private val ball = countBall(computerNum, playerNum)

    init {
        printHint()
        checkAnswer()
    }

    private fun printHint() {
        printObject.printBallCount(ball, strike)
        printObject.printStrikeCount(strike)
        printObject.printNothing(ball, strike)
    }

    private fun checkAnswer() {
        if (isNotAnswer(strike)) PlayBaseballGame(this.computerNum)
        if (isAnswer(strike)) {
            println(gameEndMessage)
            checkNewGame()
        }
    }

    private fun isAnswer(strikeCount: Int): Boolean {
        return strikeCount == numberRange
    }

    private fun isNotAnswer(strikeCount: Int): Boolean {
        return strikeCount != numberRange
    }

    private fun newGameConstraint(newGame: String) {
        if (newGame != newGameSwitch && newGame != gameCloseSwitch) {
            throw IllegalArgumentException(errorMessage)
        }
    }

    private fun checkNewGame() {
        val newGame = readLine()
        newGameConstraint(newGame)
        if (newGame == newGameSwitch) PlayBaseballGame(ComputerNumberCreate().computerNumber)
    }

    private fun countBall(computerNum: List<Int>, playerNum: List<Int>): Int {
        var ball = startBallCount
        for (index in playerNum.indices) {
            if (playerNum[index] != computerNum[index] && computerNum.contains(playerNum[index])) {
                ball += 1
            }
        }
        return ball
    }

    private fun countStrike(computerNum: List<Int>, playerNum: List<Int>): Int {
        var strike = startStrikeCount
        for (index in playerNum.indices) {
            if (playerNum[index] == computerNum[index]) {
                strike += 1
            }
        }
        return strike
    }

}