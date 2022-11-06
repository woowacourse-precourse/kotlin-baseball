package baseball

import camp.nextstep.edu.missionutils.Console


fun inputUserNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    var numbers = input!!
        .map {
            it.toString()
                .toInt()
        }
        .toMutableList()
    checkUnCorrectLength(numbers)
    checkUnCorrectNumber(numbers)

    return numbers
}

fun checkUnCorrectLength(numbers: MutableList<Int>) {
    if (numbers.count() != 3) {
        throw IllegalArgumentException("3자리 수만 입력 가능합니다.")
    }
}

fun checkUnCorrectNumber(numbers: MutableList<Int>) {
    for (number in numbers) {
        if (number > 9 || number < 1) {
            throw IllegalArgumentException("1에서 9까지의 수만 입력 가능합니다.")
        }
    }
}

