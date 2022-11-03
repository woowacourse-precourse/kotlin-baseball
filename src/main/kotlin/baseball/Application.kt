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

fun checkInputNumberValid(input: String): Boolean {
    val inputNumberSet = input.toSet()
    return Regex("[1-9]{3}").matches(input) && inputNumberSet.size == 3
}

fun checkEndingNumberValid(input: String): Boolean = input == "1" || input == "2"