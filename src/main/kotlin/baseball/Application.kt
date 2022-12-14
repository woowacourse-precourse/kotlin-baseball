package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val FIRST_NUMBER = 0
const val SECOND_NUMBER = 1
const val THIRD_NUMBER = 2
const val RESTART = 1
const val EXIT = 2
const val INPUT_LENGTH = 3

fun main() {
    printStartMessage()
    baseballGame()
}

fun printStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun baseballGame() {
    val computer = generateRandomNumber()

    while (true) {
        val user = userInput()
        if (calcScore(user, computer)) break
    }
    restartGame()
}

fun generateRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

private fun userInput(): List<Int> {
    println("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    checkThrowException(input)
    return convertStringToIntArray(input)
}

private fun checkThrowException(input: String) {
    throwIsNumberException(input)
    throwNumberLengthException(input)
    throwNumberDuplicationException(input)
}

private fun convertStringToIntArray(string: String): List<Int> {
    val intArray = mutableListOf<Int>()
    string.forEach { intArray.add(it.digitToInt()) }
    return intArray
}

fun throwIsNumberException(input: String) {
    val numbers = input.toCharArray().filter { char ->
        char in '1'..'9'
    }
    if (numbers.size != input.length) {
        throw java.lang.IllegalArgumentException()
    }
}

fun throwNumberLengthException(input: String) {
    if (input.length != INPUT_LENGTH) throw IllegalArgumentException()
}

fun throwNumberDuplicationException(input: String) {
    if (input[FIRST_NUMBER] == input[SECOND_NUMBER]
        || input[SECOND_NUMBER] == input[THIRD_NUMBER]
        || input[THIRD_NUMBER] == input[FIRST_NUMBER]
    ) {
        throw IllegalArgumentException()
    }
}

fun calcScore(user: List<Int>, computer: List<Int>): Boolean {
    var ball = 0
    var strike = 0

    for (i in user.indices) {
        if (computer.contains(user[i]) && user[i] == computer[i]) strike++
        if (computer.contains(user[i]) && user[i] != computer[i]) ball++
    }
    showResult(ball, strike)

    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    return false
}

fun showResult(ball: Int, strike: Int) {
    when {
        strike > 0 && ball > 0 -> println("${ball}볼 ${strike}스트라이크")
        strike > 0 && ball == 0 -> println("${strike}스트라이크")
        strike == 0 && ball > 0 -> println("${ball}볼")
        strike == 0 && ball == 0 -> println("낫싱")
    }
}

fun restartGame() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    when (Console.readLine().toInt()) {
        RESTART -> baseballGame()
        EXIT -> println("숫자 야구 게임을 종료합니다.")
        else -> throw IllegalArgumentException()
    }
}
