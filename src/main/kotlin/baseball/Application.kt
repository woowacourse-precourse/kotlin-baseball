package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

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
    val intArray = mutableListOf<Int>()
    checkThrowException(input)

    for (element in input) {
        intArray.add(element.toString().toInt())
    }
    return intArray
}

private fun checkThrowException(input: String) {
    throwIsNumberException(input)
    throwNumberLengthException(input)
    throwNumberDuplicationException(input)
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
    if (input[0] == input[1] || input[0] == input[2] || input[1] == input[2]) throw IllegalArgumentException()
}

fun calcScore(user: List<Int>, computer: List<Int>): Boolean {
    var ball = 0
    var strike = 0

    for (i in user.indices) {
        if (computer.contains(user[i]) && user[i] == computer[i]) strike++
        if (computer.contains(user[i]) && user[i] != computer[i]) ball++
    }
    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    return false
}
