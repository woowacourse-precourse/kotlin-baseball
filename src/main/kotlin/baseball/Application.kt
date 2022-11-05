package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val targetNumber = createNumber()
    startGame()
    val inputNumber = enterNumber(Console.readLine().trim())
}

fun startGame() {
    println("숫자 야구 게임을 시작합니다.")
}

fun createNumber(): String {
    val numberList = mutableListOf<Int>()
    while (numberList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber)
        }
    }
    return numberList.joinToString("")
}


fun enterNumber(input: String): String {
    print("숫자를 입력해주세요: ")
    if (input.length != 3 || !input.all { it.isDigit() } || input.isBlank()) {
        throw IllegalArgumentException("올바르지 않은 입력값입니다.")
    }
    return input
}
