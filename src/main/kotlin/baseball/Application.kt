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
    println("숫자 야구 게임을 시작합니다.")
    startGame()

}

private fun startGame() {
    val answerList = RandomInput().getRandomNumberList()
    while(true) {
        if(checkBallAndStrike(getUserInput(), answerList)) {
            checkWantPlayAgain()
            break
        }
    }
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
    if (!Regex().checkNumberIsContained("User", null, convertStringListToIntList(inputToList))) {
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
        strikeCount += checkStrikeCount(userInputList[userInputPosition], userInputPosition, answerList)
    }
    printResult(strikeCount, ballCount)
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

private fun checkStrikeCount(userInputEach: Int, userInputPosition: Int, answerList: List<Int>): Int {
    for (answerPosition in answerList.indices) {
        if (answerList[answerPosition] == userInputEach && userInputPosition == answerPosition) {
            return 1
        }
    }
    return 0
}

private fun printResult(strikeCount: Int, ballCount: Int) {
    if (strikeCount == 0 && ballCount == 0) {
        println("낫싱")
    }
    if (strikeCount == GAME_CLEAR) {
        println("${strikeCount}스트라이크")
        print("${strikeCount}개의 숫자를 모두 맞히셨습니다! ")
        println("게임 종료")
    }
    if (strikeCount in 1 until INPUT_LENGTH_STANDARD && ballCount in 1 until INPUT_LENGTH_STANDARD) {
        println("${ballCount}볼 ${strikeCount}스트라이크")
    }
    if (strikeCount in 1 until INPUT_LENGTH_STANDARD && ballCount == 0) {
        println("${strikeCount}스트라이크")
    }
    if (strikeCount == 0 && ballCount in 1..INPUT_LENGTH_STANDARD) {
        println("${ballCount}볼")
    }
}

private fun checkWantPlayAgain() {
    var userInput: String
    while (true) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        userInput = Console.readLine()
        if (!checkInputIsNumber(userInput)) {
            println("잘못된 값이 입력되었습니다. 다시 입력해주세요.")
            return
        }
        if (userInput.toInt() in USER_WANT_PLAY_AGAIN..USER_DONT_WANT_PLAY_AGAIN) {
            break
        }
        println("잘못된 값이 입력되었습니다. 다시 입력해주세요.")
    }
    if (userInput.toInt() == USER_WANT_PLAY_AGAIN) {
        startGame()
    }
}