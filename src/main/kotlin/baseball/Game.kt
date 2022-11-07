package baseball

import camp.nextstep.edu.missionutils.Console
import utils.Constants

class Game {
    fun start(computer: List<Int>): Boolean {
        var isRightAnswer = false
        while (!isRightAnswer) {
            print(Constants.INPUT_PLAYER_MESSAGE)
            val player = Console.readLine()
            if (!isCorrectNumber(player)) {
                throw IllegalArgumentException()
            }

            val strikeNum = getStrikeNum(computer, player)
            val ballNum = getBallNum(computer, player, strikeNum)
            // 3스트라이크 여부
            isRightAnswer = printBallNStrike(strikeNum, ballNum)
        }
        // 게임 재시작 or 완전히 종료 선택
        return choiceGameRestart()
    }

    fun isCorrectNumber(player: String): Boolean {
        // 1. 3자리 수가 아닐 경우 false
        if (player.length != 3)
            return false
        // 2. 1-9의 범위를 벗어난 숫자가 아닐 경우 false
        for (c in player) {
            if (c < '0' || c > '9')
                return false
        }
        // 3. 서로 다른 수를 입력하지 않았을 경우 (=중복된 수를 입력할 경우) false
        if (player[0] == player[1] || player[0] == player[1] ||
            player[1] == player[2]
        )
            return false

        return true
    }

    fun getStrikeNum(computer: List<Int>, player: String): Int {
        var strikeNum = 0
        for (i in computer.indices) {
            val computerNumber = computer[i]
            val playerNumber = player[i] - '0'
            if (computerNumber == playerNumber)
                strikeNum++
        }
        return strikeNum
    }


    fun getBallNum(computer: List<Int>, player: String, strikeNum: Int): Int {
        var ballNum = 0
        for (playerCharacter in player) {
            val playerNumber = playerCharacter - '0'
            if (computer.contains(playerNumber))
                ballNum++
        }
        return ballNum - strikeNum
    }


    fun printBallNStrike(strikeNum: Int, ballNum: Int): Boolean {
        var rightAnswer = false
        if (strikeNum == 0 && ballNum == 0)
            println("낫싱")
        else {
            if (ballNum > 0)
                print("${ballNum}볼 ")
            if (strikeNum > 0)
                print("${strikeNum}스트라이크")
            println()

            if (strikeNum == 3)
                rightAnswer = true
        }

        return rightAnswer
    }

    // 게임을 완전히 종료할 것인지(2) 재시작할 것인지(1)
    fun choiceGameRestart(): Boolean {
        println(Constants.GAME_OVER_MESSAGE)
        println(Constants.ASK_GAME_RESTART_MESSAGE)
        return when (Console.readLine()) {
            Constants.RESTART -> true
            Constants.GAME_OVER -> false
            else ->
                throw IllegalArgumentException()
        }
    }

}