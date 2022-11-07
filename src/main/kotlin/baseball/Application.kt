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

    determineJudgement(computerRandomNumber, userNumber)
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


private fun determineJudgement(computerNumberList : List<Int>, userNumberList : List<Int>) {
    increaseStrikeBallCount(computerNumberList, userNumberList)
}


private fun increaseStrikeBallCount(computerNumberList : List<Int>, userNumberList : List<Int>): Pair<Int, Int> {
    var strikeCount = 0
    var ballCount = 0

    for (i in 0..2) {
        if (computerNumberList[i] == userNumberList[i]) strikeCount += 1
        else if (userNumberList.contains(computerNumberList[i])) ballCount += 1
    }

    return Pair(strikeCount, ballCount)
}


