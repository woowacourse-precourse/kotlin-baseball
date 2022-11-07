package baseball

import camp.nextstep.edu.missionutils.Randoms

const val NUM_LENGTH = 3
const val MIN_NUM = 1
const val MAX_NUM = 9
const val ASCII_CODE_ONE = 49
const val ASCII_CODE_NINE = 57
const val RESTART_FLAG = 1
const val EXIT_FLAG =2

const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

const val INPUT_ERROR_LENGTH = "3개의 숫자를 입력하세요"
const val INPUT_ERROR_RANGE = "1부터 9까지의 숫자만 입력하세요"
const val INPUT_ERROR_DUPLICATE ="서로 다른 수를 입력하세요"

const val NOTHING ="낫싱"
const val STRIKE = "스트라이크"
const val BALL = "볼"


var flag = 0
fun main() {
    printGameStart()
    startGame()
}

fun printGameStart() {
    println(START_MESSAGE)
}

fun startGame() {
    do {
        val computerNumber = generateComputerNumber()
        playGame(computerNumber)
    } while (flag != EXIT_FLAG)
}

fun playGame(computerNumber: List<Int>) {
    var answer = false

    while (!answer) {
        val userNumber = getUserNumber()
        val hint = getHint(computerNumber, userNumber)
        printHint(hint)
        answer = checkAnswer(hint)
    }
}

fun generateComputerNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()

    while (computerNumber.size < NUM_LENGTH) {
        val randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }

    return computerNumber
}

fun getUserNumber(): List<Int> {
    print(INPUT_MESSAGE)
    val userInput = readLine()?.toList()

    checkUserNumberException(userInput)

    val userNumber = mutableListOf<Int>()
    userInput?.forEach { c ->
        userNumber.add(Character.getNumericValue(c))
    }

    return userNumber
}

fun checkUserNumberException(userInput: List<Char>?) {
    if (userInput?.size != NUM_LENGTH) {
        throw IllegalArgumentException(INPUT_ERROR_LENGTH)
    }

    userInput.forEach { c ->
        if (c.code < ASCII_CODE_ONE || c.code > ASCII_CODE_NINE) {
            throw IllegalArgumentException(INPUT_ERROR_RANGE)
        }
    }

    if (userInput.distinct() != userInput) {
        throw java.lang.IllegalArgumentException(INPUT_ERROR_DUPLICATE)
    }
}

fun getHint(computerNumber: List<Int>, userNumber: List<Int>): List<Int> {
    var strike = 0
    var ball = 0
    val hint = mutableListOf<Int>(0, 0)

    for (i in userNumber.indices) {
        if (countStrike(computerNumber[i], userNumber[i])) {
            strike++
        } else {
            ball += countBall(computerNumber, userNumber[i])
        }
    }

    hint[0] = strike
    hint[1] = ball

    return hint
}

fun countStrike(computerNumber: Int, userNumber: Int): Boolean {
    if (computerNumber == userNumber) return true

    return false
}

fun countBall(computerNumber: List<Int>, userNumber: Int): Int {
    if (computerNumber.contains(userNumber)) return 1

    return 0
}

fun printHint(hint: List<Int>) {
    val strike = hint[0]
    val ball = hint[1]

    when {
        strike == 0 && ball == 0 -> println(NOTHING)
        strike == 3 -> println("$strike$STRIKE")
        strike == 0 -> println("$ball$BALL")
        ball == 0 -> println("$strike$STRIKE")
        else -> println("$ball$BALL $strike$STRIKE")
    }
}

fun checkAnswer(hint: List<Int>): Boolean {
    val strike = hint[0]

    var answer = false
    if (strike == 3) {
        println(SUCCESS_MESSAGE)
        answer = true
        restartOrEndGame()
    }

    return answer
}

fun restartOrEndGame() {
    println(RESTART_MESSAGE)
    val flagInput = readLine()

    checkFlagException(flagInput)

    flag = flagInput?.toInt() ?: 0
}

fun checkFlagException(flagInput: String?) {
    if (flagInput != "$RESTART_FLAG" && flagInput != "$EXIT_FLAG")
        throw IllegalArgumentException(RESTART_MESSAGE)
}