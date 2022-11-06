package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun generateRandomThreeDigits(): List<Int> {
    val digits = mutableListOf<Int>()
    while (digits.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber)
        }
    }
    return digits
}

fun validateUserInput(input: String): Boolean {
    TODO("유저 입력 검사")
}

fun splitUserInput(input: String): List<Int> {
    TODO("유저 입력 각 자릿수 분리")
}


