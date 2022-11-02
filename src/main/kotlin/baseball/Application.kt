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


    } while (getStrikeCount() == 3)
}

fun isValidNumber(n: String): Boolean = numberRegex.matches(n)

fun getStrikeCount(): Int {
    // TODO: 게임 종료 기능 구현
    return 3
}

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