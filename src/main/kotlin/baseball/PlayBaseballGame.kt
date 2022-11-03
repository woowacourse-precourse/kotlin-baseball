package baseball

import baseball.Constant.Companion.numRange
import baseball.Constant.Companion.startBallCount
import baseball.Constant.Companion.startStrikeCount
import baseball.Constant.Companion.errorMessage
import baseball.Constant.Companion.gameCloseSwitch
import baseball.Constant.Companion.gameEndMessage
import baseball.Constant.Companion.newGameSwitch

//import camp.nextstep.edu.missionutils.Console.readLine

class PlayBaseballGame(computerNum: MutableList<Int>) {
    private val playerNumCreate = PlayerNumberCreate()
    val printObject = PrintMethod()

    init {
        printObject.printInputNum()
        val playerNum = playerNumCreate.playerNumber()
        val strike = countStrike(computerNum, playerNum)
        val ball = countBall(computerNum, playerNum)
        printObject.printBallCount(ball, strike)
        printObject.printStrikeCount(strike)
        printObject.printNothing(ball, strike)
        if (notAnswer(strike)) {
            PlayBaseballGame(computerNum)
        }
        if (!notAnswer(strike)) {
            println(gameEndMessage)
            checkNewGame()
        }
    }

    private fun notAnswer(strikeCount: Int): Boolean {
        return strikeCount != numRange
    }

    private fun newGameConstraint(newGame: String) {
        if (newGame != newGameSwitch && newGame != gameCloseSwitch) {
            throw IllegalArgumentException(errorMessage)
        }
    }

    private fun checkNewGame() {
        val newGame = readLine()
        newGameConstraint(newGame.toString())
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