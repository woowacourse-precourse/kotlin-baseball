package baseball

import baseball.Constant.Companion.ballMessage
import baseball.Constant.Companion.numRange
import baseball.Constant.Companion.startBallCount
import baseball.Constant.Companion.startStrikeCount
import baseball.Constant.Companion.errorMessage
import baseball.Constant.Companion.gameCloseSwitch
import baseball.Constant.Companion.gameEndMessage
import baseball.Constant.Companion.inputNumberMessage
import baseball.Constant.Companion.newGameSwitch
import baseball.Constant.Companion.nothingMessage
import baseball.Constant.Companion.strikeMessage
import camp.nextstep.edu.missionutils.Console.readLine

class PlayBaseballGame {
    private val computerNum = ComputerNumberCreate().computerNumber
    private val playerNumCreate = PlayerNumberCreate()

    init {
        printInputNum()
        val playerNum = playerNumCreate.playerNumber()
        val strike = countStrike(computerNum, playerNum)
        val ball = countBall(computerNum, playerNum)
        printBallCount(ball)
        printStrikeCount(strike)
        printNothing(ball, strike)
        if (checkRestartGame(strike)) {
            PlayBaseballGame()
        }
        println(gameEndMessage)
        checkNewGame()
    }

    fun newGameConstraint(newGame: String) {
        if (newGame != newGameSwitch && newGame != gameCloseSwitch) {
            throw IllegalArgumentException(errorMessage)
        }
    }
    fun checkNewGame(){
        val newGame = readLine()
        newGameConstraint(newGame)
        if (newGame == newGameSwitch) PlayBaseballGame()
    }

    private fun printInputNum(){
        print(inputNumberMessage)
    }

    fun checkRestartGame(strikeCount: Int): Boolean{
        return strikeCount != numRange
    }

    fun printBallCount(ballCount:Int){
        if (ballCount > 0) print("$ballCount" + ballMessage)
    }

    fun printStrikeCount(strikeCount:Int){
        if (strikeCount > 0) print("$strikeCount" + strikeMessage)
    }

    fun printNothing(ballCount: Int, strikeCount: Int){
        if (ballCount == 0 && strikeCount == 0) print(nothingMessage)
    }


    fun countBall(computerNum: List<Int>, playerNum: List<Int>): Int {
        var ball = startBallCount
        for (index in playerNum.indices) {
            if (playerNum[index] != computerNum[index] && computerNum.contains(playerNum[index])){
                ball += 1
            }
        }
        return ball
    }

    fun countStrike(computerNum: List<Int>, playerNum: List<Int>): Int {
        var strike = startStrikeCount
        for (index in playerNum.indices) {
            if (playerNum[index] == computerNum[index]){
                strike += 1
            }
        }
        return strike
    }

}