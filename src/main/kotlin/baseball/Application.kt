package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private val numberRegex = "[1-9]{3}".toRegex()
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val answer = getRandomNumber()

    do {
        println("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        if (isValidNumber(input).not()) {
            throw IllegalStateException()
        }

    } while (getStrikeCount(answer, input) < 3)
}

fun isValidNumber(n: String): Boolean = numberRegex.matches(n)

fun getRandomNumber(): String {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
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
    for (i in 0 until 3) {
        if (input[i] == answer[i]) {
            count += 1
        }
    }

    return count
}