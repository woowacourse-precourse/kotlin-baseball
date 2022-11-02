package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException


fun main() {
    BaseballGame.initGame()
    BaseballGame.setOpponentNumber()
    while(true) {
        print("숫자를 입력해주세요 : ")
        val input = readLine()
        input?.let { inputException(it) }

        BaseballGame.compareNumber(input!!)
        BaseballGame.printResult()

        if(BaseballGame.ballStrike[1]==3){
            break
        }

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

fun inputException(input: String) {
    val regex = "[1-9][1-9][1-9]".toRegex()
    require(input.matches(regex)) {
        throw IllegalArgumentException()
    }

    require(input[0] != input[1] && input[0] != input[2] && input[1] != input[2]) {
        throw IllegalArgumentException()
    }
}

fun restartException(answer : String){
    require(answer == "1"||answer=="2"){
        throw IllegalArgumentException()
    }
}

fun restartGame() : Boolean{
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val answer = readLine()
    answer?.let { restartException(it) }
    when(answer){
        "1" -> true
        "2" -> false
    }
    return true
}
