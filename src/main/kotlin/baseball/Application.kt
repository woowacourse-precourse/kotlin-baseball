package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
import java.util.regex.Pattern

const val INPUT_LENGTH_STANDARD = 3
const val GAME_CLEAR = 3
const val USER_WANT_PLAY_AGAIN = 1
const val USER_DONT_WANT_PLAY_AGAIN = 2
const val MIN_NUMBER = 1
const val MAX_NUMBER = 9

fun main() {
    startGameAtFirst()

}

private fun startGameAtFirst() {
    println("숫자 야구 게임을 시작합니다.")
    val answerList = getRandomNumberList()
    checkBallAndStrike(getUserInput(), answerList)
}

private fun getRandomNumberList(): List<Int> {
    val randomList = mutableListOf<Int>()
    while (randomList.size < INPUT_LENGTH_STANDARD) {
        val newRandomNum = getEachRandomNumber()
        if (!checkNumberIsContained("Rand", newRandomNum, randomList)) {
            randomList.add(newRandomNum)
        }
    }
    return randomList
}

private fun getEachRandomNumber(): Int {
    return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
}

private fun checkNumberIsContained(type: String, number: Int?, numberList: List<Int>): Boolean {
    var mReturn = false
    if (type == "User") {
        mReturn = numberList.distinct().size == numberList.size //Set 사용 검토!
    }
    if (type == "Rand") {
        mReturn = numberList.contains(number)
    }
    return mReturn
}

private fun getUserInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    return checkInputRegex(input)
}

private fun checkInputRegex(input: String): List<Int> {
    val inputToList = input.split("").filter { it != "" }

    if (!checkInputIsNumber(input)) {
        throw IllegalArgumentException()
    }
    if (input.length != INPUT_LENGTH_STANDARD) {
        throw IllegalArgumentException()
    }
    if (!checkNumberIsContained("User", null, convertStringListToIntList(inputToList))) {
        print("contain")
        throw IllegalArgumentException()
    }
    return convertStringListToIntList(inputToList)
}

private fun checkInputIsNumber(number: String): Boolean {
    return Pattern.matches("^[1-9]*$", number)
}

private fun convertStringListToIntList(targetList: List<String>): List<Int> {
    return targetList.map { it.toInt() }
}

private fun checkBallAndStrike(userInputList: List<Int>, answerList: List<Int>): Boolean {
    var strikeCount = 0
    var ballCount = 0

    for (userInputPosition in userInputList.indices) {
        ballCount += checkBallCount(userInputList[userInputPosition], userInputPosition, answerList)
    }
    return strikeCount == GAME_CLEAR
}

private fun checkBallCount(userInputEach: Int, userInputPosition: Int, answerList: List<Int>): Int {
    for (answerPosition in answerList.indices) {
        if (answerList[answerPosition] == userInputEach && userInputPosition != answerPosition) {
            return 1
        }
    }
    return 0
}