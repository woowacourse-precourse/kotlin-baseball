package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val WRONG_LENGTH_MESSAGE = "길이가 3이 아닙니다. 게임 종료"
const val OUT_OF_RANGE_MESSAGE = "범위를 벗어난 숫자입니다. 게임 종료"
const val EXIST_DUPLICATE_MESSAGE = "중복된 숫자가 존재합니다. 게임 종료"
const val GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val WARNING_RESTART_MESSAGE = "1과 2 중 선택해야합니다! 게임 종료"

const val BALL = "볼"
const val STRIKE = "스트라이크"
const val NOTHING = "낫싱"

fun main() {
    var isStart: Boolean = true
    var isPlay: Boolean = true
    var computer: List<Int> = listOf()
    var player: List<Int>

    println(GAME_START_MESSAGE)
    while (isStart or isPlay) {
        if (isStart) {
            computer = getComputerNumbers()
        }
        player = getPlayerNumbers()
        isPlay = checkStrike(computer, player)
        isStart = checkPlayAgain(isPlay)
    }
}

fun getComputerNumbers(): List<Int> {
    val computer: MutableList<Int> = mutableListOf()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun getPlayerNumbers(): List<Int> {
    print(INPUT_MESSAGE)
    val playerInput: String = Console.readLine()
    val playerNumbers: MutableList<Int> = mutableListOf()

    checkPlayerInput(playerInput)
    for (num in playerInput) {
        playerNumbers.add(num - '0')
    }

    return playerNumbers
}

fun checkPlayerInput(str: String) {
    if (str.length != 3) {
        throw IllegalArgumentException(WRONG_LENGTH_MESSAGE)
    }
    for (x in str) {
        if (x !in '0'..'9') {
            throw IllegalArgumentException(OUT_OF_RANGE_MESSAGE)
        }
        if (str.count { it == x } != 1) {
            throw IllegalArgumentException(EXIST_DUPLICATE_MESSAGE)
        }
    }
}

fun checkStrike(computerNumbers: List<Int>, playerNumbers: List<Int>): Boolean {
    var ball: Int = 0
    var strike: Int = 0

    for (i in playerNumbers.indices) {
        if (playerNumbers[i] !in computerNumbers) {
            continue
        }
        if (playerNumbers[i] == computerNumbers[i]) {
            strike++
        } else {
            ball++
        }
    }
    println(getResultString(ball, strike))

    if (strike == 3) {
        return false
    }
    return true
}

fun getResultString(ball: Int, strike: Int): String {
    var str: String = ""

    if (ball > 0) {
        str = when (strike) {
            0 -> "$ball$BALL"
            else -> "$ball$BALL $strike$STRIKE"
        }
    }
    if (ball == 0) {
        str = when (strike) {
            0 -> NOTHING
            3 -> "3$STRIKE\n$GAME_OVER_MESSAGE"
            else -> "$strike$STRIKE"
        }
    }
    return str
}

fun checkPlayAgain(isOnGame: Boolean): Boolean {
    val input: String

    if (!isOnGame) {
        println(RESTART_GAME_MESSAGE)
        input = Console.readLine()
        return when (input) {
            "1" -> true
            "2" -> false
            else -> throw IllegalArgumentException(WARNING_RESTART_MESSAGE)
        }
    }

    return false
}