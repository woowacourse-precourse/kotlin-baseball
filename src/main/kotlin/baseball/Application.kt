package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    printPlayBallText()
    playBall()
}

fun playBall() {
    val computerNumber = setComputerNumber()
    println(computerNumber)
    while (true) {
        printInputUserNumber()
        val userNumber = inputUserNumber()
        inputExceptionCheck(userNumber)
        val end = compareGameValues(computerNumber, userNumber)
        if (end) break
    }
    printEndGameText()
    try {
        val input = inputUserNumber().toInt()
        restartCheck(input)
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }

}

fun restartCheck(input: Int) {
    if (input == 1) {
        playBall()
    } else if (input != 2) {
        throw IllegalArgumentException()
    }
}

fun compareGameValues(computerNumber: List<Int>, input: String): Boolean {
    val userNumber = userNumberToList(input)
    val strike = strikeCount(computerNumber, userNumber)
    val ball = ballCount(computerNumber, userNumber)
    printCompareResult(strike, ball)
    if (strike == 3) return true
    return false
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

fun userNumberRangeException(numberList: List<Int>): Boolean {
    if (numberList.isEmpty() || numberList.contains(0)) return true
    return false
}

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

fun printEndGameText() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}