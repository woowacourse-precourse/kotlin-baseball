package baseball

import camp.nextstep.edu.missionutils.Randoms

var randomGeneratedNumber: Int? = 0
fun main() {
    generateRandomNumber()
}

fun generateRandomNumber() {
    val randomNumbersSet = mutableSetOf<Int>()

    while (randomNumbersSet.size != 3) {
        randomNumbersSet.add(
            Randoms.pickNumberInRange(1, 9)
        )
    }

    randomGeneratedNumber = randomNumbersSet.joinToString("").toIntOrNull()
}