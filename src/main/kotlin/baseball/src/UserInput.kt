package baseball.src

import camp.nextstep.edu.missionutils.Console


fun inputUserNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    var input = Console.readLine()
    var numbers = input!!
        .map {
            it.toString()
                .toInt()
        }
        .toMutableList()
    checkUnCorrectLength(numbers)
    checkUnCorrectNumber(numbers)
    checkDuplicatedNumber(numbers)

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

fun checkDuplicatedNumber(numbers: MutableList<Int>) {
    if (numbers[0] == numbers[1] || numbers[0] == numbers[2] || numbers[1] == numbers[2]) {
        throw IllegalArgumentException("중복되지 않는 수만 입력 가능합니다.")
    }
}

