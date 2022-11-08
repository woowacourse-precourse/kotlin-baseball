package baseball

fun checkExceptionOnNumbers(input: String) {
    isInteger(input)
    isHavingDuplicated(input)
    isNumberOfDigitsCorrect(input)
}

fun isInteger(input: String) {
    try {
        input.toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException("숫자가 아닌 문자를 입력했습니다.")
    }
}

fun isHavingDuplicated(input: String) {
    for(x in input) {
        if(input.count { it == x } > 1) {
            throw IllegalArgumentException("중복된 숫자가 있습니다.")
        }
    }
}

fun isNumberOfDigitsCorrect(input: String) {
    if(input.length != NUM_DIGITS) {
        throw IllegalArgumentException("입력된 값의 길이가 규칙에 맞지 않습니다.")
    }
}