package baseball

import camp.nextstep.edu.missionutils.Console

class Result {
    var ball = 0
    var strike = 0

    fun getScore(computerNum: String, playerNum: String) {
        ball = 0
        strike = 0
        for (j in 0..2) {
            for (i in 0..2) {
                compareNum(computerNum, playerNum, i, j)
            }
        }
    }

    private fun compareNum(computerNum: String, playerNum: String, i: Int, j: Int) {
        if (computerNum[j] == playerNum[i]) {
            if (i == j)
                strike++
            else
                ball++
        }
    }

    fun printResult(ball: Int, strike: Int) {
        if (ball == 0) {
            if (strike == 0)
                println("낫싱")
            else
                println("${strike}스트라이크")
        }

        if (strike == 0) {
            if (ball != 0) {
                println("${ball}볼")
            }
        }

        if (ball != 0 && strike != 0)
            println("${ball}볼 ${strike}스트라이크")
    }

    fun gameAgainOrExit() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        chooseGameNum = Console.readLine().toInt()
    }
}