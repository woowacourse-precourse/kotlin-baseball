package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun createComputerNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        var randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}
