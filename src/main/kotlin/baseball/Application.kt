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
    val nums = input.toList()

    // 3자리 여부
    if (nums.size != 3) return false

    // 1~9 사이의 숫자 여부
    if (nums.any { it !in '1'..'9' }) return false

    // 중복 여부
    if (nums.distinct() != nums) return false

    return true
}

fun splitUserInput(input: String) =
    input.toList()
        .map { it.digitToInt() }


