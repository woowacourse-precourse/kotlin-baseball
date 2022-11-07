package baseball

import camp.nextstep.edu.missionutils.Randoms

const val NUM_LENGTH = 3
const val ASCII_CODE_ONE = 49
const val ASCII_CODE_NINE = 57
const val RESTART_FLAG = 1
const val EXIT_FLAG =2

var flag = 0
fun main() {
    printGameStart()
    startGame()
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
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
        answer = printHint(hint)
    }
}

fun generateComputerNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < NUM_LENGTH) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun getUserNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
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
        throw IllegalArgumentException("3개의 숫자를 입력하세요")
    }

    userInput.forEach { c ->
        if (c.code < ASCII_CODE_ONE || c.code > ASCII_CODE_NINE) {
            throw IllegalArgumentException("1부터 9까지의 숫자만 입력하세요")
        }
    }

    if (userInput.distinct() != userInput) {
        throw java.lang.IllegalArgumentException("서로 다른 수를 입력하세요")
    }
}

fun getHint(computerNumber: List<Int>, userNumber: List<Int>): List<Int> {
    val hint = mutableListOf<Int>(0, 0)
    for (i in userNumber.indices) {
        if (countStrike(computerNumber[i], userNumber[i])) {
            hint[0]++
        } else {
            hint[1] += countBall(computerNumber, userNumber[i])
        }
    }
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

fun printHint(hint: List<Int>): Boolean {
    var answer = false
    when {
        hint[0] == 0 && hint[1] == 0 -> println("낫싱")
        hint[0] == 3 -> {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            answer = true
            restartOrEndGame()
        }

        hint[0] == 0 -> println("${hint[1]}볼")
        hint[1] == 0 -> println("${hint[0]}스트라이크")
        else -> println("${hint[1]}볼 ${hint[0]}스트라이크")
    }
    return answer
}

fun restartOrEndGame() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val flagInput = readLine()
    checkFlagException(flagInput)
    flag = flagInput?.toInt() ?: 0
}

fun checkFlagException(flagInput: String?) {
    if (flagInput != "$RESTART_FLAG" && flagInput != "$EXIT_FLAG")
        throw IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}