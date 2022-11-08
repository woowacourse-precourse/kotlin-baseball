package baseball

fun validationUserInputNumber(userInputNumber: String) {
    if (userInputNumber.isEmpty()) {
        throw IllegalArgumentException("입력값이 비었습니다.")
    }
    if (userInputNumber.contains(" ")) {
        throw IllegalArgumentException("공백을 포함하지 않고 입력해주세요.")
    }
    if (!userInputNumber.matches(Regex("^\\d*\$"))) {
        throw IllegalArgumentException("숫자로 이루어진 값만 입력될 수 있습니다.")
    }
    if (userInputNumber.length != 3) {
        throw IllegalArgumentException("3자리의 숫자를 입력해주세요.")
    }
    if (userInputNumber[0] == userInputNumber[1]
        || userInputNumber[0] == userInputNumber[2]
        || userInputNumber[1] == userInputNumber[2]
    ) {
        throw IllegalArgumentException("서로 다른 수로 이루어져야합니다.")
    }
}

fun validationUserInputRestart(userInput: String) {
    if (userInput != "1" && userInput != "2") {
        throw IllegalArgumentException("1 또는 2의 값을 입력하세요.")
    }
}