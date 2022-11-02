package baseball

import baseball.Constant.Companion.startBallCount
import baseball.Constant.Companion.startStrikeCount

class PlayBaseballGame {
    val computerNum = ComputerNumberCreate().computerNumber
    val playerNum = PlayerNumber().toListPlayerNumber
    init {
        println("숫자를 입력해주세요 : ")
        println(computerNum)
        println(playerNum)
    }

    fun countBall(computerNum: List<Int>, playerNum: List<Int>): Int {
        var ball = startBallCount
        for (index in 0..playerNum.size) {
            if (playerNum[index] != computerNum[index] && computerNum.contains(playerNum[index])){
                ball += 1
            }
        }
        return ball
    }

    fun countStrike(computerNum: List<Int>, playerNum: List<Int>): Int {
        var strike = startStrikeCount
        for (index in 0..playerNum.size) {
            if (playerNum[index] == computerNum[index]){
                strike += 1
            }
        }
        return strike
    }

}