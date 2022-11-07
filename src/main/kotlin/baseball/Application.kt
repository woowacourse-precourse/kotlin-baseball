package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    do {
        BaseballGame.playGame()
    } while (restartGame())
}


object BaseballGame {
    private var opponentNumber = mutableListOf<Int>()
    private var ballStrike = mutableListOf(0, 0)

    fun playGame() {
        initGame()
        setOpponentNumber()
        while (true) {
            print("숫자를 입력해주세요 : ")
            val input = readLine()
            inputException(input)
            compareNumber(input!!)
            printResult()

            if (ballStrike[1] == 3) {
                initResult()
                break
            }

            initResult()
        }
    }

    private fun initGame() {
        opponentNumber.clear()
    }

    private fun setOpponentNumber() {
        while (opponentNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!opponentNumber.contains(randomNumber)) {
                opponentNumber.add(randomNumber)
            }
        }
    }

    private fun compareNumber(input: String) {
        for (number in opponentNumber) {
            if (input.contains(number.toString())) {
                val digit = opponentNumber.indexOf(number)
                matchDigit(digit, input)
            }
        }
    }

    private fun matchDigit(digit: Int, input: String) {
        val digitNumber = (opponentNumber[digit] + 48).toChar()
        when (input[digit] == digitNumber) {
            true -> ballStrike[1]++
            false -> ballStrike[0]++
        }
    }

    private fun printResult() {
        if (ballStrike[0] > 0) {
            print("${ballStrike[0]}볼 ")
        }
        if (ballStrike[1] > 0) {
            print("${ballStrike[1]}스트라이크 ")
        }
        if (ballStrike[0] == 0 && ballStrike[1] == 0) {
            print("낫싱")
        }
        println()
    }

    private fun initResult() {
        ballStrike[0] = 0
        ballStrike[1] = 0
    }

}

fun inputException(input: String?) {
    require(!input.isNullOrEmpty()) {
        throw IllegalArgumentException()
    }

    val regex = "[1-9][1-9][1-9]".toRegex()
    require(input.matches(regex)) {
        throw IllegalArgumentException()
    }

    require(input[0] != input[1] && input[0] != input[2] && input[1] != input[2]) {
        throw IllegalArgumentException()
    }
}

fun restartException(answer: String?) {
    require(answer == "1" || answer == "2") {
        throw IllegalArgumentException()
    }
}

fun restartGame(): Boolean {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val answer = readLine()
    restartException(answer)
    when (answer) {
        "1" -> return true
        "2" -> return false
    }
    return true
}
