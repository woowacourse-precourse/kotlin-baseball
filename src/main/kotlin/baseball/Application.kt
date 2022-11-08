package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    startBaseBallGame()

    var gameOverDecision = 0
    while (gameOverDecision != 2) {
        val computerRandomNumber = computerSelectThreeRandomNumber()
        gameOverDecision = progressBaseBallGame(computerRandomNumber)
    }
}


fun progressBaseBallGame(computerRandomNumber: List<Int>): Int {
    while (true) {
        val userNumber = userThreeNumberInput()
        if (determineJudgement(computerRandomNumber, userNumber) == 3) return userDecideGameContinue()
    }
}


private fun startBaseBallGame() {
    println("숫자 야구 게임을 시작합니다.")
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
    val userInput = Console.readLine()
    if (userNumberInputExceptionCheck(userInput)) {
        throw IllegalArgumentException()
    }

    return userInput!!.toList().map { it.digitToInt() }
}


private fun userNumberInputExceptionCheck(inputString: String?): Boolean {
    if (inputString.isNullOrBlank()) {
        return true
    }

    if (inputString.length != 3) {
        return true
    }

    val digitDuplicatedCheckList =
        mutableListOf<Boolean>(false, false, false, false, false, false, false, false, false, false)
    for (code in inputString.toList().map { it.code }) {
        if (!isValidUserNumber(code)) return true
        if (digitDuplicatedCheckList[code - 48]) return true
        digitDuplicatedCheckList[code - 48] = true
    }

    return false
}

private fun isValidUserNumber(code: Int): Boolean {
    if (code < 49 || code > 57) {
        return false
    }
    return true
}


private fun determineJudgement(computerNumberList: List<Int>, userNumberList: List<Int>): Int {
    return printGameResult(increaseStrikeBallCount(computerNumberList, userNumberList))
}


private fun increaseStrikeBallCount(computerNumberList: List<Int>, userNumberList: List<Int>): Pair<Int, Int> {
    var strikeCount = 0
    var ballCount = 0

    for (i in 0..2) {
        if (computerNumberList[i] == userNumberList[i]) strikeCount += 1
        else if (userNumberList.contains(computerNumberList[i])) ballCount += 1
    }

    return Pair(strikeCount, ballCount)
}

private fun printGameResult(strikeBallCountPair: Pair<Int, Int>): Int {
    when {
        strikeBallCountPair.first == 0 && strikeBallCountPair.second == 0 -> println("낫싱")
        strikeBallCountPair.first == 3 -> println("${strikeBallCountPair.first}스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        strikeBallCountPair.second > 0 && strikeBallCountPair.first > 0 -> println("${strikeBallCountPair.second}볼 ${strikeBallCountPair.first}스트라이크")
        strikeBallCountPair.second > 0 && strikeBallCountPair.first == 0 -> println("${strikeBallCountPair.second}볼")
        strikeBallCountPair.second == 0 && strikeBallCountPair.first > 0 -> println("${strikeBallCountPair.first}스트라이크")
    }

    return strikeBallCountPair.first
}

private fun userDecideGameContinue(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val userInput = Console.readLine()
    if (userGameContinueDecisionInputExceptionCheck(userInput)) {
        throw IllegalArgumentException()
    }

    return userInput!!.toInt()
}


private fun userGameContinueDecisionInputExceptionCheck(inputString: String?): Boolean {
    if (inputString.isNullOrBlank()) {
        return true
    }

    if (inputString.toInt() != 1 && inputString.toInt() != 2) return true

    return false
}



