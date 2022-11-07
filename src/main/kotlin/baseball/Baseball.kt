package baseball

class Baseball(private val input: Input) {
    private val guide = Guide()
    private val computer = Computer()
    private val stringToIntegerListConverter = StringToIntegerList()

    fun start() {
        guide.start()
        play()
    }

    private fun play() {
        computer.generateNumbers()

        guide.input()

        var win = false
        while (!win) {
            val userInput = input.get()

            val validators = listOf(
                StringLengthVerifier(3),
                OneToNineOnlyVerifier(),
                NoSameCharacterVerifier(),
            )
            input.validCheck(userInput, validators)

            val userInputIntegerList = stringToIntegerListConverter.convert(userInput)
            val ballsStrikes = computer.countBallsStrikes(userInputIntegerList)

            guide.ballsStrikes(ballsStrikes)

            win = computer.isWin(ballsStrikes)
        }

        gameOver()
    }

    private fun gameOver() {}
}
