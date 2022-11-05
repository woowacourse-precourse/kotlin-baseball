package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val targetNumber: String = createNumber()
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
