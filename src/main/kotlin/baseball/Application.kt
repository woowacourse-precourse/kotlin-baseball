package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = randomNumber()
    val userNumber = getUserInput()
    TODO("프로그램 구현")
}

fun continueGame(): Boolean {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = Console.readLine().toInt()
    if (input == 1) {
        return true
    }
    if (input == 2) {
        return false
    }
    throw IllegalArgumentException()
}

fun determineResult(computerNumber: MutableList<Int>, userNumber: MutableList<Int>): String {
    val total = countTotal(computerNumber, userNumber)
    val strike = countStrike(computerNumber, userNumber)
    val ball = total - strike

    if (total == 0) {
        return "낫싱"
    }
    if (strike == 0) {
        return "${ball}볼"
    }
    if (ball == 0) {
        return "${strike}스트라이크"
    }
    return "${ball}볼 ${strike}스트라이크"
}

fun countStrike(computerNumber: MutableList<Int>, userNumber: MutableList<Int>): Int {
    var count = 0
    for (idx in 0 until computerNumber.size) {
        if (computerNumber[idx] == userNumber[idx]) {
            count++
        }
    }
    return count
}

fun countTotal(computerNumber: MutableList<Int>, userNumber: MutableList<Int>): Int {
    var count = 0
    for (idx in 0 until computerNumber.size) {
        if (computerNumber.contains(userNumber[idx])) {
            count++
        }
    }
    return count
}

fun randomNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val number = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(number)) {
            computerNumber.add(number)
        }
    }
    return computerNumber
}

fun getUserInput(): MutableList<Int> {
    val userNumber = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()

    exceptionHandling(input)
    input.forEach {
        userNumber.add(it - '0')
    }
    return userNumber
}

fun exceptionHandling(input: String) {
    if (input.length != 3 || checkSameNumber(input)) {
        throw IllegalArgumentException()
    }
    try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}
fun checkSameNumber(input: String): Boolean {
    val userNumber = mutableListOf<Int>()
    userNumber.add(input[0] - '0')
    var idx = 1
    while (userNumber.size < 3) {
        if (userNumber.contains(input[idx] - '0')) {
            return true
        }
        if (!userNumber.contains(input[idx] - '0')) {
            userNumber.add(input[idx] - '0')
            idx++
        }
    }
    return false
}