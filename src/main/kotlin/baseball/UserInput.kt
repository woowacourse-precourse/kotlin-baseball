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
    validate_3digit(numbers)
    validate_Number9to1(numbers)

    return numbers
}

fun validate_3digit(numbers: MutableList<Int>) {
    if (numbers.count() != 3) {
        throw IllegalArgumentException("3자리 수만 입력 가능합니다.")
    }
}

fun validate_Number9to1(numbers: MutableList<Int>) {
    for (number in numbers) {
        if (number > 9 || number < 1) {
            throw IllegalArgumentException("1에서 9까지의 수만 입력 가능합니다.")
        }
    }
}

