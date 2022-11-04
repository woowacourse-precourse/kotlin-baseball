package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.StringBuilder

fun generateRandomNumber(): String {
    val randomNum = Randoms.pickUniqueNumbersInRange(1, 9, 3)
    return randomNum.toString()
}

fun getUserInput(): String {
    val input = Console.readLine()
    if (input == "1" || input == "2")
        return input
    if (input.length != 3)
        throw IllegalArgumentException()
    if (!input.all { char -> char.isDigit() })
        throw IllegalArgumentException()
    return input
}

fun main() {
    TODO("프로그램 구현")
}
