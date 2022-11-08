package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

fun main() {
    TODO("프로그램 구현")
}

private fun checkValidInput(userInput: String): String {
    if (!checkValidLength(userInput)) {
        print("게임 종료")
        throw IllegalArgumentException("입력 길이가 유효하지 않습니다.")
    } else if (!checkDuplicatedNumbers(userInput)) {
        print("게임 종료")
        throw IllegalArgumentException("중복된 숫자가 존재합니다.")
    } else {
        return userInput
    }
}

private fun checkValidLength(userInput: String) = (userInput.length == 3)

private fun checkDuplicatedNumbers(userInput: String) = (userInput.length == userInput.toSet().size)

private fun startNewGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        "1" -> {
            true
        }
        "2" -> {
            print("게임 종료")
            false
        }
        else -> {
            print("게임 종료")
            false
        }
    }
}

private fun setRandomNumber(): String {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

private fun getNumberOfStrike(computer: String, user: String): Int {
    val computerNumber: String = computer
    val userNumber: String = user
    var numberOfStrike = 0
    for (i in 0..2) {
        if (computerNumber[i] == userNumber[i]) {
            numberOfStrike++
        }
    }
    return numberOfStrike
}

private fun getNumberOfBall(computer: String, user: String): Int {
    val computerNumber: String = computer
    val userNumber: String = user
    var numberOfBall = 0
    for (i in 0..2) {
        if (computerNumber.contains(userNumber[i]) && computerNumber[i] != userNumber[i]) {
            numberOfBall++
        }
    }
    return numberOfBall
}

private fun printGameResult(computer: String, user: String) {
    val numberOfBall = getNumberOfBall(computer, user)
    val numberOfStrike = getNumberOfStrike(computer, user)
    when {
        numberOfBall != 0 && numberOfStrike !=0 -> {
            print("${numberOfBall}볼 ${numberOfStrike}스트라이크")
        }
        numberOfBall != 0 -> {
            print("${numberOfBall}볼")
        }
        numberOfStrike != 0 -> {
            print("${numberOfStrike}스트라이크")
        }
        else -> {
            print("낫싱")
        }
    }
}
