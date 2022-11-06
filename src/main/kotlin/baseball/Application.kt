package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        val computer = generateRandomThreeDigits()

        while (!readAndCompare(computer).allMatched())

        if (finish()) {
            break
        }
    }
}

fun readAndCompare(computer: List<Int>): CompResult {
    print("숫자를 입력해주세요 : ")
    val user = Console.readLine()
    validatePlayInput(user)

    val compResult = CompResult(computer, splitUserInput(user))
    println(compResult.toString())

    return compResult
}

fun finish(): Boolean {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input = Console.readLine()
    validateEndInput(input)
    return input == "2"
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


