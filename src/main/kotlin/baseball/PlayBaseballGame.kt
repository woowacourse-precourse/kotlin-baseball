package baseball

import baseball.Constant.Companion.startBallCount
import baseball.Constant.Companion.startStrikeCount

class PlayBaseballGame {
    val computerNum = ComputerNumberCreate().computerNumber
    val playerNum = PlayerNumber().toListPlayerNumber
    val countStrike = countStrike(computerNum, playerNum)
    val countBall = countBall(computerNum, playerNum)
    init {
        ballCountPrint(countBall)
        strikeCountPrint(countStrike)
    }
    fun ballCountPrint(ballCount:Int){
        if (ballCount > 0) print("${ballCount}볼 ")
    }

    fun strikeCountPrint(strikeCount:Int){
        if (strikeCount > 0) print("${strikeCount}스트라이크")
    }

    fun nothingPrint(ballCount: Int, strikeCount: Int){
        if (ballCount == 0 && strikeCount == 0) print("낫싱")
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