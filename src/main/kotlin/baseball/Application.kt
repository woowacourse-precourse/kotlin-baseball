package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException


fun main() {
    BaseballGame.initGame()
    BaseballGame.setOpponentNumber()
    while(true) {
        print("숫자를 입력해주세요 : ")
        val input = readLine()
        input?.let { exceptionTest(it) }

        BaseballGame.compareNumber(input!!)
        BaseballGame.printResult()
        BaseballGame.initResult()
    }
}

object BaseballGame {
    private var opponentNumber = mutableListOf<Int>()
    var ballStrike = mutableListOf(0, 0)

    fun initGame() {
        opponentNumber.clear()
    }

    fun setOpponentNumber() {
        while (opponentNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!opponentNumber.contains(randomNumber)) {
                opponentNumber.add(randomNumber)
            }
        }
    }

    fun compareNumber(input: String) {
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

    fun printResult() {
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

    fun initResult(){
        ballStrike[0]=0
        ballStrike[1]=0
    }
}

fun exceptionTest(input: String) {
    val regex = "[1-9][1-9][1-9]".toRegex()
    require(input.matches(regex)) {
        throw IllegalArgumentException()
    }

    require(input[0] != input[1] && input[0] != input[2] && input[1] != input[2]) {
        throw IllegalArgumentException()
    }
}
