package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    startBaseBallGame()

}


private fun startBaseBallGame() {
    println("숫자 야구 게임을 시작합니다.")
    val computerRandomNumber = computerSelectThreeRandomNumber()
    println(computerRandomNumber)
    val userNumber = userThreeNumberInput()
    println(userNumber)
}


private fun computerSelectThreeRandomNumber(): List<Int> {
    val computerList = mutableListOf<Int>()
    while (computerList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerList.contains(randomNumber)) computerList.add(randomNumber)
    }
    return computerList
}


private fun userThreeNumberInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val userInput = readLine()
    if (userInputExceptionCheck(userInput)) {
        throw IllegalArgumentException()
    }

    return userInput!!.toList().map { it.digitToInt() }
}



private fun userInputExceptionCheck(inputString: String?): Boolean {
    if (inputString == null || inputString == "") {
        return true
    }

    for (code in inputString.toList().map { it.code }) {
        if (!isValidInputNumber(code)) return true
    }

    return false
}

private fun isValidInputNumber(code: Int): Boolean {
    if (code < 48 || code > 57) {
        return false
    }
    return true
}