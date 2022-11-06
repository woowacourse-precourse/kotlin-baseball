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

fun validatePlayInput(input: String) {
    val nums = input.toList()

    if (nums.size != 3 ||
        nums.any { it !in '1'..'9' } ||
        nums.distinct() != nums) {
        throw IllegalArgumentException("1부터 9사이의 수로 이루어진 중복 없는 수를 입력해주세요 ")
    }
}

fun validateEndInput(input: String) {
    if (!(input == "1" || input == "2")) {
        throw IllegalArgumentException("1 혹은 2를 입력해야합니다.")
    }
}

fun splitUserInput(input: String) =
    input.toList()
        .map { it.digitToInt() }


