package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartGame()
}

fun printStartGame() {
    println("숫자 야구 게임을 시작합니다.")
}

fun generateComputerNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun printEnterNumber() {
    print("숫자를 입력해주세요 : ")
}

fun throwThreeLetterException(input: List<Char>) {
    val numberOfDigits = 3
    if (input.size != numberOfDigits) {
        throw IllegalArgumentException("3개의 숫자를 입력하세요")
    }
}

fun throwNonNumberException(input: List<Char>) {
    val asciiCodeZero = 48
    val asciiCodeNine = 57
    input.forEach { char ->
        if (char.code < asciiCodeZero || char.code > asciiCodeNine) {
            throw IllegalArgumentException("숫자만 입력하세요")
        }
    }
}

fun throwDuplicateNumberException(input: List<Char>) {
    if (input.distinct() != input) {
        throw IllegalArgumentException("서로 다른수를 입력해주세요")
    }
}

fun checkAllException(input: List<Char>) {
    throwThreeLetterException(input)
    throwNonNumberException(input)
    throwDuplicateNumberException(input)
}

fun getInputListFromKeyboard() = Console.readLine().toList()

fun convertCharacterListToIntList(input: List<Char>): List<Int> {
    return input.map { char ->
        char.digitToInt()
    }
}

fun countBall(userNumber: List<Int>, computerNumber: List<Int>): Int {
    var ball = 0
    userNumber.forEach { num ->
        if (computerNumber.contains(num)) ball++
    }
    return ball
}

fun countStrike(userNumber: List<Int>, computerNumber: List<Int>): Int {
    var strike = 0
    for (index in userNumber.indices) {
        if (userNumber[index] == computerNumber[index]) strike++
    }
    return strike
}

fun getFinalNumberOfBallBySubtractStrikeFromBall(ball: Int, strike: Int) = ball - strike

fun isThreeStrike(strike: Int): Boolean {
    return strike == 3
}

fun printThreeStrike() {
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun printNothing(ball: Int, strike: Int) {
    if (ball == 0 && strike == 0) print("낫싱")
}

fun printBall(ball: Int) {
    if (ball != 0) print("${ball}볼 ")
}

fun printStrike(strike: Int) {
    if (strike != 0) print("${strike}스트라이크")
}

fun getRestartNumberFromKeyboard() = Console.readLine()

fun throwInvalidRestartNumber(input: String) {
    if (!(input == "1" || input == "2")) {
        throw java.lang.IllegalArgumentException("1,2 중 하나를 입력해주세요")
    }
}