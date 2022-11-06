package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = randomNumber()
    TODO("프로그램 구현")
}

fun randomNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val number = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(number)) {
            computerNumber.add(number)
        }
    }
    return computerNumber
}