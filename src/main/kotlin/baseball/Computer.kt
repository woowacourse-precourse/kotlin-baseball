package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object Computer {
    var strike = 0
    var ball = 0
    val correctNumber = mutableListOf<Int>()
    fun getCorrectRandomNumber() {
        correctNumber.clear()
        while (correctNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!correctNumber.contains(randomNumber)) {
                correctNumber.add(randomNumber)
            }
        }
    }

    fun compareInputWithCorrectNumber(inputValue: String) {
        for (inputIndex in 0 until correctNumber.size) {
            countScore(inputValue, inputIndex)
        }
        printCurrentScore()
    }

    private fun countScore(inputValue: String, inputIndex: Int) {
        if (inputValue.contains(correctNumber[inputIndex].toString())) {
            if (inputValue[inputIndex].digitToInt() == correctNumber[inputIndex]) {
                strike++
            } else {
                ball++
            }
        }
    }

    fun printCurrentScore() {
        if (strike == 0 && ball == 0) {
            println("낫싱")
        } else if (strike == 0 && ball > 0) {
            println("${ball}볼")
        } else if (strike > 0 && ball == 0) {
            println("${strike}스트라이크")
            if (strike == 3) {
                gameOver()
            }
        } else if (strike > 0 && ball > 0) {
            println("${ball}볼 ${strike}스트라이크")
        }
        strike = 0
        ball = 0
    }

    fun gameOver() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var input = Console.readLine()
        if (input == "1") {
            getCorrectRandomNumber()
        } else if (input == "2") {
            println("게임종료")
            Game.gameStop = true
        } else if (input != "1" && input != "2") {
            require(false)
        }
    }
}
