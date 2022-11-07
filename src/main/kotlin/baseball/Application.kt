package baseball

fun main() {
    val baseballGame =
        BaseballGame(ComputerNumbers(RandomNumberGenerator.nDigitMap(BaseballSetting.DIGIT_NUMBER.number)))

    baseballGame.start()
}
