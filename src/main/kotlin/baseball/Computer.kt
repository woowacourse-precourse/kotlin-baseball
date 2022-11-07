package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object Computer {
    private const val INPUT_MAX_VALUE = 9
    private const val INPUT_MIN_VALUE = 1
    const val INPUT_MAX_SIZE = 3
    const val INPUT_GAME_RESTART = "1"
    const val INPUT_GAME_STOP = "2"
    var strike = 0
    var ball = 0
    val correctNumber = mutableListOf<Int>()
    fun getCorrectRandomNumber() {
        correctNumber.clear()
        while (correctNumber.size < INPUT_MAX_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(INPUT_MIN_VALUE, INPUT_MAX_VALUE)
            if (!correctNumber.contains(randomNumber)) {
                correctNumber.add(randomNumber)
            }
        }
    }

    fun compareInputWithCorrectNumber(inputValue: String) {
        for (inputIndex in 0 until correctNumber.size) {
            countScore(inputValue, inputIndex)
        }
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
                Game.gameOver()
            }
        } else if (strike > 0 && ball > 0) {
            println("${ball}볼 ${strike}스트라이크")
        }
    }

    fun resetScore() {
        strike = 0
        ball = 0
    }
}
