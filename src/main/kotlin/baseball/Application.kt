package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val targetNumber = createNumber()
    val inputNumber = enterNumber()
}

fun createNumber(): String {
    println("숫자 야구 게임을 시작합니다.")
    val numberList = mutableListOf<Int>()
    while (numberList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber)
        }
    }
    return numberList.joinToString("")
}

fun enterNumber(): String {
    print("숫자를 입력해주세요: ")
    return Console.readLine().trim().apply {
        if (length != 3 || !all { it.isDigit() } || isBlank()) {
            throw IllegalArgumentException("올바르지 않은 입력값입니다.")
        }
    }
}
