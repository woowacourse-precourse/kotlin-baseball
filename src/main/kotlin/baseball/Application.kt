package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private val numberRegex = "[1-9]{3}".toRegex()
private const val MAX_SIZE = 3

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        startGame()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        when (Console.readLine()) {
            "1" -> continue
            "2" -> break
            else -> throw IllegalArgumentException()
        }
    } while (true)
}

fun startGame() {
    val answer = getRandomNumber()

    do {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        if (isValidNumber(input).not()) {
            throw IllegalArgumentException()
        }

        val ballCount = getBallCount(answer, input)
        val strikeCount = getStrikeCount(answer, input)
        printCount(ballCount, strikeCount)
    } while (strikeCount < MAX_SIZE)

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun isValidNumber(n: String): Boolean =
    numberRegex.matches(n) && n.toSet().count() == MAX_SIZE

fun getRandomNumber(): String {
    val numbers = mutableListOf<Int>()
    while (numbers.size < MAX_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (numbers.contains(randomNumber).not()) {
            numbers.add(randomNumber)
        }
    }

    return numbers.joinToString("")
}

fun getBallCount(answer: String, input: String): Int =
    input.count { answer.contains(it) } - getStrikeCount(answer, input)

fun getStrikeCount(answer: String, input: String): Int {
    var count = 0
    for (i in 0 until MAX_SIZE) {
        if (input[i] == answer[i]) {
            count += 1
        }
    }

    return count
}

fun printCount(ballCount: Int, strikeCount: Int) {
    val result = if (ballCount > 0 && strikeCount > 0) {
        "${ballCount}볼 ${strikeCount}스트라이크"
    } else if (ballCount == 0 && strikeCount > 0) {
        "${strikeCount}스트라이크"
    } else if (ballCount > 0 && strikeCount == 0) {
        "${ballCount}볼"
    } else {
        "낫싱"
    }
    println(result)
}