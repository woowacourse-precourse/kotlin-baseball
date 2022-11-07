package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartMessage()
}

fun printStartMessage() = "숫자 야구 게임을 시작합니다."

fun getNum() = Randoms.pickNumberInRange(0, 9)

fun addNotDuplicateNum(
        numbers: MutableList<Int>,
        number: Int
) {
    if (!numbers.contains(number)) numbers.add(number)
}

fun getComputerNum(): MutableList<Int> {
    val numbers = mutableListOf<Int>()

    while (numbers.size != 3) {
        val number = getNum()
        addNotDuplicateNum(numbers, number)
    }

    return numbers
}