package baseball

import camp.nextstep.edu.missionutils.Randoms

var flag = 0
fun main() {
    printGameStart()
    startGame()
}

fun startGame() {
    do {
        val computerNumber = generateComputerNumber()
        playGame(computerNumber)
    } while (flag != 2)
}

fun playGame(computerNumber: List<Int>) {
    var answer = false
    while (!answer) {
        val userNumber = getUserNumber()
        val hint = getHint(computerNumber, userNumber)
        answer = printHint(hint)
    }
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun generateComputerNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
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
    if (userInput?.size != 3) {
        throw IllegalArgumentException("3개의 숫자를 입력하세요")
    }

    userInput.forEach { c ->
        if (c.code < 48 || c.code > 57) {
            throw IllegalArgumentException("숫자만 입력하세요")
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
    if (flagInput != "1" && flagInput != "2")
        throw IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}