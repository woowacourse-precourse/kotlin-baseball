package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

fun generateRandomNumber(): String {
    val randomNumberSet = mutableSetOf<Int>()
    while (randomNumberSet.size != 3) {
        randomNumberSet.add(Randoms.pickNumberInRange(1, 9))
    }
    return randomNumberSet.joinToString("")
}