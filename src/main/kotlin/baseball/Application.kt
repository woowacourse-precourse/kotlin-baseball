package baseball

import camp.nextstep.edu.missionutils.*
import java.util.*

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startNewGame()
}

private fun getComputerNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

private fun startNewGame() {
    val computerNumber = getComputerNumber()
    do {
        val inputString = getUserPredictionNumber()
        validateInputString(inputString, false)
    } while (isUserAnswerWrong(computerNumber, inputString))
}

private fun getUserPredictionNumber(): String {
    print("숫자를 입력해주세요 : ")
    val inputString = Console.readLine()
    println(inputString)

    return inputString
}

private fun validateInputString(inputString: String, isNewGameCheckInputString: Boolean) {
    if (isNewGameCheckInputString && isContinuedNewGameCheckInputError(inputString))
        throw IllegalArgumentException("User New Game Continue Check Input Error")

    if (!isNewGameCheckInputString && isPredictionInputError(inputString))
        throw IllegalArgumentException("User Prediction Input Error")
}

private fun isContinuedNewGameCheckInputError(inputString: String): Boolean {
    if (isNotInteger(inputString))
        return true

    if (inputString == "1" || inputString == "2")
        return false

    return true
}

private fun isPredictionInputError(inputString: String): Boolean {
    if (isNotInteger(inputString))
        return true
    if (containsZeroDigit(inputString))
        return true
    if (inputString.length != 3)
        return true

    val numberCheckList: MutableList<Boolean> = ArrayList(Collections.nCopies(10, false))
    for (currentDigit in inputString) {
        if (numberCheckList[currentDigit.code - '0'.code])
            return true

        numberCheckList[currentDigit.code - '0'.code] = true
    }
    return false
}

private fun isNotInteger(string: String): Boolean {
    return try {
        string.toInt()
        false
    } catch (e: NumberFormatException) {
        true
    }
}

private fun containsZeroDigit(string: String): Boolean = string.contains("0")
private fun isUserAnswerWrong(computerNumber: String, inputNumber: String): Boolean {
    var ballCount = 0
    var strikeCount = 0

    for (inputNum in inputNumber) {
        if (computerNumber.contains(inputNum))
            ballCount++
    }

    for (i in 0 until 3) {
        if (computerNumber[i] == inputNumber[i]) {
            ballCount--
            strikeCount++
        }
    }

    return isWrongNumber(ballCount, strikeCount)
}

private fun isWrongNumber(ballCount: Int, strikeCount: Int): Boolean {
    if (strikeCount == 3) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return false
    }
    if (ballCount == 0 && strikeCount == 0) {
        println("낫싱")
        return true
    }

    if (ballCount == 0)
        println("${strikeCount}스트라이크")
    if (strikeCount == 0)
        println("${ballCount}볼")
    if (ballCount != 0 && strikeCount != 0)
        println("${ballCount}볼 ${strikeCount}스트라이크")
    return true
}