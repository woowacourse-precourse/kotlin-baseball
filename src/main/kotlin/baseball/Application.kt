package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

var randomGeneratedNumber: String = ""
var curGameResultType: GameResultType = GameResultType.NothingResult
fun main() {
    printGameStartPhrase()
    startBaseballGame()
}

fun startBaseballGame() {
    generateRandomNumber()
    processBaseBallGame()
}

fun processBaseBallGame() {
    while (curGameResultType != GameResultType.CorrectResult) {
        printGuidelinePhraseAndWaitForInput()
    }
}

fun generateRandomNumber() {
    val randomNumbersSet = mutableSetOf<Int>()

    while (randomNumbersSet.size != 3) {
        randomNumbersSet.add(
            Randoms.pickNumberInRange(1, 9)
        )
    }
    randomGeneratedNumber = randomNumbersSet.joinToString("")
}

fun printGuidelinePhraseAndWaitForInput() {
    print("숫자를 입력해주세요 : ")
    val userInput = readln().trim()
    try {
        if (
            userInput.isNotException(ExceptionType.GameException) &&
            userInput.isNotDuplicated()
        ) {
            printGameResult(userInput.gameResult())
        } else {
            throw IllegalArgumentException()
        }
    } catch (ex: IllegalArgumentException) {
        printExceptionPhraseAndQuitProcess()
    }
}

fun printGameStartPhrase() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printExceptionPhraseAndQuitProcess() {
    println("예외가 발생되어 프로그램을 종료합니다.")
    exitProcess(0)
}

fun String.isNotDuplicated(): Boolean {
    val setOfUserInput = mutableSetOf<Int>()
    this.map { it.digitToInt() }.forEach {
        setOfUserInput.add(it)
    }
    return setOfUserInput.size == 3
}

fun String.isNotException(
    exceptionType: ExceptionType
): Boolean {
    return when (exceptionType) {
        is ExceptionType.GameException -> {
            if (this.isEmpty() || this.length > 3) {
                false
            } else this.all { Character.isDigit(it) } && this.length == 3
        }

        is ExceptionType.RetryException -> {
            if (this.isEmpty() || this.length > 1) {
                false
            } else this.all { Character.isDigit(it) } && this.length == 1 && (this == "1" || this == "2")
        }
    }
}

fun String.gameResult(): GameResultType {
    // 유저
    return if (this == randomGeneratedNumber) GameResultType.CorrectResult
    else if (
        !this.contains(randomGeneratedNumber[0]) &&
        !this.contains(randomGeneratedNumber[1]) &&
        !this.contains(randomGeneratedNumber[2])
    ) GameResultType.NothingResult
    else GameResultType.NormalResult(
        countBallAndStrike(this, randomGeneratedNumber).first,
        countBallAndStrike(this, randomGeneratedNumber).second
    )
}

fun printGameResult(
    resultType: GameResultType
) {
    when (resultType) {
        is GameResultType.NormalResult -> printNormalResult(resultType.ball, resultType.strike)
        is GameResultType.NothingResult -> printNothingResult()
        is GameResultType.CorrectResult -> {
            printCorrectResult()
            askRetry()
        }
    }
}

fun askRetry() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val userInput = readln().trim()
    try {
        if (userInput.isNotException(ExceptionType.RetryException)) {
            when (userInput) {
                "1" -> startBaseballGame()
                "2" -> {
                    println("게임을 종료합니다.")
                    exitProcess(0)
                }
            }
        } else {
            throw IllegalArgumentException()
        }
    } catch (ex: IllegalArgumentException) {
        printExceptionPhraseAndQuitProcess()
    }
}

fun printNormalResult(
    ballNumber: Int,
    strikeNumber: Int
) {
    if (ballNumber != 0 && strikeNumber != 0) {
        println("${ballNumber}볼 ${strikeNumber}스트라이크")
    } else {
        if (ballNumber == 0) {
            println("${strikeNumber}스트라이크")
        } else if (strikeNumber == 0) {
            println("${ballNumber}볼")
        }
    }
}

fun printNothingResult() {
    println("낫싱")
}

fun printCorrectResult() {
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun countBallAndStrike(userInput: String, answer: String): Pair<Int, Int> {
    var ballCount = 0
    var strikeCount = 0

    userInput.forEachIndexed { index, userNum ->
        if (userNum != answer[index] &&
            answer.contains(userNum)
        ) ballCount++
    }

    for (idx in 0 until 3) {
        if (userInput[idx] == answer[idx]) strikeCount++
    }

    return Pair(ballCount, strikeCount)
}

sealed class GameResultType {
    data class NormalResult(
        val ball: Int,
        val strike: Int
    ) : GameResultType()

    object NothingResult : GameResultType()

    object CorrectResult : GameResultType()
}

sealed class ExceptionType {
    object GameException : ExceptionType()
    object RetryException : ExceptionType()
}