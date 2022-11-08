package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    printPlayBallText()
    playBall()
}

fun playBall() {
    val computerNumber = setComputerNumber()
    while (true) {
        printInputUserNumber()
        val userNumber = inputUserNumber()
        inputExceptionCheck(userNumber)

    }
}

fun strikeCount(computer: List<Int>, user: List<Int>): Int = computer.filterIndexed { idx, value ->
    value == user[idx]
}.size

fun ballCount(computer: List<Int>, user: List<Int>): Int = computer.filterIndexed { idx, value ->
    user.contains(value) && value != user[idx]
}.size

fun userNumberToList(number: String): List<Int> = number.map {
    it.digitToInt()
}

fun inputUserNumber(): String = Console.readLine()


fun inputExceptionCheck(userNumber: String) {
    val numberList = userNumberToList(userNumber)
    val sizeException = userNumberSizeCheck(numberList)
    val overLapException = userNumberOverlapCheck(numberList)
    val rangeException = userNumberRangeException(numberList)

    if (sizeException || overLapException || rangeException) {
        throw IllegalArgumentException()
    }
}

fun userNumberSizeCheck(number: List<Int>): Boolean = number.size != 3

fun userNumberOverlapCheck(number: List<Int>): Boolean = number.size != number.toSet().size

fun setComputerNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun printPlayBallText() = println("숫자 야구 게임을 시작합니다.")

fun printInputUserNumber() = print("숫자를 입력해 주세요 : ")


fun printCompareResult(strike: Int, ball: Int) {
    when {
        strike == 0 && ball == 0 -> {
            println("낫싱")
        }
        strike > 0 && ball == 0 -> {
            println("${strike}스트라이크")
        }
        strike == 0 && ball > 0 -> {
            println("${ball}볼")
        }
        strike > 0 && ball > 0 -> {
            println("${ball}볼 ${strike}스트라이크")
        }
    }
}