package baseball

fun main() {
    val baseballGame =
        BaseballGame(ComputerNumbers(RandomNumberGenerator.nDigitMap(BaseballSetting.DIGIT_NUMBER.number)))

    try {
        baseballGame.start()
    } catch (exception: IllegalArgumentException){
        BaseballString.ILLEGAL_ARGUMENT.print()
    }
}
