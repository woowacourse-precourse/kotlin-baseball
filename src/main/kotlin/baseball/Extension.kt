package baseball

fun String.isNotDuplicated(): Boolean {
    val setOfUserInput = mutableSetOf<Int>()
    this.map { it.digitToInt() }.forEach {
        setOfUserInput.add(it)
    }
    return setOfUserInput.size == 3
}

fun String.isNotException(
    exceptionType: ExceptionType
): Boolean {
    return when (exceptionType) {
        is ExceptionType.GameException -> {
            if (this.isEmpty() || this.length > 3) {
                false
            } else this.all { Character.isDigit(it) } && this.length == 3
        }

        is ExceptionType.RetryException -> {
            if (this.isEmpty() || this.length > 1) {
                false
            } else this.all { Character.isDigit(it) } && this.length == 1 && (this == "1" || this == "2")
        }
    }
}

fun String.gameResult(): GameResultType {
    val calculator = Calculator(userInput = this)
    calculator.countBallAndStrike()
    // 유저
    return if (this == Computer.randomNumber) GameResultType.CorrectResult
    else if (
        !this.contains(Computer.randomNumber[0]) &&
        !this.contains(Computer.randomNumber[1]) &&
        !this.contains(Computer.randomNumber[2])
    ) GameResultType.NothingResult
    else GameResultType.NormalResult(
        calculator.ballAndStrike.first,
        calculator.ballAndStrike.second
    )
}